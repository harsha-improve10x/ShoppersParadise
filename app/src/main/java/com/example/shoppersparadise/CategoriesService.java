package com.example.shoppersparadise;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoriesService {

    @GET(Constants.CATEGORIES_END_POINT)
    Call<List<String>> fetchCategories();
}
