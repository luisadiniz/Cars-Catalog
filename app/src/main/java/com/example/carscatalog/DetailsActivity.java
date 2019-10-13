package com.example.carscatalog;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    int quantity = 0;
    String price="";
    String name ="";
    String imageURL ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        SetContentClicked();
    }

    public void SetContentClicked(){
        Intent getLastIntent = getIntent();

        TextView carNameTextView = (TextView) findViewById(R.id.car_name);
        name = getLastIntent.getStringExtra("Name");
        carNameTextView.setText(name);

        TextView carDescriptionTextView = (TextView) findViewById(R.id.car_description);
        carDescriptionTextView.setText(getLastIntent.getStringExtra("Description"));
//
        ImageView carImageView = (ImageView) findViewById(R.id.car_details_image);
        imageURL = getLastIntent.getStringExtra("Image");
        Picasso.get().load(imageURL).into(carImageView);

        price = getLastIntent.getStringExtra("Price");
    }

    public void IncrementQuantity(View view)
    {
        quantity++;
        display(quantity);
    }
    public void DecrementQuantity(View view)
    {
        quantity--;
        if(quantity < 0){ quantity = 0;}
        display(quantity);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void AddButton(View view){

        if(quantity > 0){
        Intent shoppingCart = new Intent(this, ShoppingCart.class);

        for (int i = 0; i < quantity; i++)
        {
        CarDBHelper carDBHelper = new CarDBHelper(this);
        DataStorage dataStorage = new DataStorage();
        dataStorage.InsertCarValues(carDBHelper, name, imageURL, price,quantity);
        }

        startActivity(shoppingCart);
        }
        else{
            Toast.makeText(getApplicationContext(), "Quantidade Insuficiente", Toast.LENGTH_LONG).show();
        }
    }
}
