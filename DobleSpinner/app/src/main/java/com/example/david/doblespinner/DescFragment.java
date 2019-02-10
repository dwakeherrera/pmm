package com.example.david.doblespinner;

import android.os.Bundle;
import android.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DescFragment extends Fragment {

    Peliculas pelicula;

    TextView descripcion;

    static DescFragment newInstance() {
        DescFragment f = new DescFragment();
        return f;
    }

    static DescFragment newInstance(Peliculas pelicula) {
        DescFragment f = new DescFragment();
        Bundle args = new Bundle();
        args.putSerializable("MOVIE_DESC", pelicula);
        f.setArguments(args);
        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view;
        view = inflater.inflate(R.layout.fragment_desc, container, false);

        if (getArguments() != null) {
            pelicula = (Peliculas) getArguments().getSerializable("MOVIE_DESC");

            descripcion = (TextView) view.findViewById(R.id.descript);
            descripcion.setText(pelicula.getDescripcion());
            descripcion.setMovementMethod(new ScrollingMovementMethod());
        }
        return view;

    }
}