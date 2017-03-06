package com.mksengun.loginregistertransition;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    ProgressBar progressBar;
    TextInputLayout textInputEmail, textInputPassword, textInputConfirmPassword;

    View rootView;
    Button buttonCreate;


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_register, container, false);

        textInputEmail = (TextInputLayout) rootView.findViewById(R.id.TI_email_register_fragment);
        textInputPassword = (TextInputLayout) rootView.findViewById(R.id.TI_password_register_fragment);
        textInputConfirmPassword = (TextInputLayout) rootView.findViewById(R.id.TI_password2_register_fragment);
        buttonCreate = (Button) rootView.findViewById(R.id.BT_create_register_fragment);
        progressBar = (ProgressBar) rootView.findViewById(R.id.PB_register_fragment);

        AnimationHandler animationHandler = new AnimationHandler(rootView);

        textInputEmail.setAnimation(animationHandler.fadeIn());
        textInputPassword.setAnimation(animationHandler.fadeIn());
        textInputConfirmPassword.setAnimation(animationHandler.fadeIn());
        buttonCreate.setAnimation(animationHandler.fadeIn());

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
            }
        });


        // Inflate the layout for this fragment
        return rootView;
    }

}
