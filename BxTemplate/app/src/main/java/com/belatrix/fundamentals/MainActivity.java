package com.belatrix.fundamentals;

import android.animation.Animator;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewBx;
    private TextView textViewHello;
    private View constraintLayoutContainer;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ui();
        app();
    }

    private void app() {
        imageViewBx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.v("CONSOLE", "Hello Android");
                //bla bla bla bla
                //updateText();
                rippleEffect();
                //showMessage();
                //showToast();
            }
        });
    }

    private void showToast(){
        Toast.makeText(this, "No usar toast",Toast.LENGTH_LONG).show();
    }

    private void showMessage(){
        snackbar.setText("Hello Belatrix");
        snackbar.show();
    }
    private void rippleEffect() {

        int cx = (imageViewBx.getLeft() + imageViewBx.getRight()) / 2;
        int cy = (imageViewBx.getTop() + imageViewBx.getBottom()) / 2;

        int finalRadius = Math.max(constraintLayoutContainer.getWidth()/2, constraintLayoutContainer.getHeight()/2);

        Animator anim =
                null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            anim = ViewAnimationUtils.createCircularReveal(constraintLayoutContainer, cx, cy, 0, finalRadius);
            anim.setDuration(2000);
            anim.start();
        }
    }

    private void updateText() {
        textViewHello.setText("Hello Belatrix");
    }

    private void ui() {
        constraintLayoutContainer= findViewById(R.id.constraintLayoutContainer);
        imageViewBx= (ImageView) findViewById(R.id.imageViewBx);
        textViewHello= (TextView) findViewById(R.id.textViewHello);

        snackbar= Snackbar.make(constraintLayoutContainer,"Message",Snackbar.LENGTH_LONG);
    }
}
