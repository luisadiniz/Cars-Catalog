package com.example.carscatalog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<Car> cardItems = new ArrayList<Car>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Request("1");

        PopulateList();
    }

    private void Request(String index){
        Call<Car> call = new RetrofitConfig().getCarService().SearchCar(index);
        call.enqueue(new Callback<Car>() {
            @Override
            public void onResponse(Call<Car> call, Response<Car> response) {
                //cardItems.add(response.body());
            }
            @Override
            public void onFailure(Call<Car> call, Throwable t) {
                // tratar algum erro com um callback
            }
        });
    }

    private void PopulateList()
    {
        CarsAdapter carArray = new CarsAdapter(this, cardItems);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(carArray);
    }


}
