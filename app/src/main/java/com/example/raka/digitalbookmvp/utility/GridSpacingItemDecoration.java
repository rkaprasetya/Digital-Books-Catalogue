package com.example.raka.digitalbookmvp.utility;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int spanCount;
    private int spacing;
    private boolean includeEdge;
    private Context context;

    public GridSpacingItemDecoration(Context context, int spanCount,int spacing, boolean includeEdge){
        this.context = context;
        this.spacing = dpToPx(spacing);
        this.includeEdge = includeEdge;
        this.spanCount = spanCount;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int column = position % spanCount;
        if (includeEdge){
            outRect.left = spacing - getDistanceLeft(column);
            outRect.right = spacing - getDistanceRight(column);
            if (position < spanCount){
                outRect.top = spacing;
            }
            outRect.bottom = spacing;
        }else{
            outRect.left = getDistanceLeft(column);
            outRect.right = spacing - getDistanceRight(column);
            if (position >= spanCount){
                outRect.top = spacing;
            }
        }
        super.getItemOffsets(outRect, view, parent, state);
    }
    private int getDistanceLeft(int column){
        return column * spacing / spanCount;
    }
    private int getDistanceRight(int column){
        return (column + 1)* spacing/spanCount;
    }
    private int dpToPx(int spacing) {
        Resources r = context.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, spacing,r.getDisplayMetrics()));
    }
}
