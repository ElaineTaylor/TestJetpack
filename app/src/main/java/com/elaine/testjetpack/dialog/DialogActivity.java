package com.elaine.testjetpack.dialog;

import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.elaine.testjetpack.R;
import com.elaine.testjetpack.base.BaseActivity;
import com.elaine.testjetpack.bean.UserBean;
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
                    if ((UserBean) o != null) {
                        Toast.makeText(DialogActivity.this, "点击了确认按钮,用户姓名：" + ((UserBean) o).getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        if (!this.isFinishing() && !myDialog.isShowing()) {
            myDialog.show();
        }
        if (myDialog.isShowing()) {
            UserBean userBean = new UserBean();
            userBean.setNickname("测试对象昵称");
            userBean.setName("测试对象姓名");
            userBean.setSex(1);
            myDialog.initData(userBean);
        }
        myDialog.setOnDismissListener(dialog -> myDialog = null);
    }

    private void dismissDialog() {
        if (myDialog != null && myDialog.isShowing()) {
            myDialog.dismiss();
        }
    }

}