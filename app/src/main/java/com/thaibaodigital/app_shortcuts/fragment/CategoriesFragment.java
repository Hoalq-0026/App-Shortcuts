package com.thaibaodigital.app_shortcuts.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.thaibaodigital.app_shortcuts.R;
import com.thaibaodigital.app_shortcuts.adapter.CategoriesRecyclerViewAdapter;
import com.thaibaodigital.app_shortcuts.data.ItemListGenerator;
import com.thaibaodigital.app_shortcuts.shortcuts.DynamicShortcuts;

/**
 * Created by le.quang.hoa on 9/13/17.
 */

public class CategoriesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.categories_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.categories_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CategoriesRecyclerViewAdapter(getContext(), ItemListGenerator.getCategoriesList()));

        Button button = (Button) view.findViewById(R.id.remove_shortcut);
        button.setOnClickListener(view1 -> DynamicShortcuts.removeShortcuts(getContext()));
    }
}
