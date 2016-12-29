package com.khavronsky.blogreader.Presentation.WPPosts;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.khavronsky.blogreader.R;

class MyViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "MyViewHolder";
    private TextView postTitle;
    private TextView postContent;
    private ImageView imageView;

    MyViewHolder(View view) {
        super(view);
        this.postTitle = (TextView) view.findViewById(R.id.postTitle);
        this.postContent = (TextView) view.findViewById(R.id.postContent);
        this.imageView = (ImageView) view.findViewById(R.id.imageView);
    }

    void setPostTitle(String postTitle) {
        this.postTitle.setText(Html.fromHtml(postTitle));
    }

    void setPostContent(String postContent) {
        this.postContent.setText(Html.fromHtml(postContent));
    }

    void setImageView(String imgUrl, String imageName, int pos) {
//        ImageUrlHelper.imageDownload(imageView, imgUrl, imageName, pos);

        Log.d(TAG, "setImageView(String url): " + imgUrl);
    }

    void setImageViewTag(String imageUrl) {
        imageView.setTag(imageUrl);
    }
}