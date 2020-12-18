package com.hus.oop_classroom.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hus.oop_classroom.R;

public class ForgotPassword extends AppCompatActivity {
    EditText mail, pass_new, pwn;
    Button update, back;
    FirebaseAuth mAuth;
    DatabaseReference ref;
    String email, pw, prn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        mAuth = FirebaseAuth.getInstance();
        ref = FirebaseDatabase.getInstance().getReference().child("Users");
        pass_new = findViewById(R.id.pw1);
        pwn = findViewById(R.id.pw2);
        update = (Button) findViewById(R.id.btn3);
        back = findViewById(R.id.btn4);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPassword.this, Login.class));
                finish();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = mail.getText().toString().trim();
                pw = pass_new.getText().toString().trim();
                prn = pwn.getText().toString().trim();

                if (TextUtils.isEmpty(email)|| TextUtils.isEmpty(pw) || TextUtils.isEmpty(prn)) {
                    Toast.makeText(getApplication(), "Don't empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pw.length() < 6) {
                    pass_new.setError("Password must be at least 6 characters");
                    return;
                }
                if (pw != prn) {
                    pwn.setError("Dont't match");
                    return;
                }
//                ref.orderByChild("email").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        snapshot.getRef().child("password").setValue(pw);
//                        Toast.makeText(ForgotPassword.this, "Reset successfully", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getApplicationContext(), Login.class));
//                        finish();
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });


            }
        });
    }

}