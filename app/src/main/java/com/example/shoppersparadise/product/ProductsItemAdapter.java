package com.example.shoppersparadise.product;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductsItemAdapter extends RecyclerView.Adapter<ProductsItemViewHolder> {

    private List<Product> productArrayList;

    void setProductArrayList(List<Product> productArrayList) {
        this.productArrayList = productArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductsItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductItemLayoutBinding productItemLayoutBinding = ProductItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ProductsItemViewHolder productsItemViewHolder = new ProductsItemViewHolder(productItemLayoutBinding);
        return productsItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsItemViewHolder holder, int position) {
        Product product = productArrayList.get(position);
        holder.binding.setProduct(product);
        holder.binding.productsRb.setRating(product.rating.getRate());
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }
}
