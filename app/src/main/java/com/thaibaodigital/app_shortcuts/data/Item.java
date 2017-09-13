package com.thaibaodigital.app_shortcuts.data;

import android.support.annotation.NonNull;

public class Item {

    @NonNull
    private final String mName;

    @NonNull
    private final String mCategory;

    private final int mPrice;

    public Item(@NonNull String name, @NonNull String category, int price){
        mName = name;
        mCategory = category;
        mPrice = price;
    }

    @NonNull
    public String getName() {
        return mName;
    }

    @NonNull
    public String getCategory() {
        return mCategory;
    }

    public int getPrice() {
        return mPrice;
    }
}
