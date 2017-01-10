package com.khavronsky.blogreader.Presentation.WPPosts;


public class Model {
    private int id;
    private String urlImg;
    private String content;
    private String title;

    public String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getUrlImg() {
        return urlImg;
    }

    void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    String getContent() {
        return content;
    }

    void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", urlImg='" + urlImg + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}