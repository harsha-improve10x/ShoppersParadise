package com.example.shoppersparadise.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.shoppersparadise.R;
import com.example.shoppersparadise.api.ShopApi;
import com.example.shoppersparadise.api.ShopService;

public class BaseActivity extends AppCompatActivity {

    protected ShopService shopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        setUpCategoriesService();
    }

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void setUpCategoriesService() {
        ShopApi shopApi = new ShopApi();
        shopService = shopApi.createCategoriesService();
    }
}