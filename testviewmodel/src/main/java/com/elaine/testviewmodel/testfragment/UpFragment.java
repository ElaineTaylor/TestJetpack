package com.elaine.testviewmodel.testfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.elaine.testviewmodel.R;

/**
 * 上面的Fragment，内有一个开关控件
 */
public class UpFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_up, container, false);
        Switch swUp = view.findViewById(R.id.sw_up);
        //注意，这里要用getActivity()，而不是this
        TestFragmentViewModel viewModel = new ViewModelProvider(getActivity(), new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(TestFragmentViewModel.class);
        //公共viewModel数据变化监听
        viewModel.getIsOpen().observe(this, swUp::setChecked);
        //控件操作监听
        swUp.setOnCheckedChangeListener((buttonView, isChecked) -> viewModel.getIsOpen().setValue(isChecked));
        return view;
    }
}