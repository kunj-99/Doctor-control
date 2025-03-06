package com.example.doctor_control.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.doctor_control.Model.HistoryItem;
import com.example.doctor_control.R;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private List<HistoryItem> historyItems;

    public HistoryAdapter(List<HistoryItem> historyItems) {
        this.historyItems = historyItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HistoryItem item = historyItems.get(position);
        holder.tvPatientName.setText(item.getPatientName());
        holder.tvAppointmentDate.setText("Appointment Date: " + item.getAppointmentDate());
        holder.tvProblem.setText("Problem: " + item.getProblem());

        if (item.isPaymentReceived()) {
            holder.tvPaymentStatus.setText("Payment Received");
            holder.tvPaymentStatus.setBackgroundResource(R.drawable.bg_payment_status);
        } else {
            holder.tvPaymentStatus.setText("Payment Pending");
            holder.tvPaymentStatus.setBackgroundResource(R.drawable.bg_payment_pending);
        }
    }

    @Override
    public int getItemCount() {
        return historyItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvPatientName, tvAppointmentDate, tvProblem, tvPaymentStatus;

        public ViewHolder(View itemView) {
            super(itemView);
            tvPatientName = itemView.findViewById(R.id.tv_patient_name);
            tvAppointmentDate = itemView.findViewById(R.id.tv_appointment_date);
            tvProblem = itemView.findViewById(R.id.tv_problem);
            tvPaymentStatus = itemView.findViewById(R.id.tv_payment_status);
        }
    }
}