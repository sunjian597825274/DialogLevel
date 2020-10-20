package com.sunjay.dialoglevel.data;

import android.app.Dialog;
import android.util.Log;

import com.sunjay.dialoglevel.model.DialogLevelModel;

import java.util.ArrayList;
import java.util.Collections;

import androidx.annotation.Nullable;

public class DLArrayList extends ArrayList<DialogLevelModel> {
    public DLArrayList() {
        Collections.synchronizedList(this);
    }

    @Override
    public boolean contains(@Nullable Object o) {
        if(o == null){
            return false;
        }
        if(o instanceof Dialog){
            for (int i = 0; i < size(); i++){
                DialogLevelModel dialogLevelModel =get(i);
                if(dialogLevelModel.dialog == o){
                    return true;
                }
            }
            return false;
        }
        return super.contains(o);

    }

    @Override
    public boolean add(DialogLevelModel dialogLevelModel) {
        return super.add(dialogLevelModel);
    }
    public boolean sortAdd(DialogLevelModel inModel){
        Log.e("DLArrayList","add---"+inModel.level);
        int lastSize = size();
        if(lastSize == 0){
            return super.add(inModel);
        }
        int index = 0;
        for (int i = size()-1; i >=0; i--){
            DialogLevelModel temp = get(i);

            if(inModel.level >= temp.level){
                index = i+1;
                break;
            }
        }
        super.add(index,inModel);
        return true;
    }
    public void check(){
        Log.e("DLArrayList","size---"+size());
        String checkStr="";
        for (int i = 0; i < size(); i++){
            checkStr +="-"+get(i).level;
        }
        Log.e("DLArrayList","check---"+checkStr);
    }
}
