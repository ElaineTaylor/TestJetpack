package com.elaine.testjetpack.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;

import com.elaine.testjetpack.R;
import com.elaine.testjetpack.callback.DialogCallback;

public abstract class BaseDialog<T> extends Dialog {
    public T mBinding;
    public DialogCallback callback;
    public Context context;
    public int gravity = Gravity.CENTER;
    public boolean cancel = true;
    public boolean backCancel = true;

    public BaseDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public BaseDialog(@NonNull Context context, DialogCallback callback) {
        super(context, R.style.baseDialog);
        this.context = context;
        this.callback = callback;
    }

    protected BaseDialog(@NonNull Context context, boolean cancel, boolean backCancel, DialogCallback callback) {
        super(context, R.style.baseDialog);
        this.context = context;
        this.callback = callback;
        this.cancel = cancel;
        this.backCancel = backCancel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        Window window = getWindow();
        if (window != null) {
            window.setGravity(gravity);
        }
        init();
        setCancelable(cancel);
        setCanceledOnTouchOutside(backCancel);
    }

    protected abstract View getLayout();

    protected abstract void init();
}
