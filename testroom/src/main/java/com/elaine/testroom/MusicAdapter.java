package com.elaine.testroom;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.elaine.testroom.databinding.ItemMusicBinding;
import com.elaine.testroom.db.music.MusicBean;

import org.jetbrains.annotations.NotNull;

/**
 * 列表适配器
 * author: elaine
 * date: 2021/7/9
 */
public class MusicAdapter extends BaseQuickAdapter<MusicBean, BaseDataBindingHolder<ItemMusicBinding>> {
    public MusicAdapter() {
        super(R.layout.item_music);
    }

    @Override
    protected void convert(@NotNull BaseDataBindingHolder<ItemMusicBinding> baseDataBindingHolder, MusicBean bean) {
        ItemMusicBinding mBinding = baseDataBindingHolder.getDataBinding();
        if (mBinding != null) {
            if (bean != null) {
                mBinding.setBean(bean);
            }
            mBinding.executePendingBindings();
        }
    }
}
