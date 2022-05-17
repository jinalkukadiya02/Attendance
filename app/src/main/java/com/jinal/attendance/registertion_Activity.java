package com.jinal.attendance;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class registertion_Activity extends AppCompatActivity {
    EditText Name, Email, password, Confrim;
    RadioButton male, female;
    RadioGroup rg;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registertion);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Registration");
        Name = findViewById(R.id.edtName);
        Email = findViewById(R.id.edtEmail);
        password = findViewById(R.id.password);

        btn = findViewById(R.id.btn);
        rg = findViewById(R.id.gender);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                male = findViewById(R.id.male);
                female = findViewById(R.id.female);
                if (male.isChecked()) {
                    Toast.makeText(registertion_Activity.this, male.getText().toString(), Toast.LENGTH_SHORT).show();
                } else if (female.isChecked()) {
                    Toast.makeText(registertion_Activity.this, female.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(registertion_Activity.this, Login_Activity.class));
            }
        });

    }
}