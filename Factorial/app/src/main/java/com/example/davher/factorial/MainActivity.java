package com.example.davher.factorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView  textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.myText);
        button = (Button) findViewById(R.id.myButton);
        textView = (TextView) findViewById(R.id.myTextView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle miBundle = new Bundle();
                miBundle.putString("TEXTO", calcularOperacion());
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });
    }

    public String calcularOperacion() {
        int n = Integer.parseInt(editText.getText().toString());
        int res = factorial(n);
        String result = n + "! = " + Integer.toString(res);
        return result;
    }

    public int factorial(int n) {
        int res = n;
        for (int i = 2; i < n; i++)
            res *= i;
        return res;
    }
}
