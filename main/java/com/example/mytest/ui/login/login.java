package com.example.mytest.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mytest.MainActivity;
import com.example.mytest.R;

public class login extends AppCompatActivity implements View.OnClickListener{

    Button btn_loginIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        btn_loginIn = (Button) findViewById(R.id.btn_login);
        btn_loginIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String userName="",password="";
        EditText editText1 =(EditText)findViewById(R.id.userName);
        userName=editText1.getText().toString();
        EditText editText2 =(EditText)findViewById(R.id.Password);
        password=editText2.getText().toString();

        if (v.getId() == btn_loginIn.getId()&&userName.equals("test")&&password.equals("test")){
            Intent intent = new Intent();
            intent.setClass(this, MainActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "账号密码错误", Toast.LENGTH_SHORT).show();
        }

    }
}