package com.mksengun.loginregistertransition;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    View rootView;

    FrameLayout frameRegister;
    ProgressBar progressBar;
    Button buttonLogin;

    public LoginFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_login, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.PB_login_fragment);
        buttonLogin = (Button) rootView.findViewById(R.id.BT_confirm_login_fragment);
        frameRegister = (FrameLayout) rootView.findViewById(R.id.FL_register_login_fragment);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
            }
        });

        frameRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });


        return rootView;
    }

}
