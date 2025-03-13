package com.example.doctor_control.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.doctor_control.Model.Appointment;
import com.example.doctor_control.R;
import com.google.android.material.textfield.TextInputEditText;

public class fragment_medicine_report_form extends Fragment {

    private TextView tvPatientName, tvProblem;
    private TextInputEditText etMedicines;
    private Button btnUploadReport, btnSave;
    private Appointment appointment;

    private static final int PICK_FILE_REQUEST = 1;

    public fragment_medicine_report_form(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_medicine_report_form, container, false);

        // Initialize views
        tvPatientName = view.findViewById(R.id.tv_patient_name);
        tvProblem = view.findViewById(R.id.tv_problem);
        etMedicines = view.findViewById(R.id.et_medicines);
        btnUploadReport = view.findViewById(R.id.btn_upload_report);
        btnSave = view.findViewById(R.id.btn_save);

        // Set patient details
        tvPatientName.setText(appointment.getPatientName());
        tvProblem.setText("Problem: " + appointment.getProblem());

        // Set click listeners
        btnUploadReport.setOnClickListener(v -> openFilePicker());
        btnSave.setOnClickListener(v -> saveForm());

        return view;
    }

    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, PICK_FILE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FILE_REQUEST && data != null) {
            Uri fileUri = data.getData();
            Toast.makeText(getContext(), "Report uploaded: " + fileUri.getLastPathSegment(), Toast.LENGTH_SHORT).show();
        }
    }

    private void saveForm() {
        String medicines = etMedicines.getText().toString().trim();

        if (medicines.isEmpty()) {
            Toast.makeText(getContext(), "Please enter medicines", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save the form data (example: save to database or backend)
        Toast.makeText(getContext(), "Form saved successfully", Toast.LENGTH_SHORT).show();

        // Navigate back to the appointment list
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}