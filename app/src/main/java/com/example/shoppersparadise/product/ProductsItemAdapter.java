package com.example.shoppersparadise.product;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppersparadise.databinding.ProductItemLayoutBinding;

import java.util.List;

public class ProductsItemAdapter extends RecyclerView.Adapter<ProductsItemViewHolder> {

    private List<Product> productArrayList;
    public OnItemActionListener onItemActionListener;

    void setProductArrayList(List<Product> productArrayList) {
        this.productArrayList = productArrayList;
        notifyDataSetChanged();
    }

    public void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
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
        holder.binding.getRoot().setOnClickListener(v -> {
            onItemActionListener.onClicked(productArrayList.get(position).getId());
        });
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }
}
