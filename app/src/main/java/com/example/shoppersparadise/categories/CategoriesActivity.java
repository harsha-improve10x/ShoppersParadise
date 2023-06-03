package com.example.shoppersparadise.categories;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.shoppersparadise.CartActivity;
import com.example.shoppersparadise.Constants;
import com.example.shoppersparadise.R;
import com.example.shoppersparadise.product.ProductsActivity;
import com.example.shoppersparadise.base.BaseActivity;
import com.example.shoppersparadise.databinding.ActivityCategoriesBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends BaseActivity {

    private ActivityCategoriesBinding activityCategoriesBinding;
    private ArrayList<String> categories = new ArrayList<>();
    private CategoriesAdapter categoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCategoriesBinding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(activityCategoriesBinding.getRoot());
        getSupportActionBar().setTitle("Categories");
        setUpCategoriesAdapter();
        setUpCategoriesRv();
       // fetchCategories();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.categories_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_cart) {
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }

    }

    private void setUpCategoriesRv() {
        activityCategoriesBinding.categoriesRv.setLayoutManager(new LinearLayoutManager(this));
        activityCategoriesBinding.categoriesRv.setAdapter(categoriesAdapter);
    }
    private void setUpCategoriesAdapter() {
        categoriesAdapter = new CategoriesAdapter();
        categoriesAdapter.setCategoriesArrayList(categories);
        categoriesAdapter.setOnItemActionListener(categoryName -> {
            Intent intent = new Intent(CategoriesActivity.this, ProductsActivity.class);
            intent.putExtra(Constants.KEY_CATEGORY_VALUE, categoryName);
            startActivity(intent);
        });
    }

    private void showProgressBar() {
        activityCategoriesBinding.categoriesPb.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        activityCategoriesBinding.categoriesPb.setVisibility(View.GONE);
    }
   /* private void fetchCategories() {
        showProgressBar();
        Call<List<String>> call = fakeApiService.fetchCategories();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                hideProgressBar();
                List<String> categories = response.body();
                categoriesAdapter.setCategoriesArrayList(categories);
            }
            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                hideProgressBar();
                showToast("Failed to Load the Data");
            }
        });
    }*/
}