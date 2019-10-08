package com.example.carscatalog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
        // Lookup view for data population
        TextView carName = (TextView) convertView.findViewById(R.id.car_name);
        TextView carPrice = (TextView) convertView.findViewById(R.id.car_price);
        // Populate the data into the template view using the data object
        carName.setText(car.nome);
        carPrice.setText(car.preco);
        // Return the completed view to render on screen
        return convertView;
    }
}
