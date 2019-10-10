package com.example.carscatalog;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CarService {

    @GET("carro")
    Call<List<Car>> SearchCars();

}
