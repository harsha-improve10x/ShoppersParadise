package com.example.shoppersparadise.categories;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppersparadise.databinding.CategoriesItemLayoutBinding;

public class CategoriesItemViewHolder extends RecyclerView.ViewHolder {

    CategoriesItemLayoutBinding binding;

    public CategoriesItemViewHolder(@NonNull CategoriesItemLayoutBinding categoriesItemLayoutBinding) {
        super(categoriesItemLayoutBinding.getRoot());
        binding = categoriesItemLayoutBinding;
    }
}
