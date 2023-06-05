package com.example.shoppersparadise.api;

import com.example.shoppersparadise.cart.Cart;
import com.example.shoppersparadise.Constants;
import com.example.shoppersparadise.categories.Category;
import com.example.shoppersparadise.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FakeApiService {

    @GET(Constants.CATEGORIES_END_POINT)
    Call<List<Category>> fetchCategories();

    @GET("api/v1/products/")
    Call<List<Product>> fetchProducts(@Query("categoryId") int categoryId);

    @GET("api/v1/products/{id}")
    Call<Product> fetchProductDetails(@Path("id") int id);

    @GET("carts/1?userId=1")
    Call<Cart> fetchCarts();

    @GET("api/v1/products/")
    Call<List<Product>> fetchSearchDetails(@Query("title") String title);
}
