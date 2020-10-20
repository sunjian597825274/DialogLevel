package com.sunjay.dialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CommonDialog extends Dialog implements View.OnClickListener {
    private Context context;
    private  String content,title,cancle,go;
    private boolean cancleTouchOuside,cancleAble;
    private TextView tv_content;
    private TextView tv_title;
    private TextView tv_cancle;
    private TextView tv_go;
    private OnBtnClickListener onBtnClickListener;
    public CommonDialog(@NonNull Context context,String content,String title,String cancle,String go) {
        super(context);
        this.content = content;
        this.title = title;
        this.cancle = cancle;
        this.go = go;
        init(context);
    }
    private void init(Context context){
        View contentView = View.inflate(context, R.layout.dialog_common,null);
        tv_title = contentView.findViewById(R.id.tv_common_title);
        tv_content = contentView.findViewById(R.id.tv_common_content);
        tv_cancle = contentView.findViewById(R.id.tv_common_cancel);
        tv_go = contentView.findViewById(R.id.tv_common_go);
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);
        tv_cancle.setOnClickListener(this);
        tv_go.setOnClickListener(this);
        setContentView(contentView);
        initData();
    }
    private void initData() {
        tv_content.setText(TextUtils.isEmpty(content) ? "" : content);
        tv_title.setText(TextUtils.isEmpty(title) ? "" : title);
        if (TextUtils.isEmpty(go)) {
            tv_go.setVisibility(View.GONE);
        } else {
            tv_go.setText(go);
        }
        if (TextUtils.isEmpty(cancle)) {
            tv_cancle.setVisibility(View.GONE);
        } else {
            tv_cancle.setText(cancle);
        }
    }
    public void setOnBtnClickListener(OnBtnClickListener onBtnClickListener) {
        this.onBtnClickListener = onBtnClickListener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_common_cancel:
                if(onBtnClickListener != null){
                    onBtnClickListener.cancle();
                }
                break;
            case R.id.tv_common_go:
                if(onBtnClickListener != null){
                    onBtnClickListener.go();
                }
                break;

        }
    }

    public interface OnBtnClickListener{
        void cancle();
        void go();
    }
}
