package com.thaibaodigital.app_shortcuts.shortcuts;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.widget.Toast;

import com.thaibaodigital.app_shortcuts.MainActivity;
import com.thaibaodigital.app_shortcuts.R;
import com.thaibaodigital.app_shortcuts.data.ItemListGenerator;
import com.thaibaodigital.app_shortcuts.fragment.MyFragmentManager;

import java.util.Arrays;
import java.util.List;

/**
 * Created by le.quang.hoa on 9/13/17.
 */

public class DynamicShortcuts {

    private static ShortcutManager getShortCutManager(Context context) {
        ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);

        if (shortcutManager.isRateLimitingActive()) {
            // Bringing app to foreground resets the limit.
            Toast.makeText(context, "Shortcut Manager Rate-Limiting is active", Toast.LENGTH_LONG).show();
        }
        return shortcutManager;
    }

    public static void createShortcut(Context context, String category) {
        ShortcutManager shortcutManager = getShortCutManager(context);

        // to add an element to existing list of shortcuts use addDynamicShortcuts
//        shortcutManager.setDynamicShortcuts(createShortcutInfo(context, category));
        shortcutManager.addDynamicShortcuts(createShortcutInfo(context, category));
    }

    public static void restoreShortcuts(Context context) {
        ShortcutManager shortcutManager = getShortCutManager(context);
        if (shortcutManager.getDynamicShortcuts().size() == 0) {

            // restore dynamic shortcuts that needs to be added by default.

            if (shortcutManager.getPinnedShortcuts().size() > 0) {
                // pinned shortcuts needs to be updated here, after app upgrade
            }
        }
    }

    public static void reportShortcutUsed(Context context, String category) {
        getShortCutManager(context).reportShortcutUsed(category);
    }

    public static void removeShortcuts(Context context) {
        Toast.makeText(context, R.string.shortcuts_removed, Toast.LENGTH_LONG).show();
        getShortCutManager(context).removeAllDynamicShortcuts();
    }

    public static void disableShortcuts(Context context) {
        // disable shortcuts that are not more valid here
        getShortCutManager(context).disableShortcuts(ItemListGenerator.getCategoriesList(), context.getString(R.string.disabled_message));
    }

    private static List<ShortcutInfo> createShortcutInfo(Context context, String category) {
        // Add more shortcuts here
        return Arrays.asList(new ShortcutInfo.Builder(context, category)
                .setShortLabel(category)
                .setLongLabel("Go To" + category)
                .setIcon(getIcon(context, category))
                .setIntent(getIntent(context, category))
                .build());
    }

    private static Icon getIcon(Context context, String category) {
        return Icon.createWithResource(context, ItemListGenerator.getIconForCategory(category));
    }

    private static Intent getIntent(Context context, String category) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(MyFragmentManager.FRAGMENT_TO_SHOW, category);
        intent.setAction(Intent.ACTION_VIEW);
        return intent;
    }
}
