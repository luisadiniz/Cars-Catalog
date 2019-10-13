package com.example.carscatalog;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

import java.sql.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class DataStorage {

    ArrayList<Car> carList =  new ArrayList<Car>();

    public ArrayList<Car> ReturnCarValues(CarDBHelper mDbHelper) {

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + "CAR_TABLE", null);

        int nameColumnIndex = cursor.getColumnIndex("CAR_NAME");
        int imageColumnIndex = cursor.getColumnIndex("CAR_IMAGE");
        int priceColumnIndex = cursor.getColumnIndex("CAR_PRICE");
        int quantityColumnIndex = cursor.getColumnIndex("QUANTITY");

        while (cursor.moveToNext())
        {
            Car car = new Car();
            car.nome = cursor.getString(nameColumnIndex);
            car.imagem = cursor.getString(imageColumnIndex);
            car.preco = cursor.getString(priceColumnIndex);
            car.quantidade = cursor.getString(quantityColumnIndex);

            carList.add(car);
        }

        return carList;
    }

    public void InsertCarValues(CarDBHelper mDbHelper, String name, String image, String price, int quantity){

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put("CAR_NAME", name);
        values.put("CAR_IMAGE", image);
        values.put("CAR_PRICE", price);
        values.put("QUANTITY", quantity);

        long newRowId;
        newRowId = db.insert("CAR_TABLE", null, values);

    }

    public void CleanCarValues()
    {
        carList.clear();
    }
}
