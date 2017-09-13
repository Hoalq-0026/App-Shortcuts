package com.thaibaodigital.app_shortcuts;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.thaibaodigital.app_shortcuts.fragment.MyFragmentManager;
import com.thaibaodigital.app_shortcuts.shortcuts.DynamicShortcuts;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpActionBar();

        // restore shortcuts after app upgrade
        DynamicShortcuts.restoreShortcuts(this);

        MyFragmentManager myFragmentManager = new MyFragmentManager(getSupportFragmentManager());
        myFragmentManager.handleIntent(getIntent());

        ImageView cartImageView = (ImageView)findViewById(R.id.cart);
        cartImageView.setOnClickListener( view -> myFragmentManager.showFragment(MyFragmentManager.CART));

        ImageView categoryImageView = (ImageView)findViewById(R.id.categories);
        categoryImageView.setOnClickListener( view -> myFragmentManager.showFragment(MyFragmentManager.CATEGORIES));


    }

    private void setUpActionBar() {
        android.support.v7.widget.Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            getFragmentManager().popBackStack();
        }
    }
}
