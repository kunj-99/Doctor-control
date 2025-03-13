package com.example.doctor_control.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.doctor_control.Model.Certification;
import com.example.doctor_control.R;
import java.util.List;

public class CertificationAdapter extends RecyclerView.Adapter<CertificationAdapter.ViewHolder> {

    private List<Certification> certifications;
    private OnCertificationActionListener listener;

    public interface OnCertificationActionListener {
        void onDeleteCertification(int position);
    }

    public CertificationAdapter(List<Certification> certifications, OnCertificationActionListener listener) {
        this.certifications = certifications;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_certification, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Certification certification = certifications.get(position);
        holder.tvCertificationName.setText(certification.getName());

        holder.btnDelete.setOnClickListener(v -> {
            if (listener != null) {
                listener.onDeleteCertification(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return certifications.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCertificationName;
        public ImageButton btnDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCertificationName = itemView.findViewById(R.id.tv_certification_name);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }
    }
}