package com.example.courseproject1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.DayViewHolder> {
    private int[] days;
    private OnItemClickListener onItemClickListener;

    public DaysAdapter(int[] days, OnItemClickListener onItemClickListener) {
        this.days = days;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public DayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_day, parent, false);
        return new DayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DayViewHolder holder, int position) {
        holder.tvDay.setText(String.valueOf(days[position]));
    }

    @Override
    public int getItemCount() {
        return days.length;
    }

    class DayViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvDay;

        DayViewHolder(View itemView) {
            super(itemView);
            tvDay = itemView.findViewById(R.id.tvDay);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
