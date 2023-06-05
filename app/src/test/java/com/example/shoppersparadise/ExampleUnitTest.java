package com.example.shoppersparadise;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.shoppersparadise.api.FakeApi;
import com.example.shoppersparadise.api.FakeApiService;
import com.example.shoppersparadise.cart.Cart;
import com.example.shoppersparadise.categories.Category;
import com.example.shoppersparadise.model.Product;
import com.google.gson.Gson;

import java.io.IOException;
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
        Call<List<Category>> call = fakeApiService.fetchCategories();
        List<Category> categories = call.execute().body();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        System.out.println(new Gson().toJson(categories));
    }

    @Test
    public void getProducts() throws IOException {
        FakeApiService fakeApiService = new FakeApi().createCategoriesService();
        Call<List<Product>> call = fakeApiService.fetchProducts(1);
        List<Product> products = call.execute().body();
        assertNotNull(products);
        assertFalse(products.isEmpty());
        System.out.println(new Gson().toJson(products));
    }

    @Test
    public void getProductDetails() throws IOException {
        FakeApiService fakeApiService = new FakeApi().createCategoriesService();
        Call<Product> call = fakeApiService.fetchProductDetails(4);
        Product product = call.execute().body();
        assertNotNull(product);
        System.out.println(new Gson().toJson(product));
    }

    @Test
    public void getCart() throws IOException {
        FakeApiService fakeApiService = new FakeApi().createCategoriesService();
        Call<Cart> call = fakeApiService.fetchCarts();
        Cart carts = call.execute().body();
        assertNotNull(carts);
        System.out.println(new Gson().toJson(carts));
    }

    @Test
    public void getSearchDetails() throws IOException {
        FakeApiService fakeApiService = new FakeApi().createCategoriesService();
        Call<List<Product>> call = fakeApiService.fetchSearchDetails("Generic");
        List<Product> products = call.execute().body();
        assertNotNull(products);
        assertFalse(products.isEmpty());
        System.out.println(new Gson().toJson(products));
    }
}