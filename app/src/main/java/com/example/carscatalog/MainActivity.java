package com.example.carscatalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
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
        Intent i = new Intent(this, DetailsActivity.class);
        View parentView = (View)view.getParent();
        TextView indexView = (TextView)parentView.findViewById(R.id.index);
        int itemIndex = Integer.parseInt(indexView.getText().toString());

        Log.v("Index", String.valueOf(itemIndex));

        i.putExtra("Name", cardItems.get(itemIndex-1).nome);
        i.putExtra("Image", cardItems.get(itemIndex-1).imagem);
        i.putExtra("Description", cardItems.get(itemIndex-1).descricao);

        startActivity(i);
    }

    private void Request(){
        Call<List<Car>> call = new RetrofitConfig().getCarService().SearchCars();
        call.enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                cardItems = (ArrayList<Car>) response.body();
                main.PopulateList();
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
