package com.example.david.trabajofinal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonNuevoUsuario;
    Button login;

    EditText insertarUsuario;
    EditText insertarPassword;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNuevoUsuario = (Button) findViewById(R.id.nuevoUsuario);
        login = (Button) findViewById(R.id.login);

        insertarUsuario = (EditText) findViewById(R.id.InsertarUsuario);
        insertarPassword = (EditText) findViewById(R.id.InsertarPassword);

        dbHelper = new DatabaseHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        buttonNuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
    }

    private void login () {
        String usuario = insertarUsuario.getText().toString();
        String password = insertarPassword.getText().toString();
        String[] userData = {usuario, password};
        String[] columns = {
                Globals.TABLE_USUARIO_ID,
                Globals.TABLE_USUARIO_NOMBRE,
                Globals.TABLE_USUARIO_PASSWORD
        };
        Cursor cursor;
        dbHelper.open();
        cursor = dbHelper.getItems(Globals.TABLE_USUARIO, columns, "nombreUsuario = ? AND password = ?",
                userData, Globals.TABLE_USUARIO_ID);

        if (cursor.moveToFirst()) {
            if (cursor.getString(2).equals(insertarUsuario.getText().toString())) {
                Intent intent = new Intent(this, PantallaPeliculas.class);

                Bundle bundle = new Bundle();
                bundle.putInt("USUARIO", cursor.getInt(0));

                Toast.makeText(getApplicationContext(), "Usuario: " + cursor.getString(1) + " conectado", Toast.LENGTH_SHORT).show();

                intent.putExtras(bundle);
                startActivity(intent);
            } else
                Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
        }

        if (!cursor.isClosed()) {
            cursor.close();
        }
        dbHelper.close();
    }

    private void createUser () {
        dbHelper.open();

        Cursor cursor = dbHelper.getItems(
                Globals.TABLE_USUARIO,
                new String[] { Globals.TABLE_USUARIO_NOMBRE },
                "nombreUsuario = ? AND password = ?",
                new String[] { insertarUsuario.getText().toString(), insertarPassword.getText().toString() },
                Globals.TABLE_USUARIO_ID);

        if (cursor.moveToFirst()) {
            if (cursor.getString(0).equals(insertarUsuario.getText().toString()))
                Toast.makeText(getApplicationContext(), "Usuario: " + insertarUsuario.getText().toString() + " ya está creado", Toast.LENGTH_SHORT).show();
        } else {
            dbHelper.insertItem("INSERT INTO Usuario (nombreUsuario, password)" +
                    "VALUES ('" + insertarUsuario.getText().toString() + "', " +
                    "'" + insertarPassword.getText().toString() + "')");
            Toast.makeText(getApplicationContext(), "Usuario: " + insertarUsuario.getText().toString() + " se ha creado", Toast.LENGTH_SHORT).show();
        }

        dbHelper.close();
    }
}