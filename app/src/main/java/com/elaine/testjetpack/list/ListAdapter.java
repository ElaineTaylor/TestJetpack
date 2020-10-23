package com.elaine.testjetpack.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elaine.testjetpack.bean.UserBean;
import com.elaine.testjetpack.databinding.ItemListBinding;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private List<UserBean> userBeanList;
    private OnItemClickListener onItemClickListener;

    public ListAdapter(List<UserBean> userBeanList) {
        this.userBeanList = userBeanList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.itemListBinding.setUserBean(userBeanList.get(position));
        holder.itemView.setOnClickListener(v -> onItemClickListener.OnItemClick(position, userBeanList.get(position)));
        holder.itemListBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return userBeanList.size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {

        private ItemListBinding itemListBinding;

        public ListViewHolder(@NonNull ItemListBinding itemListBinding) {
            super(itemListBinding.getRoot());
            this.itemListBinding = itemListBinding;
        }
    }

    public interface OnItemClickListener {
        void OnItemClick(int position, UserBean userBean);
    }
}
