package com.khavronsky.blogreader.Presentation.SecondFragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.khavronsky.blogreader.Presentation.MainActivity;
import com.khavronsky.blogreader.Presentation.ThirdFragment.ThirdFragment;
import com.khavronsky.blogreader.R;


public class SecondFragment extends Fragment {
    TextView textView;
    Button imageButton;

    public SecondFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private static final String TAG = "SecondFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        textView = (TextView) view.findViewById(R.id.tvFragment2);
        textView.setText("TEST");
        imageButton = (Button) view.findViewById(R.id.second_button);

        imageButton.setClickable(true);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.setDrawerIndicatorEnabled(false);
                mainActivity.startFragment(ThirdFragment.class);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
