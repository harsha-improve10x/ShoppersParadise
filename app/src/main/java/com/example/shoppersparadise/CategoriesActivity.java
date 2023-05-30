package com.example.shoppersparadise;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.shoppersparadise.databinding.ActivityCategoriesBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends BaseActivity {

    private ActivityCategoriesBinding activityCategoriesBinding;
    private ArrayList<String> categories = new ArrayList<>();
    private CategoriesItemAdapter categoriesItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCategoriesBinding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(activityCategoriesBinding.getRoot());
        getSupportActionBar().setTitle("Categories");
        setUpCategoriesAdapter();
        setUpCategoriesRv();
        fetchCategories();
    }

    private void setUpCategoriesRv() {
        activityCategoriesBinding.categoriesRv.setLayoutManager(new LinearLayoutManager(this));
        activityCategoriesBinding.categoriesRv.setAdapter(categoriesItemAdapter);
    }

    private void setUpCategoriesAdapter() {
        categoriesItemAdapter = new CategoriesItemAdapter();
        categoriesItemAdapter.setCategoriesArrayList(categories);
    }

    private void fetchCategories() {
        Call<List<String>> call = categoriesService.fetchCategories();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                List<String> categories = response.body();
                categoriesItemAdapter.setCategoriesArrayList(categories);
                showToast("Successfully Fetched the Data");
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                showToast("Failed to fetch the data");
            }
        });
    }
}