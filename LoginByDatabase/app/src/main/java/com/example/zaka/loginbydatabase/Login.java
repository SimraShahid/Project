package com.example.zaka.loginbydatabase;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by zaka on 1/18/17.
 */

public class Login extends AppCompatActivity{

    DataBaseHelper database=new DataBaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        database.insertData();
    }

    public void buttonEvent(View view) {

        EditText editTextUsername=(EditText)findViewById(R.id.edtName);
        String unamestr=editTextUsername.getText().toString();
        EditText editTextPassword=(EditText)findViewById(R.id.edtpassword);
        String passwordstr=editTextPassword.getText().toString();

        SharedPreferences settings = getSharedPreferences("MYPREFS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String password = database.matchAuthentication(unamestr);
        if (passwordstr.equals(password)){

            Intent i=new Intent(Login.this,second.class);
            editor.putString("UserName", unamestr);
            editor.commit();
            startActivity(i);
        }else {
            Toast toast= Toast.makeText(Login.this,"Username or Password Incorrect",Toast.LENGTH_SHORT);
        }
  }
 }
