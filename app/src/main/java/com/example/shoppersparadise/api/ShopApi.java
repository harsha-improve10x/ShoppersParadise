package com.example.shoppersparadise.api;

import com.example.shoppersparadise.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShopApi {

    public ShopService createCategoriesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ShopService shopService = retrofit.create(ShopService.class);
        return shopService;
    }
}
