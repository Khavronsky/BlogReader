package com.khavronsky.blogreader;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


public class FirstFragment extends Fragment {
    TextView textView;
    ImageButton imageButton;
    private static final String TAG = "Fragment_1";

    public FirstFragment() {
    }

    public static FirstFragment newInstance(String param1, String param2) {
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
        textView = (TextView) view.findViewById(R.id.tvFragment1);
        imageButton = (ImageButton) view.findViewById(R.id.first_button);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity=(MainActivity)getActivity();
                mainActivity.setDrawerIndicatorEnabled(false);

                ((MainActivity) getActivity()).startFragment(((MainActivity) getActivity()).secondFragment);

            }
        });
        return view;
    }
}
