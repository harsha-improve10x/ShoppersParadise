package com.example.shoppersparadise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    protected CategoriesService categoriesService;

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
        CategoriesApi categoriesApi = new CategoriesApi();
        categoriesService = categoriesApi.createCategoriesService();
    }
}