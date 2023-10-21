package com.example.sdut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String [][] doctor_details1 =
            {

                    {"Doctor Name : Ajit Saste",     "Hospital Address : Pimpri",    "Exp : 5yrs",  "Mabile no:9898989898", "600"},
                    {"Doctor Name : Prasad Pawar",   "Hospital Address : Niqdi",     "Exp : 15yrs", "Mabile no:01715482928", "900"},
                    {"Doctor Name : Swapnil Kale",   "Hospital Address : Pune",      "Exp : 8yrs",  "Mabile no:01715422928", "300"},
                    {"Doctor Name : Deepak Deshmukh","Hospital Address : Chinchwad", "Exp : 6yrs",  "Mabile no:01714582928", "500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katraj", "Exp : 7yrs",        "Mabile no:07115482928", "800"}

            };

    private String [][] doctor_details2 =
            {

                    {"Doctor Name : oslil Saste",     "Hospital Address : Pimpri",    "Exp : 5yrs",  "Mabile no:9898989898", "600"},
                    {"Doctor Name : Pr Pawar",   "Hospital Address : Niqdi",     "Exp : 15yrs", "Mabile no:01715482928", "900"},
                    {"Doctor Name : apnil Kale",   "Hospital Address : Pune",      "Exp : 8yrs",  "Mabile no:01715422928", "300"},
                    {"Doctor Name : Dee Deshmukh","Hospital Address : Chinchwad", "Exp : 6yrs",  "Mabile no:01714582928", "500"},
                    {"Doctor Name : Ash Panda", "Hospital Address : Katraj", "Exp : 7yrs",        "Mabile no:07115482928", "800"}

            };

    private String [][] doctor_details3 =
            {

                    {"Doctor Name : Ajit Se",     "Hospital Address : Pimpri",    "Exp : 5yrs",  "Mabile no:9898989898", "600"},
                    {"Doctor Name : Prasad ar",   "Hospital Address : Niqdi",     "Exp : 15yrs", "Mabile no:01715482928", "900"},
                    {"Doctor Name : Swa Kale",   "Hospital Address : Pune",      "Exp : 8yrs",  "Mabile no:01715422928", "300"},
                    {"Doctor Name : Dee Deshmukh","Hospital Address : Chinchwad", "Exp : 6yrs",  "Mabile no:01714582928", "500"},
                    {"Doctor Name : Asok nda", "Hospital Address : Katraj", "Exp : 7yrs",        "Mabile no:07115482928", "800"}

            };

    private String [][] doctor_details4 =
            {

                    {"Doctor Name : Ajite",     "Hospital Address : Pimpri",    "Exp : 5yrs",  "Mabile no:9898989898", "1600"},
                    {"Doctor Name : Praawar",   "Hospital Address : Niqdi",     "Exp : 15yrs", "Mabile no:01715482928", "1900"},
                    {"Doctor Name : Swapale",   "Hospital Address : Pune",      "Exp : 8yrs",  "Mabile no:01715422928", "1300"},
                    {"Doctor Name : Deeshkh","Hospital Address : Chinchwad", "Exp : 6yrs",  "Mabile no:01714582928", "1500"},
                    {"Doctor Name : Ashnda", "Hospital Address : Katraj", "Exp : 7yrs",        "Mabile no:07115482928", "1800"}

            };

    private String [][] doctor_details5 =
            {

                    {"Doctor Name : Ajste",     "Hospital Address : Pimpri",    "Exp : 5yrs",  "Mabile no:9898989898", "1600"},
                    {"Doctor Name : Prawar",   "Hospital Address : Niqdi",     "Exp : 15yrs", "Mabile no:01715482928", "1900"},
                    {"Doctor Name : Swaple",   "Hospital Address : Pune",      "Exp : 8yrs",  "Mabile no:01715422928", "1300"},
                    {"Doctor Name : Deemukh","Hospital Address : Chinchwad", "Exp : 6yrs",  "Mabile no:01714582928", "1500"},
                    {"Doctor Name : Ashoda", "Hospital Address : Katraj", "Exp : 7yrs",        "Mabile no:07115482928", "1800"}

            };


    TextView tv;
    Button btn;
   String[][] doctor_details = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });
    }
}