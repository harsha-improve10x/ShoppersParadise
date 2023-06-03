package com.example.shoppersparadise;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.shoppersparadise.api.FakeApi;
import com.example.shoppersparadise.api.FakeApiService;
import com.example.shoppersparadise.model.Product;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getCategory() throws IOException {
        FakeApiService fakeApiService = new FakeApi().createCategoriesService();
        Call<List<String>> call = fakeApiService.fetchCategories();
        List<String> categories = call.execute().body();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        System.out.println(new Gson().toJson(categories));
    }

    @Test
    public void getProducts() throws IOException {
        FakeApiService fakeApiService = new FakeApi().createCategoriesService();
        Call<List<Product>> call = fakeApiService.fetchProducts("jewelery");
        List<Product> products = call.execute().body();
        assertNotNull(products);
        assertFalse(products.isEmpty());
        System.out.println(new Gson().toJson(products));
    }

    @Test
    public void getCart() throws IOException {
        FakeApiService fakeApiService = new FakeApi().createCategoriesService();
        Call<Cart> call = fakeApiService.fetchCarts(1);
        Cart carts = call.execute().body();
        assertNotNull(carts);
        System.out.println(new Gson().toJson(carts));
    }
}