package com.example.shoppersparadise.product;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppersparadise.databinding.ProductItemLayoutBinding;

public class ProductsViewHolder extends RecyclerView.ViewHolder {
    //Todo ProductsViewHolder

    ProductItemLayoutBinding productItemLayoutBinding;

    public ProductsViewHolder(@NonNull ProductItemLayoutBinding productItemLayoutBinding) {
        super(productItemLayoutBinding.getRoot());
        this.productItemLayoutBinding = productItemLayoutBinding;
    }
}
