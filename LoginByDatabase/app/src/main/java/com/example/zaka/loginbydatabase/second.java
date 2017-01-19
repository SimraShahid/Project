package com.example.zaka.loginbydatabase;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
/**
 * Created by zaka on 1/18/17.
 */

public class second extends  AppCompatActivity{

    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        SharedPreferences settings = getSharedPreferences("MYPREFS", Context.MODE_PRIVATE);
        username = settings.getString("UserName", "");
        TextView tv=(TextView)findViewById(R.id.txt2welcome);
        tv.setText(username);





    }
}
