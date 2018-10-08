package com.example.davher.miaplicacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView1 = (TextView) findViewById(R.id.myTextView);
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.myImgButton);

        Bundle myBundle = getIntent().getExtras();
        textView1.setText(myBundle.getString("1st message"));

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override protected void onStart() {
        super.onStart();
        Toast.makeText(this, "A1: onStart", Toast.LENGTH_SHORT).show();
    }

    @Override protected void onResume() {
        super.onResume();
        Toast.makeText(this, "A1: onResume", Toast.LENGTH_SHORT).show();
    }

    @Override protected void onPause() {
        Toast.makeText(this, "A1: onPause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override protected void onStop() {
        super.onStop();
        Toast.makeText(this, "A1: onStop", Toast.LENGTH_SHORT).show();
    }
}