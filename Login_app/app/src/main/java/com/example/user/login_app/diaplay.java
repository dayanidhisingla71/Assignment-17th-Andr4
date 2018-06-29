package com.example.user.login_app;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.user.login_app.R.*;

public class diaplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diaplay);
        SharedPreferences preferences=getSharedPreferences("MYPREFS",MODE_PRIVATE);
        String display=preferences.getString("display","");
        TextView displayInfo=(TextView)findViewById(R.id.textViewName);
        displayInfo.setText(display);

    }
}
