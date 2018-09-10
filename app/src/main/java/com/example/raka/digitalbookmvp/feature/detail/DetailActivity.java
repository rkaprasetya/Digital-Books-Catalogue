package com.example.raka.digitalbookmvp.feature.detail;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.raka.digitalbookmvp.R;
import com.example.raka.digitalbookmvp.base.mvp.MvpActivity;
import com.example.raka.digitalbookmvp.model.ItemsItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends MvpActivity<DetailPresenter> implements DetailView, View.OnClickListener {
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.descriptionLayout)
    CardView descriptionLayout;
    @BindView(R.id.buttonRefresh)
    FloatingActionButton buttonRefresh;

    private String bookId;

    @Override
    protected DetailPresenter createPresenter() {
        return new DetailPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        buttonRefresh.setOnClickListener(this);
        bookId = getIntent().getStringExtra("id");
        presenter.loadData(bookId);
    }

    @Override
    public void showLoading() {
        progress.setVisibility(View.VISIBLE);
        descriptionLayout.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        progress.setVisibility(View.GONE);
        descriptionLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void getDataSuccess(ItemsItem item) {
        description.setText(Html.fromHtml(item.getVolumeInfo().getDescription()));
        Glide.with(this).load(item.getVolumeInfo().getImageLinks().getThumbnail()).into(image);
        collapsingToolbar.setTitle(item.getVolumeInfo().getTitle());
    }

    @Override
    public void getDataFail(String message) {
        Toast.makeText(this, "Please load again", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshData() {
        presenter.loadData(bookId);
    }
    @Override
    public void onClick(View view) {
        refreshData();
    }
}
