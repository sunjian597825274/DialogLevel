package com.sunjay.dialogdemo;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sunjay.dialoglevel.DialogManager;
import com.sunjay.dialoglevel.SimpleDialogManager;

public class MainActivity extends Activity implements DialogInterface.OnDismissListener {
    SimpleDialogManager dialogLevelManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialogLevelManager = new SimpleDialogManager(MainActivity.this);
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.test1:
                for(int i = 0;i<10;i++){
                    final int level = (int)(1+Math.random()*1000);
                    final Dialog dialog = showCommonDialog("content:level-"+level);
                    DialogManager.showDelay(level,0,dialog,MainActivity.this,MainActivity.this);
                }
                final int level = (int)(1+Math.random()*1000);
                final Dialog dialog = showCommonDialog("content:level-"+level);
                DialogManager.showDelay(level,3200,dialog,MainActivity.this,MainActivity.this);
                break;
            case R.id.test2:
                for(int i = 0;i<15;i++){
                    final int level2 = (int)(1+Math.random()*1000);
                    final Dialog dialog2 = showCommonDialog("content:level-"+level2);
                    Log.e("dialoglevl","level:"+level2);
                    if(i ==13){
                        dialogLevelManager.showDelay(level2,2000,dialog2,MainActivity.this);
                        continue;
                    }
                    if(i ==14){
                        dialogLevelManager.showDelay(level2,3000,dialog2,MainActivity.this);
                        continue;
                    }
                    dialogLevelManager.show(level2,dialog2,MainActivity.this);
                }
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        showCommonDialog("content delay",55);
//                    }
//                },3000);
                break;
        }
    }
    private Dialog showCommonDialog(String content){
        final CommonDialog dialog = new CommonDialog(MainActivity.this,content,"title","cancle","go");
        dialog.setOnBtnClickListener(new CommonDialog.OnBtnClickListener() {
            @Override
            public void cancle() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                    }
                });
            }

            @Override
            public void go() {
                startActivity(new Intent(MainActivity.this,TestActivity.class));
            }
        });
        return dialog;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        Toast.makeText(MainActivity.this,"hahahahahaha",Toast.LENGTH_LONG).show();
    }
}
