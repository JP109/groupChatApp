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

public class LoginActivity extends AppCompatActivity {
    EditText ETemail;
    EditText ETpassword;
    Button BTNsignup;
    private FirebaseAuth mAuth;
    String email,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        ETemail=findViewById(R.id.ETemail);
        ETpassword=findViewById(R.id.ETpassword);
        BTNsignup=findViewById(R.id.BTNsignup);

        mAuth=FirebaseAuth.getInstance();
    }

    public void login(View v) {
        email = ETemail.getText().toString().trim();
        password = ETpassword.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){ Intent intent=new Intent(LoginActivity.this,com.example.firestore_example.MainActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });
    }

    public void CreateAcc(View view){
        Intent intent=new Intent(LoginActivity.this,com.example.firestore_example.SignUpActivity.class);
        startActivity(intent);
    }
}
