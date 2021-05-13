package com.elaine.testdatabinding.testbindingadapter;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

/**
 * bindingAdapter 文件
 * author: elaine
 * date: 2021/5/13
 */
public class MyBindingAdapter {

    /**
     * 单个参数
     *
     * @param imageView 图片控件
     * @param res       资源
     */
    @BindingAdapter("myImageRes")
    public static void setMyImageViewRes(ImageView imageView, int res) {
        imageView.setImageResource(res);
    }

    /**
     * 多个参数
     * requireAll = false 表示可以传一个参数
     *
     * @param textView       文字控件
     * @param content        内容
     * @param defaultContent 默认内容
     */
    @BindingAdapter(value = {"content", "defaultContent"}, requireAll = false)
    public static void setMyTextViewContent(TextView textView, String content, String defaultContent) {
        if (!TextUtils.isEmpty(content)) {
            textView.setText(content);
        } else {
            textView.setText(defaultContent);
        }
    }


}
