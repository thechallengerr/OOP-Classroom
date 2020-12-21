package com.hus.oop_classroom.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hus.oop_classroom.R;
import com.hus.oop_classroom.model.Users;

import java.util.HashMap;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class ForgotPassword extends AppCompatActivity {
    EditText mail, pass_new, pwn;
    Button update, back;
    DatabaseReference ref;
    String email, pw, prn, passHash;
    Users users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ref = FirebaseDatabase.getInstance().getReference().child("Users");
        mail= findViewById(R.id.mEmail);
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
                    Toast.makeText(ForgotPassword.this, "Fill the blank,please", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pw.length() < 6) {
                    pass_new.setError("Password must be at least 6 characters");
                    return;
                }
                if (!prn.equals(pw)) {
                    pwn.setError("Don't match");
                    return;
                }

                passHash = BCrypt.withDefaults().hashToString(12, pw.toCharArray());
                ref.orderByChild("email").equalTo(email).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (!snapshot.exists()){
                            mail.setError("Email isn't vaid");
                            return;
                        } else {
                            for (DataSnapshot child: snapshot.getChildren()) {
                                //get the key of the child node that has to be updated
                                String postkey = child.getRef().getKey();
                                ref.child(postkey).child("password").setValue(passHash);
                                Toast.makeText(ForgotPassword.this, "Reset successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(ForgotPassword.this, Login.class));
                                finish();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}