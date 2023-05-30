package com.example.shoppersparadise;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppersparadise.databinding.CategoriesItemLayoutBinding;

import java.util.ArrayList;

public class CategoriesItemAdapter extends RecyclerView.Adapter<CategoriesItemViewHolder> {

    public ArrayList<Categories> categoriesArrayList;

    public void setCategoriesArrayList(ArrayList<Categories> categoriesArrayList) {
        this.categoriesArrayList = categoriesArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoriesItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoriesItemLayoutBinding categoriesItemLayoutBinding = CategoriesItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CategoriesItemViewHolder categoriesItemViewHolder = new CategoriesItemViewHolder(categoriesItemLayoutBinding);
        return categoriesItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesItemViewHolder holder, int position) {
        Categories categories = categoriesArrayList.get(position);
        holder.binding.setCategories(categories);
    }

    @Override
    public int getItemCount() {
        return categoriesArrayList.size();
    }
}
