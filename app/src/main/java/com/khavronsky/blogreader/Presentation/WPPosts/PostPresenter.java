package com.khavronsky.blogreader.Presentation.WPPosts;


import android.os.Handler;

import java.util.List;

public class PostPresenter  {
    private IView view;
    private Handler handler = new Handler();
    private String newString;


    public PostPresenter(IView view) {
        this.view = view;
    }

    public void loadButtonText() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        view.showButtonText("load...");
                    }
                });

                Data data = new Data();
                data.setCallback(new Data.Callback() {
                    @Override
                    public void callbackReturn(String text) {
                        newString = text;
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                view.showButtonText(newString);
                            }
                        });
                    }
                });
                data.getData();
            }
        }).start();
    }

    void loadData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final List<Model> modelList = FakeData.getFakePostList();
                try {
                    Thread.sleep(2000);
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