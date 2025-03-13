package com.example.doctor_control.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.provider.OpenableColumns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.doctor_control.Adapter.CertificationAdapter;
import com.example.doctor_control.Model.Certification;
import com.example.doctor_control.R;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;
import java.util.List;

public class fragment_edit_profile extends Fragment implements CertificationAdapter.OnCertificationActionListener {

    private TextInputEditText etName, etEmail, etPhone, etAddress;
    private Button btnSave, btnUploadCertification;
    private RecyclerView rvCertifications;
    private CertificationAdapter certificationAdapter;
    private List<Certification> certifications;

    private static final int PICK_FILE_REQUEST = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);

        // Initialize views
        etName = view.findViewById(R.id.et_name);
        etEmail = view.findViewById(R.id.et_email);
        etPhone = view.findViewById(R.id.et_phone);
        etAddress = view.findViewById(R.id.et_address);
        btnSave = view.findViewById(R.id.btn_save);
        btnUploadCertification = view.findViewById(R.id.btn_upload_certification);
        rvCertifications = view.findViewById(R.id.rv_certifications);

        // Load current profile data (example)
        loadProfileData();

        // Initialize certifications list and adapter
        certifications = new ArrayList<>();
        certificationAdapter = new CertificationAdapter(certifications, this);
        rvCertifications.setLayoutManager(new LinearLayoutManager(getContext()));
        rvCertifications.setAdapter(certificationAdapter);

        // Set click listeners
        btnSave.setOnClickListener(v -> saveProfileChanges());
        btnUploadCertification.setOnClickListener(v -> openFilePicker());

        return view;
    }

    private void loadProfileData() {
        // Example: Load current profile data
        etName.setText("Dr. John Doe");
        etEmail.setText("johndoe@example.com");
        etPhone.setText("+1 123 456 7890");
        etAddress.setText("123 Main St, City, Country");
    }

    private void saveProfileChanges() {
        // Get updated values
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String address = etAddress.getText().toString().trim();

        // Validate inputs
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty()) {
            Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save changes (example: update in database or backend)
        Toast.makeText(getContext(), "Profile updated successfully", Toast.LENGTH_SHORT).show();

        // Navigate back to profile page
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
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
            String fileName = getFileName(fileUri);
            certifications.add(new Certification(fileName, fileUri.toString()));
            certificationAdapter.notifyDataSetChanged();
        }
    }

    @SuppressLint("Range")
    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            try (Cursor cursor = getActivity().getContentResolver().query(uri, null, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }

    @Override
    public void onDeleteCertification(int position) {
        certifications.remove(position);
        certificationAdapter.notifyItemRemoved(position);
    }
}