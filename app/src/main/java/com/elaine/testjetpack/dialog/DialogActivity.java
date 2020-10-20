package com.elaine.testjetpack.dialog;

import androidx.lifecycle.ViewModelProvider;

import com.elaine.testjetpack.R;
import com.elaine.testjetpack.base.BaseActivity;
import com.elaine.testjetpack.callback.DialogCallback;
import com.elaine.testjetpack.databinding.ActivityDialogBinding;

public class DialogActivity extends BaseActivity<ActivityDialogBinding> {
    private DialogViewModel dialogViewModel;
    private MyDialog myDialog;

    @Override
    public int getLayout() {
        return R.layout.activity_dialog;
    }

    @Override
    public void init() {
        initViewModel();
        initObserve();
    }

    private void initViewModel() {
        dialogViewModel = new ViewModelProvider(this).get(DialogViewModel.class);
        mBinding.setViewModel(dialogViewModel);
        mBinding.setLifecycleOwner(this);
    }

    private void initObserve() {
        dialogViewModel.isShowDialog.observe(this, isShowDialog -> {
            if (isShowDialog) {
                showDialog();
            } else {
                dismissDialog();
            }
        });
    }

    private void showDialog() {
        if (myDialog == null) {
            myDialog = new MyDialog(this, new DialogCallback() {
                @Override
                public void onDismiss(int type) {
                    if (type == 1) {
                        dialogViewModel.isShowDialog.setValue(false);
                    }
                }

                @Override
                public void onClick(Object o) {

                }
            });
        }
        myDialog.show();
        myDialog.setOnDismissListener(dialog -> myDialog = null);
    }

    private void dismissDialog() {
        if (myDialog != null && myDialog.isShowing()) {
            myDialog.dismiss();
        }
    }

}