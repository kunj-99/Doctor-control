package com.example.doctor_control.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doctor_control.Adapter.OngoingAppointmentAdapter;
import com.example.doctor_control.Model.Appointment;
import com.example.doctor_control.R;

import java.util.ArrayList;
import java.util.List;

public class AppointmentFragment extends Fragment implements OngoingAppointmentAdapter.OnAppointmentActionListener {

    private RecyclerView rvOngoingAppointments;
    private OngoingAppointmentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appointment, container, false);

        rvOngoingAppointments = view.findViewById(R.id.rv_ongoing_appointments);
        rvOngoingAppointments.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sample data - replace with actual data
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment("John Doe", "Fever & Headache"));
        appointments.add(new Appointment("Jane Smith", "Back Pain"));
        appointments.add(new Appointment("Jane Smith", "facture"));
        appointments.add(new Appointment("Jane Smith", "corona"));
        appointments.add(new Appointment("Jane Smith", "dengue"));
        adapter = new OngoingAppointmentAdapter(appointments, this);
        rvOngoingAppointments.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCancelAppointment(int position) {
        // Handle cancel action
        showCancelConfirmationDialog(position);
    }

    @Override
    public void onCompleteAppointment(int position) {
        // Handle complete action
        showCompleteConfirmationDialog(position);
    }

    private void showCancelConfirmationDialog(int position) {
        new AlertDialog.Builder(requireContext())
                .setTitle("Cancel Appointment")
                .setMessage("Are you sure you want to cancel this appointment?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    // Remove item from list
                    adapter.appointments.remove(position);
                    adapter.notifyItemRemoved(position);
                })
                .setNegativeButton("No", null)
                .show();
    }

    private void showCompleteConfirmationDialog(int position) {
        new AlertDialog.Builder(requireContext())
                .setTitle("Complete Appointment")
                .setMessage("Mark this appointment as completed?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    // Handle completion logic
                    adapter.appointments.remove(position);
                    adapter.notifyItemRemoved(position);
                })
                .setNegativeButton("No", null)
                .show();
    }
}