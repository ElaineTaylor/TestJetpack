package com.elaine.testdatabinding.secondarypage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.elaine.testdatabinding.R;
import com.elaine.testdatabinding.databinding.ActivitySecondaryPageBinding;

public class SecondaryPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary_page);
        ActivitySecondaryPageBinding activitySecondaryPageBinding= DataBindingUtil.setContentView(this,R.layout.activity_secondary_page);
        activitySecondaryPageBinding.setBean(new SecondaryPageBean("姓名"));
    }
}