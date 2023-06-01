package com.example.shoppersparadise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.shoppersparadise.R;
import com.example.shoppersparadise.base.BaseActivity;
import com.example.shoppersparadise.databinding.ActivityProductDetailsBinding;
import com.example.shoppersparadise.product.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends BaseActivity {
    private ActivityProductDetailsBinding activityProductDetailsBinding;
    int productId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityProductDetailsBinding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(activityProductDetailsBinding.getRoot());
        getSupportActionBar().setTitle("Product Details");
        if (getIntent().hasExtra("products")) {
            productId = getIntent().getIntExtra("products", productId);
        }
        fetchProductDetails();
    }

    private void fetchProductDetails() {
       Call<Product> call = shopService.fetchProductDetails(productId);
       call.enqueue(new Callback<Product>() {
           @Override
           public void onResponse(Call<Product> call, Response<Product> response) {
               Product product = response.body();
               activityProductDetailsBinding.setProduct(product);
               activityProductDetailsBinding.productDetailsRb.setRating(product.rating.getRate());
               showToast("Successfully Loaded The Data");
           }

           @Override
           public void onFailure(Call<Product> call, Throwable t) {
               showToast("Failed To load Data");
           }
       });
    }

}