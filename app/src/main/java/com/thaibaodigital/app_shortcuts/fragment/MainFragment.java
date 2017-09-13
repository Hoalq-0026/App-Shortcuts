package com.thaibaodigital.app_shortcuts.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thaibaodigital.app_shortcuts.R;
import com.thaibaodigital.app_shortcuts.adapter.MainRecyclerViewAdapter;
import com.thaibaodigital.app_shortcuts.data.ItemListGenerator;
import com.thaibaodigital.app_shortcuts.shortcuts.DynamicShortcuts;

public class MainFragment extends Fragment {

    @NonNull
    private final MainRecyclerViewAdapter mAdapter = new MainRecyclerViewAdapter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.main_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);
        mAdapter.setItems(ItemListGenerator.getItemsList());
    }

    public void updateItemForCategory(String category){
        DynamicShortcuts.reportShortcutUsed(getContext(), category);
        mAdapter.setItems(ItemListGenerator.getItemsListForCategory(category));
    }
}
