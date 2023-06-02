package com.example.shoppersparadise.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.shoppersparadise.R;
import com.example.shoppersparadise.api.FakeApi;
import com.example.shoppersparadise.api.FakeApiService;

public class BaseActivity extends AppCompatActivity {

    protected FakeApiService fakeApiService;

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
        FakeApi fakeApi = new FakeApi();
        fakeApiService = fakeApi.createCategoriesService();
    }
}