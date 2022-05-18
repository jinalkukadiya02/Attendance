package com.jinal.attendance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Activity extends AppCompatActivity {
    Button btn;
    TextView Forgot, edtEmail, edtPassword, create;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Login");
        btn = findViewById(R.id.btn);
        create = findViewById(R.id.create);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        Forgot = findViewById(R.id.forgot);
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser()!=null){
            startActivity(new Intent(Login_Activity.this,Dashborad.class));
            finish();
        }
        Forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Activity.this, Forgot_Activity.class));
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Activity.this, registertion_Activity.class));
                finish();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString();
                String pass = edtPassword.getText().toString();

                if (email.isEmpty()) {
                    edtEmail.setError("Enter email..");
                } else if (pass.isEmpty()) {
                    edtPassword.setError("Enter password..");
                } else {
                    mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {

                                Toast.makeText(Login_Activity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            } else {

                                Toast.makeText(Login_Activity.this, "Login Success...", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    startActivity(new Intent(Login_Activity.this, MainActivity.class));
                }
            }
        });

    }
}