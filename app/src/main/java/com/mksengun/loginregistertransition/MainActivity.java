package com.mksengun.loginregistertransition;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().hide();

        Fragment mFragment;
        FragmentManager mFragmentManager = getSupportFragmentManager();
        mFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        mFragment = new WelcomeFragment();

        mFragmentManager.beginTransaction().replace(R.id.container, mFragment).commit();

    }


}