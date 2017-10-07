package com.belatrix.fundamentals.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.belatrix.fundamentals.R;
import com.belatrix.fundamentals.ui.fragments.BlankFragmentListener;


public class MyActivity extends AppCompatActivity
        implements BlankFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    @Override
    public void actionFragment(Object object) {

    }

    @Override
    public void actionActivityCambiarColor() {

    }
}
