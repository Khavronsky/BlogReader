package com.khavronsky.blogreader.Presentation.WPPosts;


import android.os.Handler;

import java.util.List;

public class PostPresenter {
    private IView view;
    private Handler handler = new Handler();

    public PostPresenter(IView view) {
        this.view = view;

    }

    void loadData(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                final List <Model> modelList = FakeData.getFakePostList();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        view.showData(modelList);
                    }
                });
            }
        }).start();
    }
}
