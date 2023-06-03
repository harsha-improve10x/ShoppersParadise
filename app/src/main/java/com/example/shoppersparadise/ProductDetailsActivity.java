package com.example.shoppersparadise;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getIntent().hasExtra(Constants.KEY_PRODUCT_VALUE)) {
            productId = getIntent().getIntExtra(Constants.KEY_PRODUCT_VALUE, productId);
            getSupportActionBar().setTitle("Product Details");
        }
        fetchProductDetails();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.product_details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home) {
            finish();
            return true;
        } else if (item.getItemId() == R.id.product_details_cart) {
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
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
           }
           @Override
           public void onFailure(Call<Product> call, Throwable t) {
               hideProgressBar();
               showToast("Failed To load Data");
           }
       });
    }
}