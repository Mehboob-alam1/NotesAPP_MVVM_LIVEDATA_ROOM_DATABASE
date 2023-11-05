package com.mehboob.roomdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.mehboob.roomdatabase.databinding.EachRvBinding;

public class RvAdapter extends ListAdapter<Note,RvAdapter.RvHolder> {

    public RvAdapter() {
super(CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Note> CALLBACK = new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getId()== newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getTitle().equals(newItem.getTitle())
                    &&oldItem.getDesc().equals(newItem.getDesc());
        }
    };
    @NonNull
    @Override
    public RvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.each_rv,parent,false);
        return new RvHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvHolder holder, int position) {
Note note=getItem(position);
holder.binding.txtDesc.setText(note.getDesc());
holder.binding.txtTitle.setText(note.getTitle());
    }

    public class RvHolder extends RecyclerView.ViewHolder{
EachRvBinding binding;
        public RvHolder(@NonNull View itemView) {
            super(itemView);

            binding=EachRvBinding.bind(itemView);
        }
    }
}
