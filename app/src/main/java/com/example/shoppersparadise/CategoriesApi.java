package com.example.shoppersparadise;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoriesApi {

    public CategoriesService createCategoriesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CategoriesService categoriesService = retrofit.create(CategoriesService.class);
        return categoriesService;
    }
}
