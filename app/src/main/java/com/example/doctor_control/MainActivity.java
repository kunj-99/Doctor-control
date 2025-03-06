package com.example.doctor_control;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.doctor_control.Fragment.AppointmentFragment;
import com.example.doctor_control.Fragment.HistoryFragment;
import com.example.doctor_control.Fragment.HomeFragment;
import com.example.doctor_control.Fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        // Set the default fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        }
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @SuppressLint("NonConstantResourceId")
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                if (item.getItemId() == R.id.navigation_home) {
                    selectedFragment = new HomeFragment();
                } else if (item.getItemId() == R.id.navigation_appointment) {
                    selectedFragment = new AppointmentFragment();
                } else if (item.getItemId() == R.id.navigation_history) {
                    selectedFragment = new HistoryFragment();
                } else {
                    selectedFragment = new ProfileFragment();
                }

                    if (selectedFragment != null) {
                        getSupportFragmentManager().beginTransaction()
                                .setCustomAnimations(
                                        R.anim.slide_in_right, // Enter animation
                                        R.anim.slide_out_left, // Exit animation
                                        R.anim.slide_in_left, // Pop enter animation
                                        R.anim.slide_out_right // Pop exit animation
                                )
                                .replace(R.id.fragment_container, selectedFragment)
                                .commit();
                    }


                    return true;
                }
            };
}