package com.example.carscatalog;

import android.content.Context;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig
{
    private final Retrofit retrofit;

    public RetrofitConfig(){
        this.retrofit = new Retrofit.Builder()
            .baseUrl("http://desafiobrq.herokuapp.com/v1/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    }

    public CarService getCarService() {
        return this.retrofit.create(CarService.class);
    }

}
