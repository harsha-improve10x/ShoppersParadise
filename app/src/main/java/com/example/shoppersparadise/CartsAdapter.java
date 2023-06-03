package com.example.shoppersparadise;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppersparadise.databinding.CartItemLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class CartsAdapter extends RecyclerView.Adapter<CartsViewHolder> {
    private List<CartProduct> carts;

    public void setCarts(List<CartProduct> carts) {
        this.carts = carts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CartItemLayoutBinding cartItemLayoutBinding = CartItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CartsViewHolder cartsViewHolder = new CartsViewHolder(cartItemLayoutBinding);
        return cartsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartsViewHolder holder, int position) {
        CartProduct cartProduct = carts.get(position);
        holder.cartItemLayoutBinding.setCartProduct(cartProduct);
        
    }

    @Override
    public int getItemCount() {
        return carts.size();
    }
}
