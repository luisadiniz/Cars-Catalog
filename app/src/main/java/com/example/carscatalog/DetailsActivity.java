package com.example.carscatalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        SetContentClicked();
    }
    public void SetContentClicked(){
        Intent getLastIntent = getIntent();

        TextView carNameTextView = (TextView) findViewById(R.id.car_name);
        carNameTextView.setText(getLastIntent.getStringExtra("Name"));

        TextView carDescriptionTextView = (TextView) findViewById(R.id.car_description);
        carDescriptionTextView.setText(getLastIntent.getStringExtra("Description"));
//
        ImageView carImageView = (ImageView) findViewById(R.id.car_details_image);
        Picasso.get().load(getLastIntent.getStringExtra("Image")).into(carImageView);
    }

    public void IncrementQuantity(View view)
    {
        quantity++;
        display(quantity);
    }
    public void DecrementQuantity(View view)
    {
        quantity--;
        display(quantity);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void AddButton(View view){
        //implementar botao de compra
    }
}
