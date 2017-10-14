package com.belatrix.fundamentals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.belatrix.fundamentals.storage.PreferencesHelper;


public class LoginActivity extends AppCompatActivity {

    private Button btnLogin,btnRegister;
    private EditText eteUsername;
    private EditText etePassword;
    private String username;
    private String password;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //setUpSp();
        init();
    }

    /*private void setUpSp() {
        sharedPreferences=
                getSharedPreferences("com.belatrix.fundamentals", Context.MODE_PRIVATE);
    }*/

    private void init() {
        eteUsername=(EditText)findViewById(R.id.eteUsername);
        etePassword=(EditText)findViewById(R.id.etePassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnRegister=(Button)findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateForm()) {
                    gotoMain();
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUserRegister();
            }
        });
    }

    private void gotoUserRegister() {
        Intent intent= new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    private void gotoMain() {
        savePreferences();
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void savePreferences() {
        PreferencesHelper.saveSession(this,username,password);
    }

    private void clearForm(){
        eteUsername.setError(null);
        etePassword.setError(null);
    }

    private boolean validateForm() {
        clearForm();
        username= eteUsername.getText().toString();
        password= etePassword.getText().toString();

        if(username.isEmpty())
        {
            eteUsername.setError("Error campo username");
            return false;
        }
        if(password.isEmpty())
        {
            etePassword.setError("Error campo password");
            return false;
        }
        return true;
    }

}
