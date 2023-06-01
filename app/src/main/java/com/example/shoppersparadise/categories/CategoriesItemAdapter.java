package com.example.shoppersparadise.categories;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppersparadise.databinding.CategoriesItemLayoutBinding;

import java.util.List;

public class CategoriesItemAdapter extends RecyclerView.Adapter<CategoriesItemViewHolder> {

    private List<String> categoriesArrayList;
    public OnItemActionListener onItemActionListener;

    public void setCategoriesArrayList(List<String> categoriesArrayList) {
        this.categoriesArrayList = categoriesArrayList;
        notifyDataSetChanged();
    }

    public void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }

    @NonNull
    @Override
    public CategoriesItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoriesItemLayoutBinding categoriesItemLayoutBinding = CategoriesItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CategoriesItemViewHolder categoriesItemViewHolder = new CategoriesItemViewHolder(categoriesItemLayoutBinding);
        return categoriesItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String categories = categoriesArrayList.get(position);
        holder.binding.setCategories(new Categories(categories));
        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemActionListener.onClicked(categoriesArrayList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoriesArrayList.size();
    }
}
