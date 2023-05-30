package com.example.shoppersparadise;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppersparadise.databinding.CategoriesItemLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class CategoriesItemAdapter extends RecyclerView.Adapter<CategoriesItemViewHolder> {

    private List<String> categoriesArrayList;

    public void setCategoriesArrayList(List<String> categoriesArrayList) {
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
        String categories = categoriesArrayList.get(position);
        holder.binding.setCategories(new Categories(categories));
    }

    @Override
    public int getItemCount() {
        return categoriesArrayList.size();
    }
}
