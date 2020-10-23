package com.elaine.testjetpack.list;

import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.elaine.testjetpack.R;
import com.elaine.testjetpack.base.BaseActivity;
import com.elaine.testjetpack.databinding.ActivityListBinding;

//TODO 待完善Adapter的点击事件
public class ListActivity extends BaseActivity<ActivityListBinding> {
    private ListViewModel listViewModel;
    private ListAdapter listAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_list;
    }

    @Override
    public void init() {
        initViewModel();
        initObserve();
        initAdapter();
    }

    private void initViewModel() {
        listViewModel = new ViewModelProvider(this).get(ListViewModel.class);
        mBinding.setViewModel(listViewModel);
        mBinding.setLifecycleOwner(this);
    }

    private void initObserve() {
        listViewModel.userBeanListMutableLiveData.observe(this, userBeans -> {
            listViewModel.userBeanList.clear();
            listViewModel.userBeanList.addAll(userBeans);
            listAdapter.notifyDataSetChanged();
        });
    }

    private void initAdapter() {
        listAdapter = new ListAdapter(listViewModel.userBeanList);
        mBinding.rvList.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvList.setAdapter(listAdapter);
        listAdapter.setOnItemClickListener((position, userBean) -> Toast.makeText(ListActivity.this, "data===" + userBean.getName(), Toast.LENGTH_SHORT).show());
    }

}