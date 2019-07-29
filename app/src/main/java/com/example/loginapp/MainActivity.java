package com.example.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatA{
    SharedPreferences sp;
    Button logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.log_out);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp = getSharedPreferences("key", 0);
                SharedPreferences.Editor editor = sp.edit();
                editor.remove("Login").commit();
                editor.remove("Username").commit();
                editor.remove("Password").commit();
                startActivity(new Intent(MainActivity.this, LoginPage.class));

                finish();
            }
        });
    }
}
