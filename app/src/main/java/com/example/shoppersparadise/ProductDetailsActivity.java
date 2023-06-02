package com.example.shoppersparadise;

import android.os.Bundle;
import android.view.View;

import com.example.shoppersparadise.base.BaseActivity;
import com.example.shoppersparadise.databinding.ActivityProductDetailsBinding;
import com.example.shoppersparadise.model.Product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends BaseActivity {
    private ActivityProductDetailsBinding activityProductDetailsBinding;
    private int productId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityProductDetailsBinding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(activityProductDetailsBinding.getRoot());
        getSupportActionBar().setTitle("Product Details");
        if (getIntent().hasExtra(Constants.KEY_PRODUCT_VALUE)) {
            productId = getIntent().getIntExtra(Constants.KEY_PRODUCT_VALUE, productId);
        }
        fetchProductDetails();
    }

    private void showProgressBar() {
        activityProductDetailsBinding.productDetailsPb.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        activityProductDetailsBinding.productDetailsPb.setVisibility(View.GONE);
    }

    private void fetchProductDetails() {
        showProgressBar();
       Call<Product> call = fakeApiService.fetchProductDetails(productId);
       call.enqueue(new Callback<Product>() {
           @Override
           public void onResponse(Call<Product> call, Response<Product> response) {
               hideProgressBar();
               Product product = response.body();
               activityProductDetailsBinding.setProduct(product);
               activityProductDetailsBinding.productDetailsRb.setRating(product.rating.getRate());
           }
           @Override
           public void onFailure(Call<Product> call, Throwable t) {
               hideProgressBar();
               showToast("Failed To load Data");
           }
       });
    }

}