package com.thaibaodigital.app_shortcuts.fragment;

import android.content.Intent;
import android.support.v4.app.FragmentManager;

import com.thaibaodigital.app_shortcuts.R;


public class MyFragmentManager {

    public static final String CART = "cart";
    public static final String CATEGORIES = "categories";
    public static final String FRAGMENT_TO_SHOW = "fragment";

    private static final String CART_FRAGMENT = "CartFragment";
    private static final String CATEGORIES_FRAGMENT = "CategoriesFragment";

    private FragmentManager mFragmentManager;

    public MyFragmentManager(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }

    public void handleIntent(Intent intent) {
        showFragment(intent.getStringExtra(FRAGMENT_TO_SHOW));
    }

    public void showFragment(String name) {
        if (name != null) {
            switch (name) {
                case CART:
                    showCartFragment();
                    break;
                case CATEGORIES:
                    showCategoriesFragment();
                    break;
                default:
                    showItemForCategory(name);
                    break;
            }
        }
    }

    private void showCartFragment() {
        mFragmentManager.beginTransaction().replace(R.id.main_fragment, new CartFragment(), CART_FRAGMENT).addToBackStack(CART_FRAGMENT).commit();
    }

    private void showCategoriesFragment() {
        mFragmentManager.beginTransaction().replace(R.id.main_fragment, new CategoriesFragment(), CATEGORIES_FRAGMENT).addToBackStack(CATEGORIES_FRAGMENT).commit();
    }

    private void showItemForCategory(String category) {
        MainFragment fragment = (MainFragment) mFragmentManager.findFragmentById(R.id.main_fragment);
        fragment.updateItemForCategory(category);
    }
}
