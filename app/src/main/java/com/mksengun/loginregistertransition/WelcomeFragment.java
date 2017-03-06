package com.mksengun.loginregistertransition;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {

    View rootView;
    RelativeLayout layoutLogin, layoutRegister;
    FrameLayout frameLogin, frameRegister;
    TextView textTitleLogin, textSubheaderLogin, textTitleRegister, textSubheaderRegister;

    public WelcomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_welcome, container, false);

        layoutLogin = (RelativeLayout) rootView.findViewById(R.id.RV_login_welcome_fragment);
        layoutRegister = (RelativeLayout) rootView.findViewById(R.id.RL_register_welcome_fragment);
        frameLogin = (FrameLayout) rootView.findViewById(R.id.FL_login_welcome_fragment);
        frameRegister = (FrameLayout) rootView.findViewById(R.id.FL_register_welcome_fragment);
        textTitleLogin = (TextView) rootView.findViewById(R.id.TV_title_login_welcome_fragment);
        textSubheaderLogin = (TextView) rootView.findViewById(R.id.TV_subheader_login_welcome_fragment);
        textTitleRegister = (TextView) rootView.findViewById(R.id.TV_title_register_welcome_fragment);
        textSubheaderRegister = (TextView) rootView.findViewById(R.id.TV_subheader_register_welcome_fragment);

        final LoginFragment loginFragment = new LoginFragment();
        final RegisterFragment registerFragment = new RegisterFragment();


        //Set Return, Enter, Exit animations
        loginFragment.setSharedElementReturnTransition(TransitionInflater.from(getActivity())
                .inflateTransition(R.transition.trans_change));
        loginFragment.setExitTransition(TransitionInflater.from(getActivity())
                .inflateTransition(android.R.transition.move));
        loginFragment.setSharedElementEnterTransition(TransitionInflater.from(getActivity())
                .inflateTransition(R.transition.trans_change));
        loginFragment.setEnterTransition(TransitionInflater.from(getActivity())
                .inflateTransition(android.R.transition.move));
        registerFragment.setSharedElementReturnTransition(TransitionInflater.from(getActivity())
                .inflateTransition(R.transition.trans_change));
        registerFragment.setExitTransition(TransitionInflater.from(getActivity())
                .inflateTransition(android.R.transition.move));
        registerFragment.setSharedElementEnterTransition(TransitionInflater.from(getActivity())
                .inflateTransition(R.transition.trans_change));
        registerFragment.setEnterTransition(TransitionInflater.from(getActivity())
                .inflateTransition(android.R.transition.move));


        frameLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction = supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, loginFragment)
                        .addSharedElement(layoutLogin,
                                getActivity().getResources().getString(R.string.trans_layout_login))
                        .addSharedElement(layoutRegister,
                                getActivity().getResources().getString(R.string.trans_layout_register))
                        .addSharedElement(textTitleLogin,
                                getActivity().getResources().getString(R.string.trans_text_title_login))
                        .addSharedElement(textSubheaderLogin,
                                getActivity().getResources().getString(R.string.trans_text_subheader_login))
                        .addToBackStack("welcome");

                // To see ripple effect
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fragmentTransaction.commit();
                    }
                }, 100);
            }
        });

        frameRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
                final FragmentTransaction fragmentTransaction = supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, registerFragment)
                        .addSharedElement(layoutLogin,
                                getActivity().getResources().getString(R.string.trans_layout_login))
                        .addSharedElement(layoutRegister,
                                getActivity().getResources().getString(R.string.trans_layout_register))
                        .addSharedElement(textTitleRegister,
                                getActivity().getResources().getString(R.string.trans_text_title_register))
                        .addSharedElement(textSubheaderRegister,
                                getActivity().getResources().getString(R.string.trans_text_subheader_register))
                        .addToBackStack("welcome");

                // To see ripple effect
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fragmentTransaction.commit();
                    }
                }, 100);
            }
        });

        return rootView;
    }

}

