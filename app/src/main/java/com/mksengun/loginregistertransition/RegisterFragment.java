package com.mksengun.loginregistertransition;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    ProgressBar progressBar;
    TextInputLayout textInputEmail, textInputPassword, textInputConfirmPassword;

    View rootView;
    Button buttonCreate;

    MainActivity mainActivity;

    EditText editTextMail, editTextPassword, editTextPassword2;



    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
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

        editTextMail = (EditText) rootView.findViewById(R.id.ET_email_register_fragment);
        editTextPassword = (EditText) rootView.findViewById(R.id.ET_password_register_fragment);
        editTextPassword2 = (EditText) rootView.findViewById(R.id.ET_password2_register_fragment);

        AnimationHandler animationHandler = new AnimationHandler(rootView);

        textInputEmail.setAnimation(animationHandler.fadeIn());
        textInputPassword.setAnimation(animationHandler.fadeIn());
        textInputConfirmPassword.setAnimation(animationHandler.fadeIn());
        buttonCreate.setAnimation(animationHandler.fadeIn());

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                mainActivity.mAuth.createUserWithEmailAndPassword(editTextMail.getText().toString(), editTextPassword.getText().toString())
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d("mksengun", "createUserWithEmail:onComplete:" + task.isSuccessful());


                                if (task.isSuccessful()) {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    Toast.makeText(getActivity(), "Kayıt başarılı..",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    Toast.makeText(getActivity(), "FAILED!!",
                                            Toast.LENGTH_SHORT).show();
                                    Log.e("mksengun", "fail");
                                }

                                // ...
                            }
                        });
            }
        });


        // Inflate the layout for this fragment
        return rootView;
    }

}
