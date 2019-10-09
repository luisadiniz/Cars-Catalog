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

import java.util.ArrayList;
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

        Request("1");

    }

    public void OpenCarDetails(View view)
    {
        Intent i = new Intent(this, Details.class);
        startActivity(i);
    }

    private void Request(String index){
        Call<Car> call = new RetrofitConfig().getCarService().SearchCar(index);
        call.enqueue(new Callback<Car>() {
            @Override
            public void onResponse(Call<Car> call, Response<Car> response) {
                cardItems.add(response.body());
                Log.v("AI CARALHO", "NAAAAAO");

                main.PopulateList();
            }
            @Override
            public void onFailure(Call<Car> call, Throwable t) {
                // tratar algum erro com um callback
                Log.v("FAIL", "FAIL");
            }
        });
    }

    public void PopulateList()
    {
        Log.v("AI CARALHO", "AI CACETA");
        CarsAdapter carArray = new CarsAdapter(this, cardItems);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(carArray);
    }


}
