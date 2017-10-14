package com.belatrix.fundamentals;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.belatrix.fundamentals.storage.PreferencesHelper;

import java.util.Timer;
import java.util.TimerTask;


public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_SCREEN_DELAY = 2000;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //setUpSP();

        TimerTask task = new TimerTask()
        {
            @Override
            public void run() {

                Intent intent;
                Bundle bundle= new Bundle();
                bundle.putString("KEY","VALOR");
                boolean session= PreferencesHelper.isSignedIn(SplashActivity.this);
                if(session)
                {
                    intent=new Intent(SplashActivity.this, MainActivity.class);
                }else {
                    intent = new Intent(SplashActivity.this, LoginActivity.class);
                }

                Log.d("CONSOLE","session "+session);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

    private void setUpSP() {
        sharedPreferences=
        getSharedPreferences("com.belatrix.fundamentals", Context.MODE_PRIVATE);

        //editor
        SharedPreferences.Editor spEditor=sharedPreferences.edit();

        //edición
        spEditor.putString("NAME", "MyApp");
        spEditor.putBoolean("SESSION",true);
        spEditor.apply();


        //consultar
        //boolean session= sharedPreferences.contains("SESSION");
        boolean session= sharedPreferences.getBoolean("SESSION",false);
        if(session){
            Toast.makeText(this,"Existe session ",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"No existe session ",Toast.LENGTH_LONG).show();
        }

    }

}
