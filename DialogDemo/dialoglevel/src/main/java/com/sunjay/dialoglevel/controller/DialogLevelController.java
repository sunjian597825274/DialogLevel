package com.sunjay.dialoglevel.controller;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;

import java.util.ArrayList;
import java.util.List;

public class DialogLevelController {
    private List<SimpleDialogLevelController> levelManagers = new ArrayList<>();
    private static DialogLevelController instance;
    public static DialogLevelController getInstance(){
        if(instance == null){
            instance = new DialogLevelController();
        }
        return instance;
    }


    /**
     *如果为传dismissilistener，自己diaolog添加的listener会被覆盖
     * @param level
     * @param dialog
     * @param activity
     * @param dismissListener
     */
    public void safeShow(final int level,long delayMillis, final Dialog dialog, final Activity activity, DialogInterface.OnDismissListener dismissListener){
        check();
        if(levelManagers.size() == 0){
            SimpleDialogLevelController levelManager = new SimpleDialogLevelController(activity);
            levelManager.safeShow(level,delayMillis,dialog,dismissListener);
            levelManagers.add(levelManager);
            return;
        }
        SimpleDialogLevelController inManager = null;
        for (int i =0;i<levelManagers.size();i++){
            SimpleDialogLevelController temp = levelManagers.get(i);
            if(temp.getActivity() == activity){
                inManager = temp;
                break;
            }
        }
        if(inManager == null){
            inManager =new SimpleDialogLevelController(activity);
            levelManagers.add(inManager);
        }
        inManager.safeShow(level,delayMillis, dialog,dismissListener);
    }

    /**
     * 检查是否有被销毁的activity
     */
    private void check(){
        int i = 0;
        while (true){
            if(i>levelManagers.size()-1){
                break;
            }
            SimpleDialogLevelController temp = levelManagers.get(i);
            if(temp.getActivity() == null || temp.getActivity().isFinishing()){
                levelManagers.remove(i);
            }else {
                i++;
            }
        }
    }
}
