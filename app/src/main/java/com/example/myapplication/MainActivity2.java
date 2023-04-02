package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.myapplication.objectWalk.MySurfaceView;


public class MainActivity2 extends AppCompatActivity {

    private MySurfaceView surfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        surfaceView = findViewById(R.id.surfaceView);
        Button leftButton = findViewById(R.id.leftButton);
        Button rightButton = findViewById(R.id.rightButton);
        Button upButton = findViewById(R.id.upButton);
        Button downButton = findViewById(R.id.downButton);

//        leftButton.setOnClickListener(v -> surfaceView.moveLeft());
//
//        rightButton.setOnClickListener(v -> surfaceView.moveRight());
//
//        upButton.setOnClickListener(v -> surfaceView.moveUp());
//
//        downButton.setOnClickListener(v -> surfaceView.moveDown());

    }
}