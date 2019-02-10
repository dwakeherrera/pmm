package com.example.david.doblespinner;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    View fragmentoSpinner;
    Fragment fragmentoDesc;

    public static String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentoSpinner = (View) findViewById(R.id.spinner);
        fragmentoSpinner.setVisibility(View.VISIBLE);

        fragmentoDesc = DescFragment.newInstance();
        FragmentTransaction ftd = getFragmentManager().beginTransaction();
        ftd.add(R.id.description, fragmentoDesc).commit();
    }
}