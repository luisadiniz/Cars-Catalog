package com.example.carscatalog;

import android.content.Context;
import android.support.v4.view.ScrollingView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CarsAdapter extends ArrayAdapter<Car> {
    public CarsAdapter(Context context, ArrayList<Car> cars){
        super(context,0,cars);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Car car = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_view, parent, false);
        }

        TextView carName = (TextView) convertView.findViewById(R.id.car_name);
        TextView carPrice = (TextView) convertView.findViewById(R.id.car_price);
        ImageView carImage = (ImageView) convertView.findViewById(R.id.car_image);
        TextView carId = (TextView) convertView.findViewById(R.id.index);

        carName.setText(car.nome);
        carPrice.setText( "R$"+ car.preco);
        carId.setText(car.id);
        Picasso.get().load(car.imagem).into(carImage);

       return convertView;
    }
}
