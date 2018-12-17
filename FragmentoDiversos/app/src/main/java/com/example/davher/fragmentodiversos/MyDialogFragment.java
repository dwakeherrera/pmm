package com.example.davher.fragmentodiversos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class MyDialogFragment extends DialogFragment {
    public static MyDialogFragment newInstance() {
        MyDialogFragment frag = new MyDialogFragment();
        /*
        Bundle bundle = new Bundle();
        bundle("clave", valor);
        frag.setArguments(bundle);
        */
        return frag;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup dlgview = (ViewGroup) inflater.inflate(R.layout.fragment_my_dialog, null);
        // botÃ³n nuevo Fragment
        Button buttonShow = (Button) dlgview.findViewById(R.id.nuevoFrag);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((MainActivity) getActivity()).addFragment();
            }
        });
        // botÃ³n cancelar
        Button buttonCancel = (Button) dlgview.findViewById(R.id.cancelar);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dismiss();
            }
        });
        // botÃ³n ir a Fragment anterior
        Button buttonBack = (Button) dlgview.findViewById(R.id.atras);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        // asignar el dialog a la vista
        return new AlertDialog.Builder(getActivity()).setView(dlgview).create();
    }
}