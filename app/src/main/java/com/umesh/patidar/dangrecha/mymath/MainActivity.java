package com.umesh.patidar.dangrecha.mymath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.umesh.patidar.dangrecha.mymathmodule.MyMath;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int a = MyMath.sum(4,5);
        Log.i("abcd", "onCreate: "+a);
    }
}