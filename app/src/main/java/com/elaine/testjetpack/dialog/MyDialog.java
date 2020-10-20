package com.elaine.testjetpack.dialog;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;

import com.elaine.testjetpack.base.BaseApp;
import com.elaine.testjetpack.base.BaseDialog;
import com.elaine.testjetpack.callback.DialogCallback;
import com.elaine.testjetpack.databinding.DialogMyBinding;

public class MyDialog extends BaseDialog<DialogMyBinding> {

    public MyDialog(@NonNull Context context, DialogCallback callback) {
        super(context, callback);
    }

    @Override
    protected View getLayout() {
        mBinding = DialogMyBinding.inflate(getLayoutInflater());
        return mBinding.getRoot();
    }

    @Override
    protected void init() {
        mBinding.setCallback(callback);
    }
}
