package com.example.shoppersparadise.api;

import com.example.shoppersparadise.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ShopService {

    @GET(Constants.CATEGORIES_END_POINT)
    Call<List<String>> fetchCategories();
}
