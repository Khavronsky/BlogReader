package com.khavronsky.blogreader.Presentation.WPPosts;


import android.util.Log;

class Data {
    private static final String TAG = "Load...";

    interface Callback {
        void callbackReturn(String text);
    }

    private Callback callback;

    void setCallback(Callback callback) {
        this.callback = callback;
    }

    void getData() {
        try {
            Thread.sleep(500);
            Log.d(TAG, "10%\n" +
                    "..........");
            Thread.sleep(500);
            Log.d(TAG, "20%\n" +
                    "....................");

            String text = "Downloaded 20%";
            callback.callbackReturn(text);

            Thread.sleep(500);
            Log.d(TAG, "30%\n" +
                    "..............................");
            Thread.sleep(500);
            Log.d(TAG, "40%\n" +
                    "........................................");

            text = "Downloaded 40%";
            callback.callbackReturn(text);

            Thread.sleep(500);
            Log.d(TAG, "50%\n" +
                    "..................................................");
            Thread.sleep(500);
            Log.d(TAG, "60%\n" +
                    "............................................................");

            text = "Downloaded 60%";
            callback.callbackReturn(text);

            Thread.sleep(500);
            Log.d(TAG, "70%\n" +
                    "......................................................................");
            Thread.sleep(500);
            Log.d(TAG, "80%\n" +
                    "................................................................................");

            text = "Downloaded 80%";
            callback.callbackReturn(text);

            Thread.sleep(500);
            Log.d(TAG, "90%\n" +
                    "..........................................................................................");
            Thread.sleep(500);
            Log.d(TAG, "100%\n" +
                    "....................................................................................................");

            text = "Download complete";
            callback.callbackReturn(text);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}