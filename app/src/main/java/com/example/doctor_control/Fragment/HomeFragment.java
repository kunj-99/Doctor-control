package com.example.doctor_control.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.doctor_control.Adapter.RecentActivityAdapter;
import com.example.doctor_control.Model.RecentActivity;
import com.example.doctor_control.R;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recentActivityRecyclerView;
    private RecentActivityAdapter recentActivityAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize RecyclerView
        recentActivityRecyclerView = view.findViewById(R.id.recent_activity_recycler_view);
        recentActivityRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Create dummy data
        List<RecentActivity> recentActivities = new ArrayList<>();
        recentActivities.add(new RecentActivity("Completed appointment with John Doe", "2h ago"));
        recentActivities.add(new RecentActivity("New patient registration", "4h ago"));
        recentActivities.add(new RecentActivity("Prescription updated for Jane Smith", "1d ago"));
        recentActivities.add(new RecentActivity("Completed appointment with John Doe", "2h ago"));
        recentActivities.add(new RecentActivity("New patient registration", "4h ago"));
        recentActivities.add(new RecentActivity("Prescription updated for Jane Smith", "1d ago"));

        // Set adapter
        recentActivityAdapter = new RecentActivityAdapter(recentActivities);
        recentActivityRecyclerView.setAdapter(recentActivityAdapter);

        return view;
    }
}