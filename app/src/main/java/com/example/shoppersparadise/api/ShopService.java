package com.example.shoppersparadise.api;

import com.example.shoppersparadise.Constants;
import com.example.shoppersparadise.product.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ShopService {

    @GET(Constants.CATEGORIES_END_POINT)
    Call<List<String>> fetchCategories();

    @GET("/products/category/{categoryName}")
    Call<List<Product>> fetchProducts(@Path("categoryName") String categoryName);

    @GET("/products/{productsId}")
    Call<Product> fetchProductDetails(@Path("productsId") int productsId);
}
