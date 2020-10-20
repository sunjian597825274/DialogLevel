package com.sunjay.dialoglevel;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;

import com.sunjay.dialoglevel.controller.DialogLevelController;
import com.sunjay.dialoglevel.data.Constants;

/**
 * create by sunjay
 */
public class DialogManager {
    private static DialogLevelController dialogLevelController = DialogLevelController.getInstance();
    public static void showLow(final Dialog dialog, final Activity activity){
        dialogLevelController.safeShow(Constants.LEVEL_LOW,0,dialog,activity,null);
    }
    public static void showLow(final Dialog dialog, final Activity activity, DialogInterface.OnDismissListener dismissListener){
        dialogLevelController.safeShow(Constants.LEVEL_LOW,0,dialog,activity,dismissListener);
    }
    public static void showLowDelay(long delayMillis, final Dialog dialog, final Activity activity){
        dialogLevelController.safeShow(Constants.LEVEL_LOW,delayMillis,dialog,activity,null);
    }
    public static void showLowDelay(long delayMillis, final Dialog dialog, final Activity activity, DialogInterface.OnDismissListener dismissListener){
        dialogLevelController.safeShow(Constants.LEVEL_LOW,delayMillis,dialog,activity,dismissListener);
    }
    public static void showMid(final Dialog dialog, final Activity activity){
        dialogLevelController.safeShow(Constants.LEVEL_MID,0,dialog,activity,null);
    }
    public static void showMid(final Dialog dialog, final Activity activity, DialogInterface.OnDismissListener dismissListener){
        dialogLevelController.safeShow(Constants.LEVEL_MID,0,dialog,activity,dismissListener);
    }
    public static void showMidDelay(long delayMillis, final Dialog dialog, final Activity activity){
        dialogLevelController.safeShow(Constants.LEVEL_MID,delayMillis,dialog,activity,null);
    }
    public static void showMidDelay(long delayMillis, final Dialog dialog, final Activity activity, DialogInterface.OnDismissListener dismissListener){
        dialogLevelController.safeShow(Constants.LEVEL_MID,delayMillis,dialog,activity,dismissListener);
    }
    public static void showHigh(final Dialog dialog, final Activity activity){
        dialogLevelController.safeShow(Constants.LEVEL_HIGH,0,dialog,activity,null);
    }
    public static void showHigh(final Dialog dialog, final Activity activity, DialogInterface.OnDismissListener dismissListener){
        dialogLevelController.safeShow(Constants.LEVEL_HIGH,0,dialog,activity,dismissListener);
    }
    public static void showHighDelay(long delayMillis, final Dialog dialog, final Activity activity){
        dialogLevelController.safeShow(Constants.LEVEL_HIGH,delayMillis,dialog,activity,null);
    }
    public static void showHighDelay(long delayMillis, final Dialog dialog, final Activity activity, DialogInterface.OnDismissListener dismissListener){
        dialogLevelController.safeShow(Constants.LEVEL_HIGH,delayMillis,dialog,activity,dismissListener);
    }

    public static void show(final int level, final Dialog dialog, final Activity activity){
        dialogLevelController.safeShow(level,0,dialog,activity,null);
    }
    public static void show(final int level, final Dialog dialog, final Activity activity, DialogInterface.OnDismissListener dismissListener){
        dialogLevelController.safeShow(level,0,dialog,activity,dismissListener);
    }
    public static void showDelay(final int level,long delayMillis, final Dialog dialog, final Activity activity){
        dialogLevelController.safeShow(level,delayMillis,dialog,activity,null);
    }
    /**
     *
     * @param level 弹窗等级，level越大，在最上面显示
     * @param delayMillis 延时弹出
     * @param dialog
     * @param activity
     * @param dismissListener 如果为传dismissilistener，自己diaolog添加的listener会被覆盖
     */
    public static void showDelay(final int level,long delayMillis, final Dialog dialog, final Activity activity, DialogInterface.OnDismissListener dismissListener){
        dialogLevelController.safeShow(level,delayMillis,dialog,activity,dismissListener);
    }
}
