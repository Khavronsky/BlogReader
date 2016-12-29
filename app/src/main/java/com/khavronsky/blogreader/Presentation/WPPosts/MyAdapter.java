package com.khavronsky.blogreader.Presentation.WPPosts;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khavronsky.blogreader.R;

import java.util.ArrayList;
import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public void setPosts(List<Model> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    private List<Model> posts=new ArrayList<>();

    MyAdapter( ) {
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setPostTitle(posts.get(position).getTitle());
        holder.setPostContent(posts.get(position).getContent());
        holder.setImageViewTag(posts.get(position).getUrlImg());
        holder.setImageView(posts.get(position).getUrlImg(), "Img_" + position + "_" + posts.get(position).getId(), position);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}