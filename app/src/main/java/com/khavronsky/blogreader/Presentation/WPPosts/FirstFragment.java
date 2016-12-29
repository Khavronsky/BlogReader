package com.khavronsky.blogreader.Presentation.WPPosts;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.khavronsky.blogreader.R;

import java.util.List;


public class FirstFragment extends Fragment implements IView {
    TextView textView;
    ImageButton imageButton;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;




    private static final String TAG = "Fragment_1";

    public FirstFragment() {
    }

    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        Bundle bundleArgs = new Bundle();
        fragment.setArguments(bundleArgs);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        return view;
    }

    @Override
    public void showData(List<Model> list) {

    }
}