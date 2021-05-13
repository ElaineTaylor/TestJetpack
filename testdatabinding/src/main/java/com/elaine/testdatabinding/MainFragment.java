package com.elaine.testdatabinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.elaine.testdatabinding.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {
    private FragmentMainBinding fragmentMainBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false);
        return fragmentMainBinding.getRoot();
    }
}