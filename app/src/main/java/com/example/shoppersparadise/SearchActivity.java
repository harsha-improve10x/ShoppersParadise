package com.example.shoppersparadise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.shoppersparadise.base.BaseActivity;
import com.example.shoppersparadise.databinding.ActivitySearchBinding;
import com.example.shoppersparadise.model.Product;
import com.example.shoppersparadise.product.ProductsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends BaseActivity {

    private ActivitySearchBinding activitySearchBinding;
    private ArrayList<Product> products = new ArrayList<>();
    private ProductsAdapter productsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySearchBinding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(activitySearchBinding.getRoot());
        setUpSearchAdapter();
        setUpSearchRv();
    }

    private void setUpSearchRv() {
        activitySearchBinding.searchRv.setLayoutManager(new GridLayoutManager(this, 2));
        activitySearchBinding.searchRv.setAdapter(productsAdapter);
    }

    private void setUpSearchAdapter() {
        productsAdapter = new ProductsAdapter();
        productsAdapter.setProductArrayList(products);
    }

    private void fetchSearchItem(String s) {
        Call<List<Product>> call = fakeApiService.fetchSearchDetails(s);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    List<Product> products1 = response.body();
                    productsAdapter.setProductArrayList(products1);
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                showToast("Failed to load the data");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_menu_item, menu);
        MenuItem menuItem = menu.findItem(R.id.app_bar_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                fetchSearchItem(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}