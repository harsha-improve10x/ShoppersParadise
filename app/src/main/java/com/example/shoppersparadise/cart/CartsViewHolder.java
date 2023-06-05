package com.example.shoppersparadise.cart;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppersparadise.databinding.CartItemLayoutBinding;

public class CartsViewHolder extends RecyclerView.ViewHolder {

    CartItemLayoutBinding cartItemLayoutBinding;

    public CartsViewHolder(@NonNull CartItemLayoutBinding cartItemLayoutBinding) {
        super(cartItemLayoutBinding.getRoot());
        this.cartItemLayoutBinding = cartItemLayoutBinding;
    }
}
