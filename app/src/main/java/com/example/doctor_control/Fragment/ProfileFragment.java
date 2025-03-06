package com.example.doctor_control.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.doctor_control.R;

public class ProfileFragment extends Fragment {

    private Button btnEditProfile, btnChangePassword, btnLogout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize views
        btnEditProfile = view.findViewById(R.id.btn_edit_profile);
        btnChangePassword = view.findViewById(R.id.btn_change_password);
        btnLogout = view.findViewById(R.id.btn_logout);

        // Set click listeners
        btnEditProfile.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Edit Profile Clicked", Toast.LENGTH_SHORT).show();
            // Navigate to edit profile screen
        });

        btnChangePassword.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Change Password Clicked", Toast.LENGTH_SHORT).show();
            // Navigate to change password screen
        });

        btnLogout.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Logout Clicked", Toast.LENGTH_SHORT).show();
            // Handle logout logic
        });

        return view;
    }
}