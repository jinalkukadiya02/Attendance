package com.jinal.attendance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registertion_Activity extends AppCompatActivity {
    EditText Name, Email, password;
    RadioButton male, female;
    RadioGroup rg;
    Button btn;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registertion);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Registration");
        actionBar.setDisplayHomeAsUpEnabled(true);
        Name = findViewById(R.id.edtName);
        Email = findViewById(R.id.edtEmail);
        password = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
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
                registerNewUser();
            }

            private void registerNewUser() {
                String nam = Name.getText().toString();
                String emil = Email.getText().toString();
                String Pass = password.getText().toString();


                if (nam.isEmpty()) {
                    Name.setError("Please Enter your name!");
                } else if (emil.isEmpty()) {
                    Email.setError("Please Enter your email!");

                } else if (Pass.isEmpty()) {
                    password.setError("Please Enter your password!");

                } else {
                    mAuth.createUserWithEmailAndPassword(emil, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(registertion_Activity.this, MainActivity.class));
                                Toast.makeText(registertion_Activity.this, "Registration Success....", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(registertion_Activity.this, "Registration Failed...", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }

        });


    }
}