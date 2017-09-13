package com.thaibaodigital.app_shortcuts.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.thaibaodigital.app_shortcuts.R;
import com.thaibaodigital.app_shortcuts.shortcuts.DynamicShortcuts;

import java.util.ArrayList;
import java.util.List;

public class CategoriesRecyclerViewAdapter extends RecyclerView.Adapter<CategoriesRecyclerViewAdapter.CategoriesRecyclerViewHolder> {

    private Context mContext;

    @NonNull
    private final List<String> mItems = new ArrayList<>();

    public CategoriesRecyclerViewAdapter(Context context, @NonNull List<String>items){
        mItems.addAll(items);
        mContext = context;
    }

    @Override
    public CategoriesRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_item_view, parent, false);

        return new CategoriesRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoriesRecyclerViewHolder holder, int position) {
        if (mItems.size() == 0){
            return;
        }

        String category = mItems.get(position);
        holder.mTextView.setText(category);
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DynamicShortcuts.createShortcut(mContext, category);
                Toast.makeText(mContext, String.format(mContext.getString(R.string.category_toast_message), category), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class CategoriesRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public CategoriesRecyclerViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.category_name);
        }
    }
}
