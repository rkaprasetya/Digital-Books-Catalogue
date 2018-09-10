package com.example.raka.digitalbookmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.raka.digitalbookmvp.R;
import com.example.raka.digitalbookmvp.model.ItemsItem;
import com.bumptech.glide.Glide;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private List<ItemsItem> books;
    private int rowLayout;
    private Context context;


    public BookAdapter(List<ItemsItem> books, int rowLayout, Context context) {
        this.books = books;
        this.rowLayout = rowLayout;
        this.context = context;
    }


    @Override
    public BookViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder( BookViewHolder holder, int position) {

        try {
            holder.tvTitle.setText(books.get(position).getVolumeInfo().getTitle());
            holder.tvAuthor.setText(String.format("Author by %s",books.get(position).getVolumeInfo().getAuthors().get(0)));
            Glide.with(context).load(books.get(position).getVolumeInfo().getImageLinks().getThumbnail()).into(holder.ivThumbnail);
            holder.ratingBar.setRating((float) books.get(position).getVolumeInfo().getAverageRating());
        }catch (NullPointerException e){
            holder.ratingBar.setRating(0);
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle,tvAuthor;
        ImageView ivThumbnail;
        RatingBar ratingBar;
        BookViewHolder(View v){
            super(v);
            tvTitle = v.findViewById(R.id.tv_title);
            tvAuthor =  v.findViewById(R.id.tv_author);
            ivThumbnail =  (ImageView) v.findViewById(R.id.thumbnail);
            ratingBar = v.findViewById(R.id.ratingbar);
        }
    }
}
