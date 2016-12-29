package com.khavronsky.blogreader.Presentation.WPPosts;


import java.util.ArrayList;
import java.util.List;

public class FakeData {


    public static List<Model> getFakePostList() {

        List<Model> fakeData = new ArrayList<>();

        fakeData.add(newModel(1, "Title1", "Some content1", "http://ivan24t9.bget.ru/wp-content/uploads/2016/12/test-825x510.png") );
        fakeData.add(newModel(2, "Title2", "Some content2", "http://ivan24t9.bget.ru/wp-content/uploads/2016/12/test-825x510.png") );
        fakeData.add(newModel(3, "Title3", "Some content3", "http://ivan24t9.bget.ru/wp-content/uploads/2016/12/test-825x510.png") );
        fakeData.add(newModel(4, "Title4", "Some content4", "http://ivan24t9.bget.ru/wp-content/uploads/2016/12/test-825x510.png") );
        return fakeData;
    }

    private static Model newModel(int id, String urlImg, String content, String title) {
        Model model = new Model();
        model.setId(id);
        model.setTitle(title);
        model.setContent(content);
        model.setUrlImg(urlImg);
        return model;
    }
}