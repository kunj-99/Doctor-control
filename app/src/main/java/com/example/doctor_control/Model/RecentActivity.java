package com.example.doctor_control.Model;

public class RecentActivity {
    private String activityTitle;
    private String activityTime;

    public RecentActivity(String activityTitle, String activityTime) {
        this.activityTitle = activityTitle;
        this.activityTime = activityTime;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public String getActivityTime() {
        return activityTime;
    }
}