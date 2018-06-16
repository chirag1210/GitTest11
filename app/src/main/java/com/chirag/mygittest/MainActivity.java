package com.chirag.mygittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addNewMethod();
    }

    private void addNewMethod() {
        Log.e("", "");
    }

    public void TestUpload() {

        int i2 = 2 + 2;

        String test = "master branch";
    }


}
