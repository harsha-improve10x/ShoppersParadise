package com.example.shoppersparadise.categories;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppersparadise.databinding.CategoriesItemLayoutBinding;

public class CategoriesViewHolder extends RecyclerView.ViewHolder {

    CategoriesItemLayoutBinding categoriesItemLayoutBinding;

    public CategoriesViewHolder(@NonNull CategoriesItemLayoutBinding categoriesItemLayoutBinding) {
        super(categoriesItemLayoutBinding.getRoot());
        this.categoriesItemLayoutBinding = categoriesItemLayoutBinding;
    }
}
