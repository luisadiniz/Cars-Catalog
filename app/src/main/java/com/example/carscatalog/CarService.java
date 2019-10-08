package com.example.carscatalog;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CarService {

    @GET("{id}")
    Call<Car> SearchCar(@Path("id") String id);
}
