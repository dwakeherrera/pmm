package com.example.davher.fragmentodiversos;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.app.DialogFragment;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int mStackPosition = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        // BotÃ³n de aÃ±adir fragments
        Button button = (Button) findViewById(R.id.nuevoFragmento);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {addFragment();}
        });
        if (savedInstanceState == null) {
            // aÃ±adir el primer fragment
            Fragment newFragment = FragmentoSimple.newInstance(mStackPosition);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.mostrarFragmento, newFragment).commit();
        } else {
            mStackPosition = savedInstanceState.getInt("position");
        }
        Button buttonDialogF = (Button)findViewById(R.id.mostrarDialogoFragmento);
        Button buttonDialog = (Button)findViewById(R.id.mostrarDialogo);
        buttonDialogF.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {showDialogF();}
        });
        buttonDialog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {showDialog();}
        });
    }

    void addFragment() {
        mStackPosition++;
        // Instanciamos nuevo Fragment
        Fragment newFragment = FragmentoSimple.newInstance(mStackPosition);
        // Se aÃ±ade el Fragment a la actividad
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.mostrarFragmento, newFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);// poneos la transacion a la pila
        ft.commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", mStackPosition);
    }

    void showDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Selecciona acción a realizar")
                .setPositiveButton("Nuevo",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                addFragment();
                            }
                        }
                )
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // no hacer nada
                            }
                        }
                )
                .setNeutralButton("Atrás",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                getFragmentManager().popBackStack();
                            }
                        }
                )
                .create().show();
    }

    void showDialogF() {
        DialogFragment newFragment = MyDialogFragment.newInstance();
        newFragment.show(getFragmentManager(), "dialog");
    }
}