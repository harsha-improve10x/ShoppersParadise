package com.example.shoppersparadise.categories;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppersparadise.databinding.CategoriesItemLayoutBinding;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesViewHolder> {

    private List<Category> categoriesArrayList;
    private OnItemActionListener onItemActionListener;

    void setCategoriesArrayList(List<Category> categoriesArrayList) {
        this.categoriesArrayList = categoriesArrayList;
        notifyDataSetChanged();
    }

    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoriesItemLayoutBinding categoriesItemLayoutBinding = CategoriesItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CategoriesViewHolder categoriesViewHolder = new CategoriesViewHolder(categoriesItemLayoutBinding);
        return categoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        Category categories = categoriesArrayList.get(position);
        holder.categoriesItemLayoutBinding.setCategory(categories);
        holder.categoriesItemLayoutBinding.getRoot().setOnClickListener(v -> {
            onItemActionListener.onClicked(categoriesArrayList.get(position).toString());
        });
    }

    @Override
    public int getItemCount() {
        return categoriesArrayList.size();
    }
}
