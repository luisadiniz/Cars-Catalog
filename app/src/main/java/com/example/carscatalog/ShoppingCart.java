package com.example.carscatalog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity {

    ArrayList<Car> cartItems = new ArrayList<Car>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart);

        ShowList();

        TextView quantityText = findViewById(R.id.quantity_text);
        quantityText.setText("Quantidade: " + cartItems.size());

    }

    public void ShowList(){

        DataStorage dataStorage = new DataStorage();
        CarDBHelper carDBHelper = new CarDBHelper(this);
        cartItems = dataStorage.ReturnCarValues(carDBHelper);

        CarsAdapter cartArray = new CarsAdapter(this, cartItems);
        ListView listView = (ListView) findViewById(R.id.cart_list_view);
        listView.setAdapter(cartArray);
    }

    public void EndShopping(View view)
    {
        if(cartItems.size() < 4){
        Toast.makeText(getApplicationContext(), "Compra Finalizada!", Toast.LENGTH_LONG).show();

            DataStorage dataStorage = new DataStorage();
            dataStorage.CleanCarValues();

            setContentView(R.layout.shopping_cart);

        }
        else {
            Toast.makeText(getApplicationContext(), "Valor permitido exedido", Toast.LENGTH_LONG).show();
        }
    }
}
