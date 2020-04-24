package com.example.firestore_example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    EditText ETemail;
    EditText ETpassword;
    EditText ETusername;
    Button BTNsignup;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference userRef=db.collection("Users");
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String email, password, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ETemail = findViewById(R.id.ETemail);
        ETpassword = findViewById(R.id.ETpassword);
        BTNsignup = findViewById(R.id.BTNsignup);
        mAuth = FirebaseAuth.getInstance();

    }


    public void signup(View view) {

        email = ETemail.getText().toString().trim();
        password = ETpassword.getText().toString().trim();
//        username=ETusername.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    UserProfileChangeRequest profileUpdates= new UserProfileChangeRequest.Builder().setDisplayName("lavda").build();

                    Toast.makeText(SignUpActivity.this, "Signed up successfully", Toast.LENGTH_SHORT).show();
                    Intent inte = new Intent(SignUpActivity.this, com.example.firestore_example.Profile.class);

                    startActivity(inte);
                } else {
                    Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}






