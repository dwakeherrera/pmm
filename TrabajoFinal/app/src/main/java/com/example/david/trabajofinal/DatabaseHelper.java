package com.example.david.trabajofinal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper {
    private Context myContext;
    private static DataBaseHelperInternal dataBaseHelperInternal;
    private SQLiteDatabase sqLiteDatabase;

    public DatabaseHelper(Context ctx) {
        this.myContext = ctx;
    }

    private static class DataBaseHelperInternal extends SQLiteOpenHelper {
        DataBaseHelperInternal (Context context, String databaseName, int databaseVersion) {
            super(context, databaseName, null, databaseVersion);
        }

        public void onCreate(SQLiteDatabase db) {
            createTables(db);
            fillTables(db);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            deleteTables(db);
            createTables(db);
            fillTables(db);
        }

        private void createTables(SQLiteDatabase db) {
            db.execSQL(Globals.CREATE_TABLE_USUARIO);
            db.execSQL(Globals.CREATE_TABLE_PELICULA);
            db.execSQL(Globals.CREATE_TABLE_RELACION);
        }

        private void deleteTables(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS " + Globals.TABLE_USUARIO);
            db.execSQL("DROP TABLE IF EXISTS " + Globals.TABLE_PELICULA);
            db.execSQL("DROP TABLE IF EXISTS " + Globals.TABLE_PELICULA_USUARIO_REL);
        }

        private void fillTables(SQLiteDatabase db) {
            db.beginTransaction();
            try {
                db.execSQL(Globals.FILL_USUARIO_TABLE);
                db.execSQL(Globals.FILL_PELICULA_TABLE);
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        }
    }

    public DatabaseHelper open() {
        dataBaseHelperInternal = new DataBaseHelperInternal(myContext, Globals.DATABASE_NAME, 4);

        sqLiteDatabase = dataBaseHelperInternal.getWritableDatabase();

        return this;
    }

    public void close() { dataBaseHelperInternal.close(); }

    public Cursor getItems (String table, String[] columns, String selection, String[] selArgs, String orderBy) {
        return sqLiteDatabase.query(table, columns, selection, selArgs,null,null, orderBy);
    }

    public void insertItem (String query) {
        sqLiteDatabase.execSQL(query);
    }
}