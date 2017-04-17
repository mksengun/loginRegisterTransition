package com.mksengun.loginregistertransition;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    View rootView;

    RelativeLayout relativeLayout;
    FrameLayout frameRegister;
    ProgressBar progressBar;
    Button buttonLogin;

    MainActivity mainActivity;

    EditText editTextMail, editTextPassword;


    public LoginFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_login, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.PB_login_fragment);
        buttonLogin = (Button) rootView.findViewById(R.id.BT_confirm_login_fragment);
        frameRegister = (FrameLayout) rootView.findViewById(R.id.FL_register_login_fragment);
        editTextMail = (EditText) rootView.findViewById(R.id.ET_email_login_fragment);
        editTextPassword = (EditText) rootView.findViewById(R.id.ET_password_login_fragment);

        relativeLayout = (RelativeLayout) rootView.findViewById(R.id.RV_login_fragment);

        editTextMail.setText("mksengun@gmail.com");
        editTextPassword.setText("123123");

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);


                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);

                mainActivity.mAuth.signInWithEmailAndPassword(editTextMail.getText().toString(), editTextPassword.getText().toString())
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    if (MainActivity.sCurrentUser != null) {
                                        if (MainActivity.sCurrentUser.getDisplayName() == null) {
                                            CompleteProfileFragment tmpFragment = new CompleteProfileFragment();
                                            tmpFragment.setSharedElementReturnTransition(TransitionInflater.from(getActivity())
                                                    .inflateTransition(R.transition.trans_change));
                                            tmpFragment.setExitTransition(TransitionInflater.from(getActivity())
                                                    .inflateTransition(android.R.transition.move));
                                            tmpFragment.setSharedElementEnterTransition(TransitionInflater.from(getActivity())
                                                    .inflateTransition(R.transition.trans_change));
                                            tmpFragment.setEnterTransition(TransitionInflater.from(getActivity())
                                                    .inflateTransition(android.R.transition.move));

                                            FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
                                            FragmentTransaction fragmentTransaction = supportFragmentManager
                                                    .beginTransaction()
                                                    .replace(R.id.container, tmpFragment)
                                                    .addSharedElement(progressBar,
                                                            getActivity().getResources().getString(R.string.trans_text_login))
                                                    .addToBackStack(null);
                                            fragmentTransaction.commit();
                                        } else {
                                            Toast.makeText(getActivity(), "Hoşgeldin " + MainActivity.sCurrentUser.getDisplayName(),
                                                    Toast.LENGTH_SHORT).show();
                                            progressBar.setVisibility(View.INVISIBLE);
                                        }
                                    } else {
                                        Log.e("mksengun", " mainActivity.sCurrentUser = NULL ");
                                    }
                                } else {
                                    Toast.makeText(getActivity(), task.getException().getMessage(),
                                            Toast.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.INVISIBLE);
                                }

                                // ...
                            }
                        });
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
