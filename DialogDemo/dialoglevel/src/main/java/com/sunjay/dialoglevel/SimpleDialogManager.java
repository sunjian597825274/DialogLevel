package com.sunjay.dialoglevel;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;

import com.sunjay.dialoglevel.controller.SimpleDialogLevelController;
import com.sunjay.dialoglevel.data.Constants;

public class SimpleDialogManager {
    private SimpleDialogLevelController simpleDialogLevelController;

    public SimpleDialogManager(Activity activity) {
        this.simpleDialogLevelController = new SimpleDialogLevelController(activity);
    }
    public void showLow(final Dialog dialog){
        simpleDialogLevelController.safeShow(Constants.LEVEL_LOW,0,dialog,null);
    }
    public void showLow(final Dialog dialog,DialogInterface.OnDismissListener dismissListener){
        simpleDialogLevelController.safeShow(Constants.LEVEL_LOW,0,dialog,dismissListener);
    }
    public void showLowDelay(long delayMillis, final Dialog dialog){
        simpleDialogLevelController.safeShow(Constants.LEVEL_LOW,delayMillis,dialog,null);
    }
    public void showLowDelay(long delayMillis, final Dialog dialog, DialogInterface.OnDismissListener dismissListener){
        simpleDialogLevelController.safeShow(Constants.LEVEL_LOW,delayMillis,dialog,dismissListener);
    }
    public void showMid(final Dialog dialog){
        simpleDialogLevelController.safeShow(Constants.LEVEL_MID,0,dialog,null);
    }
    public void showMid(final Dialog dialog, DialogInterface.OnDismissListener dismissListener){
        simpleDialogLevelController.safeShow(Constants.LEVEL_MID,0,dialog,dismissListener);
    }
    public void showMidDelay(long delayMillis, final Dialog dialog){
        simpleDialogLevelController.safeShow(Constants.LEVEL_MID,delayMillis,dialog,null);
    }
    public void showMidDelay(long delayMillis, final Dialog dialog, DialogInterface.OnDismissListener dismissListener){
        simpleDialogLevelController.safeShow(Constants.LEVEL_MID,delayMillis,dialog,dismissListener);
    }
    public void showHigh(final Dialog dialog){
        simpleDialogLevelController.safeShow(Constants.LEVEL_HIGH,0,dialog,null);
    }
    public void showHigh(final Dialog dialog, DialogInterface.OnDismissListener dismissListener){
        simpleDialogLevelController.safeShow(Constants.LEVEL_HIGH,0,dialog,dismissListener);
    }
    public void showHighDelay(long delayMillis, final Dialog dialog){
        simpleDialogLevelController.safeShow(Constants.LEVEL_HIGH,delayMillis,dialog,null);
    }
    public void showHighDelay(long delayMillis, final Dialog dialog, DialogInterface.OnDismissListener dismissListener){
        simpleDialogLevelController.safeShow(Constants.LEVEL_HIGH,delayMillis,dialog,dismissListener);
    }

    public void show(final int level, final Dialog dialog){
        simpleDialogLevelController.safeShow(level,0,dialog,null);
    }
    public void show(final int level, final Dialog dialog, DialogInterface.OnDismissListener dismissListener){
        simpleDialogLevelController.safeShow(level,0,dialog,dismissListener);
    }
    public void showDelay(final int level,long delayMillis, final Dialog dialog){
        simpleDialogLevelController.safeShow(level,delayMillis,dialog,null);
    }
    /**
     *
     * @param level 弹窗等级，level越大，在最上面显示
     * @param delayMillis 延时弹出
     * @param dialog
     * @param dismissListener 如果为传dismissilistener，自己diaolog添加的listener会被覆盖
     */
    public void showDelay(final int level,long delayMillis, final Dialog dialog, DialogInterface.OnDismissListener dismissListener){
        simpleDialogLevelController.safeShow(level,delayMillis,dialog,dismissListener);
    }
}
