package com.sunjay.dialoglevel.controller;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;

import com.sunjay.dialoglevel.data.DLArrayList;
import com.sunjay.dialoglevel.model.DialogLevelModel;

import java.lang.ref.WeakReference;
public class SimpleDialogLevelController implements DismissListenerBinder.OnDLDismissListener {
    DLArrayList waitList = new DLArrayList();
    DLArrayList showList = new DLArrayList();
    private WeakReference<Activity> activity;
    public SimpleDialogLevelController(Activity activity) {
        this.activity = new WeakReference<>(activity);
    }
    public void safeShow(final int level, final Dialog dialog,final DialogInterface.OnDismissListener onDismissListener){
        safeShow(level, 0, dialog, onDismissListener);
    }
    public void safeShow(final int level,long delayMillis, final Dialog dialog,final DialogInterface.OnDismissListener onDismissListener){
//        if (Looper.myLooper() != Looper.getMainLooper()) {
//            new Handler(Looper.getMainLooper()).post(new Runnable() {
//                @Override
//                public void run() {
//                    show(level,dialog,onDismissListener);
//                }
//            });
//        }else{
//            show(level,dialog,onDismissListener);
//        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                show(level,dialog,onDismissListener);
            }
        },delayMillis);
    }
    private void show(int level, Dialog dialog, DialogInterface.OnDismissListener onDismissListener){
        if(dialog == null){
            return;
        }
        DialogLevelModel topDialog = getTopShowingDialog();
        DialogLevelModel inModel = new DialogLevelModel(level, dialog, activity);
        new DismissListenerBinder(inModel,this,onDismissListener).bind();
        if(topDialog ==null || level >= topDialog.level){
            realShow(inModel);
        }else {
            waitList.sortAdd(new DialogLevelModel(level, dialog, activity));
        }
    }
    private void realShow(DialogLevelModel dialogLevelModel){
        waitList.remove(dialogLevelModel);
        showList.add(dialogLevelModel);
        if(dialogLevelModel.activity != null && dialogLevelModel.activity.get() != null && !dialogLevelModel.activity.get().isFinishing()){
            dialogLevelModel.dialog.show();
        }else{
            destory();
        }
    }
    private void remove(DialogLevelModel dialogLevelModel){
        waitList.remove(dialogLevelModel);
        showList.remove(dialogLevelModel);
    }
    private void destory(){
        waitList.clear();
        showList.clear();
    }

    @Override
    public void onDismiss(DialogLevelModel dialogLevelModel) {
        for(int i = showList.size()-1;i>=0;i--){
            if(showList.get(i).dialog == dialogLevelModel.dialog){
                showList.remove(i);
                break;
            }
        }

        boolean flag =true;
        while (flag) {
            if(waitList.size() == 0){
                break;
            }
            DialogLevelModel tempModel = waitList.get(waitList.size() -1);
            if (getTopShowingDialog() == null) {
                realShow(tempModel);
            } else if (tempModel.level >= getTopShowingDialog().level) {
                realShow(tempModel);
            } else {
                break;
            }
        }
    }
    public Activity getActivity(){
        return activity.get();
    }
    private DialogLevelModel getTopShowingDialog(){
        if(showList.size()>0){
            return showList.get(showList.size()-1);
        }
        return null;
    }
}
