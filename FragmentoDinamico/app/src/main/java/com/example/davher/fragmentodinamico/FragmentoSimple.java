package com.example.davher.fragmentodinamico;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentoSimple extends Fragment {
    int mNum;
    static FragmentoSimple newInstance(int number) {
        FragmentoSimple f = new FragmentoSimple();
        // Mantenemos el número para usarlo en cualquier momento.
        Bundle args = new Bundle();
        args.putInt("num", number);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // obtenemos el número que se habia pasado como argumento en
        // la creación de la instancia
        mNum = getArguments().getInt("num");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tv = null;
        View v  = null;
        // dependiendo de si es par o impar mostramos distintos layouts
        if (mNum % 2 == 0){
            v = inflater.inflate(R.layout.fragmento_simple, container, false);
            tv = v.findViewById(R.id.texto);
        }
        else{
            v = inflater.inflate(R.layout.fragmento_simple2 , container, false);
            tv = v.findViewById(R.id.texto2);

        }

        ((TextView) tv).setText("Fragmento número #" + mNum);
        return v;
    }
}