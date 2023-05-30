package com.example.shoppersparadise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.shoppersparadise.databinding.ActivityCategoriesBinding;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity {

    private ActivityCategoriesBinding activityCategoriesBinding;
    private ArrayList<Categories> categories;
    private CategoriesItemAdapter categoriesItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCategoriesBinding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(activityCategoriesBinding.getRoot());
        getSupportActionBar().setTitle("Categories");
        setUpData();
        setUpCategoriesAdapter();
        setUpCategoriesRv();
    }

    private void setUpData() {
        categories = new ArrayList<>();

        Categories jeweleries = new Categories("Jeweleries");
        categories.add(jeweleries);

        Categories electronics = new Categories("Electronics");
        categories.add(electronics);
    }

    private void setUpCategoriesRv() {
        activityCategoriesBinding.categoriesRv.setLayoutManager(new LinearLayoutManager(this));
        activityCategoriesBinding.categoriesRv.setAdapter(categoriesItemAdapter);
    }

    private void setUpCategoriesAdapter() {
        categoriesItemAdapter = new CategoriesItemAdapter();
        categoriesItemAdapter.setCategoriesArrayList(categories);
    }
}