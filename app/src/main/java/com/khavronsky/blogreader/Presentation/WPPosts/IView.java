package com.khavronsky.blogreader.Presentation.WPPosts;


import java.util.List;

public interface IView {
    void showData(List<Model> list);
    void showButtonText(String text);

}
