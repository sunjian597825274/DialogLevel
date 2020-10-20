package com.sunjay.dialoglevel.model;

import android.app.Activity;
import android.app.Dialog;

import java.lang.ref.WeakReference;

public class DialogLevelModel {
    public int level;
    public Dialog dialog;
    public WeakReference<Activity> activity;

    public DialogLevelModel(int level, Dialog dialog, WeakReference<Activity> activity) {
        this.level = level;
        this.dialog = dialog;
        this.activity = activity;
    }
}
