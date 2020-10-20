package com.sunjay.dialoglevel.controller;

import android.content.DialogInterface;

import com.sunjay.dialoglevel.model.DialogLevelModel;

public class DismissListenerBinder implements DialogInterface.OnDismissListener {
    DialogLevelModel model;
    DialogInterface.OnDismissListener dismissListener;
    OnDLDismissListener dlDismissListener;
    public DismissListenerBinder(DialogLevelModel model, OnDLDismissListener dlDismissListener, DialogInterface.OnDismissListener dismissListener) {
        this.model = model;
        this.dismissListener = dismissListener;
        this.dlDismissListener = dlDismissListener;
    }
    public void bind(){
        model.dialog.setOnDismissListener(this);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        if(dismissListener != null){
            dismissListener.onDismiss(dialog);
        }
        if(dlDismissListener != null){
            dlDismissListener.onDismiss(model);
        }
    }

    public interface OnDLDismissListener{
        void onDismiss(DialogLevelModel dialogLevelModel);
    }
}
