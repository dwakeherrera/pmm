package com.example.davher.fragmentobasico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
    View miFragmento;
    CheckBox apareceFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miFragmento = (View)findViewById(R.id.ejemplo);
        apareceFrag = (CheckBox)findViewById(R.id.checkFrag);

        apareceFrag.setChecked(true);

        apareceFrag.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (apareceFrag.isChecked()) miFragmento.setVisibility(View.VISIBLE);
                else miFragmento.setVisibility(View.INVISIBLE);
            }
        });
    }
}
