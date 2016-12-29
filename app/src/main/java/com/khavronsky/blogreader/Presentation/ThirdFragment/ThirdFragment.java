package com.khavronsky.blogreader.Presentation.ThirdFragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.khavronsky.blogreader.Presentation.FourthFragment.FourthFragment;
import com.khavronsky.blogreader.Presentation.MainActivity;
import com.khavronsky.blogreader.R;


public class ThirdFragment extends Fragment {
    TextView textView;
    ImageButton imageButton;

    public ThirdFragment() {
    }

    public static ThirdFragment newInstance() {
        Log.d("AAA", "newInstance: start");
        ThirdFragment fragment = new ThirdFragment();
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

        View view = inflater.inflate(R.layout.fragment_third, container, false);
        textView = (TextView) view.findViewById(R.id.tvFragment3);
        imageButton = (ImageButton) view.findViewById(R.id.third_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity=(MainActivity)getActivity();
                mainActivity.setDrawerIndicatorEnabled(false);
                mainActivity.startFragment(FourthFragment.class);
            }
        });
        return view;
    }

}
