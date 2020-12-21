package com.hus.oop_classroom.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hus.oop_classroom.Home;
import com.hus.oop_classroom.R;
import com.hus.oop_classroom.TeachersHome;
import com.hus.oop_classroom.model.Student;
import com.hus.oop_classroom.model.Teacher;
import com.hus.oop_classroom.model.Users;


import at.favre.lib.crypto.bcrypt.BCrypt;

public class Login extends AppCompatActivity {
    private EditText edit_email, edit_pw;
    DatabaseReference ref;
    CheckBox remember;
    TextView t1,t2;
    Button login;
    String email;
    String pw;
    String hash;
    String role;
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
        t2= (TextView) findViewById(R.id.lnkfw);
        login= (Button) findViewById(R.id.btnlogin);
        remember= (CheckBox) findViewById(R.id.remember);
        ref= FirebaseDatabase.getInstance().getReference().child("Users");
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
                Query query = ref.orderByChild("email").equalTo(email);
                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(!snapshot.exists()){
                                Toast.makeText(Login.this, "This account doesn't exists", Toast.LENGTH_SHORT).show();
                                return;
                            }else {
                                for (DataSnapshot user : snapshot.getChildren()) {
                                    hash = user.child("password").getValue().toString();
                                    BCrypt.Result pass_result = BCrypt.verifyer().verify(pw.toCharArray(), hash);
                                    role = user.child("role").getValue().toString();
                                    if (pass_result.verified == true) {
                                        Toast.makeText(Login.this, "Successfully Logged In", Toast.LENGTH_LONG).show();
                                        if (role.equals("1")) {
                                            startActivity(new Intent(Login.this, TeachersHome.class));
                                            finish();
                                        } else if (role.equals("0")) {
                                            startActivity(new Intent(Login.this, Home.class));
                                            finish();
                                        }

                                    } else {
                                        Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, ForgotPassword.class));
            }
        });
    }
}