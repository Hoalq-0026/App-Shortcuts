package com.thaibaodigital.app_shortcuts.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thaibaodigital.app_shortcuts.R;
import com.thaibaodigital.app_shortcuts.data.Item;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MainRecyclerViewHolder> {

    @NonNull
    private final List<Item> mItems = new ArrayList<>();

    public void setItems(@NonNull List<Item> items) {
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public MainRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item_view, parent, false);

        return new MainRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainRecyclerViewHolder holder, int position) {
        if (mItems.size() == 0) {
            return;
        }

        holder.mItemNameTextView.setText(mItems.get(position).getName());
        holder.mItemCategoryTextView.setText(mItems.get(position).getCategory());
        holder.mItemPriceTextView.setText(String.format(mItems.get(position).getPrice() + "€"));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class MainRecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView mItemNameTextView;

        TextView mItemCategoryTextView;

        TextView mItemPriceTextView;

        public MainRecyclerViewHolder(View itemView) {
            super(itemView);
            mItemNameTextView = (TextView) itemView.findViewById(R.id.name);
            mItemCategoryTextView = (TextView) itemView.findViewById(R.id.category);
            mItemPriceTextView = (TextView) itemView.findViewById(R.id.price);
        }
    }
}
