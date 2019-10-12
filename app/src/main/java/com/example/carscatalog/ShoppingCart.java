package com.example.carscatalog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity {

    ArrayList<Car> cartItems = new ArrayList<Car>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart);

        SetContentClicked();
    }

    public void SetContentClicked()
    {
        Intent getLastIntent = getIntent();

        Car carClicked = new Car();
        carClicked.nome = getLastIntent.getStringExtra("Name");
        carClicked.imagem = getLastIntent.getStringExtra("Image");
        carClicked.preco = getLastIntent.getStringExtra("Price");
        carClicked.id ="";
        carClicked.descricao="";
        carClicked.marca="";
        carClicked.quantidade="";

        cartItems.add(carClicked);

        CarsAdapter cartArray = new CarsAdapter(this, cartItems);
        ListView listView = (ListView) findViewById(R.id.cart_list_view);
        listView.setAdapter(cartArray);
    }

    public void EndShopping(View view)
    {
        Toast.makeText(getApplicationContext(), "Compra Finalizada!", Toast.LENGTH_LONG).show();
    }
}
