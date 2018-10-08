package com.example.davher.factorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView = (TextView) findViewById(R.id.myTextView);

        Bundle miBundle = getIntent().getExtras();
        textView.setText(miBundle.getString("TEXTO"));
    }
}
