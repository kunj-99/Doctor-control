package com.example.doctor_control.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.doctor_control.Model.RecentActivity;
import com.example.doctor_control.R;
import java.util.List;

public class RecentActivityAdapter extends RecyclerView.Adapter<RecentActivityAdapter.ViewHolder> {

    private List<RecentActivity> recentActivities;

    public RecentActivityAdapter(List<RecentActivity> recentActivities) {
        this.recentActivities = recentActivities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recent_activity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecentActivity activity = recentActivities.get(position);
        holder.activityTitle.setText(activity.getActivityTitle());
        holder.activityTime.setText(activity.getActivityTime());
    }

    @Override
    public int getItemCount() {
        return recentActivities.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView activityIcon;
        public TextView activityTitle;
        public TextView activityTime;

        public ViewHolder(View itemView) {
            super(itemView);
            activityIcon = itemView.findViewById(R.id.activity_icon);
            activityTitle = itemView.findViewById(R.id.activity_title);
            activityTime = itemView.findViewById(R.id.activity_time);
        }
    }
}