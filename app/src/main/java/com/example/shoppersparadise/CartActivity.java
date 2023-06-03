package com.example.shoppersparadise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.shoppersparadise.base.BaseActivity;
import com.example.shoppersparadise.databinding.ActivityCartBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends BaseActivity {
    private ActivityCartBinding activityCartBinding;
    private ArrayList<CartProduct> carts = new ArrayList<>();
    private CartsAdapter cartsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCartBinding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(activityCartBinding.getRoot());
        getSupportActionBar().setTitle("Cart");
        setUpCartsAdapter();
        setUpCartsRv();
        fetchCarts();
    }

    private void setUpCartsAdapter() {
        cartsAdapter = new CartsAdapter();
        cartsAdapter.setCarts(carts);
    }

    private void setUpCartsRv() {
        activityCartBinding.cartsRv.setLayoutManager(new LinearLayoutManager(this));
        activityCartBinding.cartsRv.setAdapter(cartsAdapter);
    }

    private void fetchCarts() {
        Call<Cart> call = fakeApiService.fetchCarts();
        call.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {
                if (response.isSuccessful()) {
                    Cart cart = response.body();
                    cartsAdapter.setCarts(cart.products);
                }
            }

            @Override
            public void onFailure(Call<Cart> call, Throwable t) {
                showToast("Failed to fetch Data");
            }
        });
    }
}