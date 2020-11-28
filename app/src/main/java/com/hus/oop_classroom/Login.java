package com.hus.oop_classroom;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText edit_email, edit_pw;
    private FirebaseAuth mAuth;
    private Users users;
    CheckBox remember;
    TextView t1;
    Button login;
    String email, pw;
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor editor;
    private Boolean saveLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edit_email = (EditText) findViewById(R.id.edit_email);
        edit_pw = (EditText) findViewById(R.id.edit_pw);
        t1= (TextView) findViewById(R.id.lnkRegister);
        login= (Button) findViewById(R.id.btnlogin);
        remember= (CheckBox) findViewById(R.id.remember);
        mAuth= FirebaseAuth.getInstance();
        mPrefs= getSharedPreferences("checkbox",MODE_PRIVATE);
        editor= mPrefs.edit();

        //Get the user name and password data stored in the preferences
        //Put the data we stored in the two input boxes
        saveLogin = mPrefs.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            edit_email.setText(mPrefs.getString("email", ""));
            edit_pw.setText(mPrefs.getString("pass", ""));
            remember.setChecked(true);
        }

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email =edit_email.getText().toString().trim();
                pw=edit_pw.getText().toString().trim();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pw)){
                    edit_email.setError("required");
                    edit_pw.setError("required");
                    return;
                }
                if (!email.contains("@")) {
                    return;
                }

                if(view== login) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edit_email.getWindowToken(), 0);
                    if (remember.isChecked()) {
                        editor.putBoolean("saveLogin", true);
                        editor.putString("email", email);
                        editor.putString("pass", pw);
                        editor.commit();
                    } else {
                        editor.clear();
                        editor.commit();
                    }
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