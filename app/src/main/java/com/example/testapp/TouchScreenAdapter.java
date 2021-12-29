package com.example.testapp;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TouchScreenAdapter extends RecyclerView.Adapter<TouchScreenAdapter.ViewHolder>
{
    private LayoutInflater inflater;
    private static final int ITEM_COUNT = 120;

    private List<TouchScreenDataModel> items;

    public TouchScreenAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        items = new ArrayList<>();
        for (int i = 0; i < ITEM_COUNT; i++) {
            items.add(new TouchScreenDataModel(false, i));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(items.get(position).isSelected())
            holder.itemView.setBackgroundColor(Color.YELLOW);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setSelected(int position, boolean selected) {
        if (items.get(position).isSelected() != selected) {
            items.get(position).setSelected(selected);
            notifyItemChanged(position);
        }
    }

    public Boolean getSelected(int position) {
        return  items.get(position).isSelected();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private View parentView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            parentView = itemView.findViewById(R.id.parent);
        }

    }
}