package com.example.doctor_control.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.doctor_control.R;
import com.google.android.material.textfield.TextInputEditText;

public class fragment_change_password extends Fragment {

    private TextInputEditText etCurrentPassword, etNewPassword, etConfirmNewPassword;
    private Button btnChangePassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change_password, container, false);

        // Initialize views
        etCurrentPassword = view.findViewById(R.id.et_current_password);
        etNewPassword = view.findViewById(R.id.et_new_password);
        etConfirmNewPassword = view.findViewById(R.id.et_confirm_new_password);
        btnChangePassword = view.findViewById(R.id.btn_change_password);

        // Set click listener for change password button
        btnChangePassword.setOnClickListener(v -> changePassword());

        return view;
    }

    private void changePassword() {
        // Get input values
        String currentPassword = etCurrentPassword.getText().toString().trim();
        String newPassword = etNewPassword.getText().toString().trim();
        String confirmNewPassword = etConfirmNewPassword.getText().toString().trim();

        // Validate inputs
        if (currentPassword.isEmpty() || newPassword.isEmpty() || confirmNewPassword.isEmpty()) {
            Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!newPassword.equals(confirmNewPassword)) {
            Toast.makeText(getContext(), "New passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validate current password (example: check against stored password)
        String storedPassword = "current_password"; // Replace with actual stored password
        if (!currentPassword.equals(storedPassword)) {
            Toast.makeText(getContext(), "Incorrect current password", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save new password (example: update in database or backend)
        Toast.makeText(getContext(), "Password changed successfully", Toast.LENGTH_SHORT).show();

        // Navigate back to profile page
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}