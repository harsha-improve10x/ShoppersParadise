package com.example.shoppersparadise.product;

import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.shoppersparadise.ProductDetailsActivity;
import com.example.shoppersparadise.base.BaseActivity;
import com.example.shoppersparadise.databinding.ActivityProductsBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends BaseActivity {

    private ActivityProductsBinding productsBinding;
    private ArrayList<Product> products = new ArrayList<>();
    private ProductsItemAdapter productsItemAdapter;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productsBinding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(productsBinding.getRoot());
        if (getIntent().hasExtra("category")) {
            category = getIntent().getStringExtra("category");
            getSupportActionBar().setTitle(category);
        }
        setUpProductsAdapter();
        setUpProductsRv();
        fetchProducts();
    }

    private void setUpProductsRv() {
        productsBinding.productsRv.setLayoutManager(new GridLayoutManager(this,2));
        productsBinding.productsRv.setAdapter(productsItemAdapter);
    }

    private void setUpProductsAdapter() {
        productsItemAdapter = new ProductsItemAdapter();
        productsItemAdapter.setProductArrayList(products);
        productsItemAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onClicked(int productsId) {
                Intent intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                intent.putExtra("products", productsId);
                startActivity(intent);
            }
        });
    }

    private void fetchProducts() {
        Call<List<Product>> call = shopService.fetchProducts(category);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> products = response.body();
                productsItemAdapter.setProductArrayList(products);
                showToast("Successfully fetched the data");
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                showToast("Failed to fetch the data");
            }
        });
    }
}