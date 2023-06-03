package com.example.shoppersparadise.api;

import com.example.shoppersparadise.Cart;
import com.example.shoppersparadise.CartProduct;
import com.example.shoppersparadise.Constants;
import com.example.shoppersparadise.categories.Categories;
import com.example.shoppersparadise.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeApiService {

    @GET(Constants.CATEGORIES_END_POINT)
    Call<List<Categories>> fetchCategories();

    @GET("products/category/{categoryName}")
    Call<List<Product>> fetchProducts(@Path("categoryName") String categoryName);

    @GET("products/{productsId}")
    Call<Product> fetchProductDetails(@Path("productsId") int productsId);

    @GET("carts/1?userId=1")
    Call<Cart> fetchCarts();
}
