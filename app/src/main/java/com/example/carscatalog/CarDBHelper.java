package com.example.carscatalog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;
import java.sql.*;

public class CarDBHelper extends SQLiteOpenHelper {

    public CarDBHelper(Context context) {super(context, "Car_Database", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS " + "CAR_TABLE"+ " ("
                + "CAR_NAME" + " TEXT, "
                + "CAR_IMAGE" + " TEXT, "
                + "CAR_PRICE" + " TEXT, "
                + "QUANTITY" + " INTEGER); ";
        db.execSQL(query); }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + "CAR_TABLE");
        onCreate(db); }
}
