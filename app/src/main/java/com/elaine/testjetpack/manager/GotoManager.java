package com.elaine.testjetpack.manager;

import android.app.Activity;
import android.content.Intent;

import com.elaine.testjetpack.basic.BasicActivity;
import com.elaine.testjetpack.dialog.DialogActivity;
import com.elaine.testjetpack.list.ListActivity;
import com.elaine.testjetpack.network.NetworkActivity;

public class GotoManager {

    public static void toActivity(int intentKey, Activity activity) {
        switch (intentKey) {
            case 1:
                toBasicActivity(activity);
                break;
            case 2:
                toDialogActivity(activity);
                break;
            case 3:
                toListActivity(activity);
                break;
            case 4:
                toNetworkActivity(activity);
                break;
            default:
                break;
        }
    }

    public static void toBasicActivity(Activity activity) {
        Intent intent = new Intent(activity, BasicActivity.class);
        activity.startActivity(intent);
    }

    public static void toDialogActivity(Activity activity) {
        Intent intent = new Intent(activity, DialogActivity.class);
        activity.startActivity(intent);
    }

    public static void toListActivity(Activity activity) {
        Intent intent = new Intent(activity, ListActivity.class);
        activity.startActivity(intent);
    }

    public static void toNetworkActivity(Activity activity) {
        Intent intent = new Intent(activity, NetworkActivity.class);
        activity.startActivity(intent);
    }
}
