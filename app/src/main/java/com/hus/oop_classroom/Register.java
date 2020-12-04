package com.hus.oop_classroom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    private static final String TAG = "REGISTER";
    EditText mEmail, mUser, password, passwordrepeat;
    String nemail, nuser, npass, npass2, type;
    FirebaseAuth mAuth;
    Button re;
    private Users user;
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
        user= new Users();
        re= findViewById(R.id.btn2);
        radSt= findViewById(R.id.radst);
        radTeacher= findViewById(R.id.radteacher);
        mAuth= FirebaseAuth.getInstance();
        ref= FirebaseDatabase.getInstance().getReference().child("Users");

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
                    Toast.makeText(Register.this, "Don't empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!nemail.contains("@")) {
                    mEmail.setError("Email must be @");
                return;
                }

                if (!npass.equals(npass2)) {
                    passwordrepeat.setError("Password repeat doesn't match");
                    return;
                }
//                if(ref.child("email").getDatabase().equals(nemail)){
//                    mEmail.setError("Email is existed");
//                    return;
//
//                }
                type = "";

                if (radSt.isChecked())
                {
                    type = "Student";
                }

                if (radTeacher.isChecked())
                {
                    type = "Teacher";
                }
                //user.setId(maxid+1);
                user.setEmail(nemail);
                user.setType(type);
                user.setUsername(nuser);
                user.setPassword(npass);

                ref.push().setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                           // mAuth.createUserWithEmailAndPassword(nemail,npass);
                            Toast.makeText(Register.this, "Create account successfully, login again", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this, Login.class));
                        }else{
                            Toast.makeText(Register.this,"Failed...",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        }


}