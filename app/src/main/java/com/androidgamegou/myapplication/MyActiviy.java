package com.androidgamegou.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androidgamegou.utiltools.UnityUtilTools;

public class MyActiviy extends Activity {

    private  static  MyActiviy instance = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.myacitivy);
        instance = this;


        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //UnityUtilTools.Vibrate(instance, 0.1f, 0.5f);
                Intent intent = new Intent();
                intent.setData(Uri.parse("pk2fb://ads?source=fb&campaign=asd&adsset=ads&adsid=123456"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //UnityUtilTools.Vibrate(instance, 0.3f, 0.5f);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //UnityUtilTools.Vibrate(instance, 1.0f, 0.7f);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //UnityUtilTools.Vibrate(instance, 0.5f, 0.3f);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //UnityUtilTools.Vibrate(instance, 0.5f, 0.5f);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //UnityUtilTools.Vibrate(instance, 0.5f, 0.7f);
            }
        });
        // ATTENTION: This was auto-generated to handle app links.

    }
}
