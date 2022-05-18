package com.jinal.attendance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot_Activity extends AppCompatActivity {
    TextView edtEmail;
    Button btn;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        edtEmail=findViewById(R.id.edtEmail);
        mAuth= FirebaseAuth.getInstance();
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=edtEmail.getText().toString();

                mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(email.isEmpty()){
                            edtEmail.setError("Enter email..");
                        }else if (!task.isSuccessful()){
                            Toast.makeText(Forgot_Activity.this, "forgot password failed", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(Forgot_Activity.this, "forgot password successful..", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}