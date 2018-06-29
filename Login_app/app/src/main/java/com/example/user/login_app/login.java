package com.example.user.login_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText email=(EditText)findViewById(R.id.email);
        final EditText password=(EditText)findViewById(R.id.password);
        Button Login=(Button)findViewById(R.id.Login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=email.getText().toString();
                String Password=password.getText().toString();
                SharedPreferences preferences=getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String userDetails=preferences.getString(Email+Password+"data","Username or Password is Incorrect");
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("display",userDetails);
                editor.commit();
                Intent displayScreen=new Intent(getApplicationContext(),diaplay.class);
                startActivity(displayScreen);
            }
        });
    }
}
