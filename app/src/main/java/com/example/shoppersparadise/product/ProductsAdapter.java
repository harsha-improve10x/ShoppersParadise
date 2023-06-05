package com.example.shoppersparadise.product;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppersparadise.databinding.ProductItemLayoutBinding;
import com.example.shoppersparadise.model.Product;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsViewHolder> {

    private List<Product> productArrayList;
    private OnItemActionListener onItemActionListener;

     public void setProductArrayList(List<Product> productArrayList) {
        this.productArrayList = productArrayList;
        notifyDataSetChanged();
    }

    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductItemLayoutBinding productItemLayoutBinding = ProductItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ProductsViewHolder productsViewHolder = new ProductsViewHolder(productItemLayoutBinding);
        return productsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        Product product = productArrayList.get(position);
        holder.productItemLayoutBinding.setProduct(product);
        holder.productItemLayoutBinding.getRoot().setOnClickListener(v -> {
            onItemActionListener.onClicked(productArrayList.get(position).getId());
        });
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }
}
