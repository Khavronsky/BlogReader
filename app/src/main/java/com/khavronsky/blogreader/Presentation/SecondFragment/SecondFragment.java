package com.khavronsky.blogreader.Presentation.SecondFragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.khavronsky.blogreader.Presentation.MainActivity;
import com.khavronsky.blogreader.Presentation.ThirdFragment.ThirdFragment;
import com.khavronsky.blogreader.R;


public class SecondFragment extends Fragment {
    TextView textView;
    ImageButton imageButton;

    public SecondFragment() {
    }
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
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

        View view = inflater.inflate(R.layout.fragment_second, container, false);
        textView = (TextView) view.findViewById(R.id.tvFragment2);
        imageButton = (ImageButton) view.findViewById(R.id.second_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity=(MainActivity)getActivity();
                mainActivity.setDrawerIndicatorEnabled(false);
                mainActivity.startFragment(ThirdFragment.class);
            }
        });
        return view;
    }
}
