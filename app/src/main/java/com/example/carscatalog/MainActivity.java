package com.example.carscatalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import retrofit2.Call;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<Car> cardItems = new ArrayList<Car>();
    final MainActivity main = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Request();

    }

    public void OpenCarDetails(View view)
    {
        Intent i = new Intent(this, Details.class);
        startActivity(i);
    }

    private void Request(){
        Call<List<Car>> call = new RetrofitConfig().getCarService().SearchCars();
        call.enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {

                //cardItems = (ArrayList<Car>) response.body();
                Log.v("Felipe", "Sou apaixonada por vc");

                //main.PopulateList();
            }
            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {

                if (t instanceof IOException) {
                    Log.v("Erro","this is an actual network failure");
                }
                else {
                    Log.v("Fail","conversion issue! big problems :(");
                }
            }
        });
    }

    public void PopulateList()
    {
        CarsAdapter carArray = new CarsAdapter(this, cardItems);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(carArray);
    }


}
