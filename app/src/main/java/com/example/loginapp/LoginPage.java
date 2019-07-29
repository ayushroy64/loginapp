package com.example.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginPage extends AppCompatActivity {
    EditText username, password;
    Button login;
    SharedPreferences sp;
    String loginstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        sp = getSharedPreferences("key", 0);
        loginstatus = sp.getString("Login", "");

        username = findViewById(R.id.usernameedit);
        password = findViewById(R.id.passwordedit);

        try{
            if(loginstatus.equals("true")){
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                String uname = sp.getString("Username","");
                intent.putExtra("Username","uname");
                startActivity(intent);
                finish();
            }
        }
        catch (Exception e){}

        login = findViewById(R.id.login_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if(uname.equals("admin")&&pass.equals("123")){

                    Intent intent = new Intent(LoginPage.this,MainActivity.class);
                    intent.putExtra("Username", uname);

                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("Login","true");
                    editor.putString("Username",uname);
                    editor.putString("Password",pass);
                    editor.apply();

                    startActivity(intent);

                    finish();
            }



            }
        });
    }

}
