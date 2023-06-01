package com.example.shoppersparadise.product;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppersparadise.databinding.ProductItemLayoutBinding;

public class ProductsItemViewHolder extends RecyclerView.ViewHolder {

    ProductItemLayoutBinding binding;

    public ProductsItemViewHolder(@NonNull ProductItemLayoutBinding productItemLayoutBinding) {
        super(productItemLayoutBinding.getRoot());
        binding = productItemLayoutBinding;
    }
}
