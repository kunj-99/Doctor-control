package com.example.doctor_control.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.doctor_control.Model.Appointment;
import com.example.doctor_control.R;
import java.util.List;

public class OngoingAppointmentAdapter extends RecyclerView.Adapter<OngoingAppointmentAdapter.ViewHolder> {

    public List<Appointment> appointments;
    private OnAppointmentActionListener listener;

    public interface OnAppointmentActionListener {
        void onCancelAppointment(int position);
        void onCompleteAppointment(int position);
        void onAppointmentClick(int position); // Add this method
    }

    public OngoingAppointmentAdapter(List<Appointment> appointments, OnAppointmentActionListener listener) {
        this.appointments = appointments;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ongoing_appointment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Appointment appointment = appointments.get(position);
        holder.tvPatientName.setText(appointment.getPatientName());
        holder.tvProblem.setText(appointment.getProblem());

        // Set click listener for the entire item
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onAppointmentClick(position);
            }
        });

        holder.btnCancel.setOnClickListener(v -> {
            if (listener != null) {
                listener.onCancelAppointment(position);
            }
        });

        holder.btnComplete.setOnClickListener(v -> {
            if (listener != null) {
                listener.onCompleteAppointment(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvPatientName, tvProblem;
        public Button btnCancel, btnComplete;

        public ViewHolder(View itemView) {
            super(itemView);
            tvPatientName = itemView.findViewById(R.id.tv_patient_name);
            tvProblem = itemView.findViewById(R.id.tv_problem);
            btnCancel = itemView.findViewById(R.id.btn_cancel);
            btnComplete = itemView.findViewById(R.id.btn_complete);
        }
    }
}