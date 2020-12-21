package com.hus.oop_classroom.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hus.oop_classroom.Home;
import com.hus.oop_classroom.R;
import com.hus.oop_classroom.TeachersHome;
import com.hus.oop_classroom.model.Student;
import com.hus.oop_classroom.model.Teacher;
import com.hus.oop_classroom.model.Users;

import java.util.HashMap;
import java.util.Map;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Register extends AppCompatActivity {
    private static final String TAG = "REGISTER";
    EditText mEmail, mUser, password, passwordrepeat;
    String nemail;
    String nuser;
    String npass;
    String npass2;
    String passHash;
    int role = 0;
    Users users;
    Button re;
    DatabaseReference ref;
    RadioButton radSt, radTeacher;
    int maxid=0;
    Map<String, Object > dataToSave = new HashMap<String, Object>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mEmail=(EditText)findViewById(R.id.mEmail);
        mUser= (EditText)findViewById(R.id.mUser);
        password=(EditText)findViewById(R.id.mPw);
        passwordrepeat=(EditText)findViewById(R.id.ppw);
        re= findViewById(R.id.btn2);
        radSt= findViewById(R.id.radst);
        radTeacher= findViewById(R.id.radteacher);
        ref= FirebaseDatabase.getInstance().getReference().child("Users");
        radSt.setChecked(true);
        radSt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radTeacher.setChecked(false);
                radSt.setChecked(true);
                role = 0;
            }
        });
        radTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radTeacher.setChecked(true);
                radSt.setChecked(false);
                role = 1;
            }
        });
//        if (radSt.isChecked())
//        {
//            role = 0;
//            radTeacher.setChecked(false);
//        }
//
//        if (radTeacher.isChecked())
//        {
//            role = 1;
//            radSt.setChecked(false);

//        }

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    maxid=(int) snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        re.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                nemail= mEmail.getText().toString().trim();
                nuser=mUser.getText().toString();
                npass=password.getText().toString().trim();
                npass2=passwordrepeat.getText().toString().trim();

                if (TextUtils.isEmpty(nemail) || TextUtils.isEmpty(npass) || TextUtils.isEmpty(npass2)){
                    Toast.makeText(Register.this, "Fill the blank,please", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!nemail.contains("@")) {
                    mEmail.setError("Email must contain @");
                    return;
                }
                if (!npass.equals(npass2)) {
                    passwordrepeat.setError("Password repeat doesn't match");
                    return;
                }
                //user.setId(maxid+1);
                if(role == 0){
                    users= new Student();
                }
                else users=new Teacher();

                ref.orderByChild("email").equalTo(nemail).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            mEmail.setError("This email already exists");
                            return;
                        }
                        else {
                            passHash = BCrypt.withDefaults().hashToString(12, npass.toCharArray());
                            users.setEmail(nemail);
                            users.setRole(role);
                            users.setUsername(nuser);
                            users.setPassword(passHash);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                ref.push().setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Register.this, "Create account successfully!", Toast.LENGTH_SHORT).show();
                            if(users.getRole() == 1) {
                                startActivity(new Intent(Register.this, TeachersHome.class));
                                finish();
                            }
                            else {
                                startActivity(new Intent(Register.this, Home.class));
                                finish();
                            }
                        }
                    }
                });
            }

        });
    }
}