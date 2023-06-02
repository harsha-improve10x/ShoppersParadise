package com.example.shoppersparadise.product;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.shoppersparadise.CartActivity;
import com.example.shoppersparadise.Constants;
import com.example.shoppersparadise.ProductDetailsActivity;
import com.example.shoppersparadise.R;
import com.example.shoppersparadise.base.BaseActivity;
import com.example.shoppersparadise.databinding.ActivityProductsBinding;
import com.example.shoppersparadise.model.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends BaseActivity {

    private ActivityProductsBinding productsBinding;
    private ArrayList<Product> products = new ArrayList<>();
    private ProductsAdapter productsAdapter;

    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productsBinding = ActivityProductsBinding.inflate(getLayoutInflater());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(productsBinding.getRoot());
        if (getIntent().hasExtra(Constants.KEY_CATEGORY_VALUE)) {
            category = getIntent().getStringExtra(Constants.KEY_CATEGORY_VALUE);
            getSupportActionBar().setTitle(category);
        }
        setUpProductsAdapter();
        setUpProductsRv();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.product_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.cart_add_product) {
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchProducts();
    }

    private void setUpProductsRv() {
        productsBinding.productsRv.setLayoutManager(new GridLayoutManager(this,2));
        productsBinding.productsRv.setAdapter(productsAdapter);
    }

    private void setUpProductsAdapter() {
        productsAdapter = new ProductsAdapter();
        productsAdapter.setProductArrayList(products);
        productsAdapter.setOnItemActionListener(productsId -> {
            Intent intent = new Intent(ProductsActivity.this, ProductDetailsActivity.class);
            intent.putExtra(Constants.KEY_PRODUCT_VALUE, productsId);
            startActivity(intent);
        });
    }

    private void showProgressBar() {
        productsBinding.productPb.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        productsBinding.productPb.setVisibility(View.GONE);
    }

    private void fetchProducts() {
        showProgressBar();
        Call<List<Product>> call = fakeApiService.fetchProducts(category);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                hideProgressBar();
                List<Product> products = response.body();
                productsAdapter.setProductArrayList(products);
            }
            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                hideProgressBar();
                showToast("Failed to fetch the data");
            }
        });
    }
}