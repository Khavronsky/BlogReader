package com.khavronsky.blogreader.Presentation.FourthFragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.khavronsky.blogreader.Presentation.MainActivity;
import com.khavronsky.blogreader.Presentation.WPPosts.FirstFragment;
import com.khavronsky.blogreader.R;


public class FourthFragment extends Fragment {
    TextView textView;
    ImageButton imageButton;

    public FourthFragment() {
    }

    public static FourthFragment newInstance() {
        FourthFragment fragment = new FourthFragment();
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
        View view = inflater.inflate(R.layout.fragment_fourth, container, false);
        textView = (TextView) view.findViewById(R.id.tvFragment4);
        imageButton = (ImageButton) view.findViewById(R.id.fourth_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity=(MainActivity)getActivity();
                mainActivity.setDrawerIndicatorEnabled(false);
                mainActivity.startFragment(FirstFragment.class);
            }
        });
        return view;    }
}
