package com.example.shoppersparadise;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.shoppersparadise.api.ShopApi;
import com.example.shoppersparadise.api.ShopService;
import com.example.shoppersparadise.categories.Categories;
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
        ShopService shopService = new ShopApi().createCategoriesService();
        Call<List<String>> call = shopService.fetchCategories();
        List<String> categories = call.execute().body();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        System.out.println(new Gson().toJson(categories));
    }
}