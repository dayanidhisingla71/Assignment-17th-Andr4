package com.example.user.login_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends AppCompatActivity {

    EditText fullname,password,email,address,dob;
    Button submit,member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        fullname=(EditText)findViewById(R.id.Fullname);
         password=(EditText)findViewById(R.id.password);
        email=(EditText)findViewById(R.id.email);
        address=(EditText)findViewById(R.id.address);
        dob=(EditText)findViewById(R.id.dob);
        member=(Button)findViewById(R.id.member) ;
        member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  Intent intent=new Intent(getApplicationContext(),login.class);
                startActivity(intent);
            }
        });
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if(fullname.getText().toString().equals(""))
                {
                    fullname.setError("Enter valid name");
                }
                else  if(password.getText().toString().equals(""))
                {
                    password.setError("Enter valid password");
                }
                else  if(email.getText().toString().equals(""))
                {
                    email.setError("Enter valid email");
                }
                else  if(address.getText().toString().equals(""))
                {
                    address.setError("Enter valid address");
                }
                else  if(dob.getText().toString().equals(""))
                {
                    dob.setError("Enter valid dob");
                }
                SharedPreferences preferences=getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String newFullName=fullname.getText().toString();
                String newEmail=email.getText().toString();
                String newPassword=password.getText().toString();
                String newAddress=address.getText().toString();
                String newDob=dob.getText().toString();
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString(newEmail+newPassword+"data",newEmail+"\n"+newEmail);
                editor.commit();
                Intent intent=new Intent(getApplicationContext(),login.class);
                startActivity(intent);
            }
        });
    }
}
