package com.hus.oop_classroom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText edit_email, edit_pw;
    public static final String USERNAME = "USERNAME";
    private FirebaseAuth mAuth;
    private Users users;
    TextView t1;
    Button login;
    String email, pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edit_email = (EditText) findViewById(R.id.edit_email);
        edit_pw = (EditText) findViewById(R.id.edit_pw);
        mAuth= FirebaseAuth.getInstance();
        t1= (TextView) findViewById(R.id.lnkRegister);

        t1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      startActivity(new Intent(Login.this, Register.class));
                                  }
                              }
        );
        login= (Button) findViewById(R.id.btnlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email =edit_email.getText().toString();
                pw=edit_pw.getText().toString();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pw)){
                    return;
                }
                if (!email.contains("@")) {
                    return;
                }
                mAuth.signInWithEmailAndPassword(email,pw).
                        addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Login.this, "Successfully Logged In", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }else {
                            Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_LONG).show();
                        }

                    }

                });

            }
        });
    }
}