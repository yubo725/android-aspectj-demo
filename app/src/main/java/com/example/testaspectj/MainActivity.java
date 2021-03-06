package com.example.testaspectj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (!ClickUtil.isFastClick()) {
//                    startActivity(new Intent(MainActivity.this, OtherActivity.class));
//                }
                startActivity(new Intent(MainActivity.this, OtherActivity.class));
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            @ClickOnce
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OtherActivity.class));
            }
        });

        findViewById(R.id.btn3).setOnClickListener(this);
    }

    @ClickOnce
    private void toOtherActivity() {
        startActivity(new Intent(MainActivity.this, OtherActivity.class));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn3) {
            toOtherActivity();
        }
    }
}