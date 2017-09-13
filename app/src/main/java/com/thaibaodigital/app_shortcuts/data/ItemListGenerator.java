package com.thaibaodigital.app_shortcuts.data;

import com.thaibaodigital.app_shortcuts.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemListGenerator {

    public interface Categories {
        String GADGETS = "Gadgets";
        String SPORTS = "Sports";
        String FASHION = "Fashion";
    }

    public static List<Item> getItemsList() {
        List<Item> items = new ArrayList<>(6);
        items.add(new Item("Item1", Categories.GADGETS, 50));
        items.add(new Item("Item2", Categories.GADGETS, 70));
        items.add(new Item("Item3", Categories.SPORTS, 80));
        items.add(new Item("Item4", Categories.SPORTS, 80));
        items.add(new Item("Item5", Categories.FASHION, 100));
        items.add(new Item("Item6", Categories.FASHION, 60));
        return items;
    }


    public static List<String> getCategoriesList() {
        return Arrays.asList(Categories.GADGETS, Categories.SPORTS, Categories.FASHION);
    }

    public static List<Item> getItemsListForCategory(String category) {
        List<Item> items = new ArrayList<>();
        for (Item item : getItemsList()) {
            if (item.getCategory().equals(category)) {
                items.add(item);
            }
        }
        return items;
    }

    public static int getIconForCategory(String category) {
        switch (category) {
            case Categories.GADGETS:
                return R.drawable.mobile;
            case Categories.SPORTS:
                return R.drawable.sports;
            default:
                return R.drawable.fashion;
        }
    }
}
