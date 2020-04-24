package com.example.firestore_example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Profile extends AppCompatActivity {
    EditText ETuna;
    TextView TVuna;
    Button BTNsend;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference userRef=db.collection("Users");
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String una;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ETuna=findViewById(R.id.ETuna);
        BTNsend=findViewById(R.id.BTNsend);


       BTNsend.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
              una=ETuna.getText().toString();
                FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                UserProfileChangeRequest profileUpdates= new UserProfileChangeRequest.Builder().setDisplayName(una).build();
                user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Profile.this, "Profile updated", Toast.LENGTH_SHORT).show();
                        }
                    }


                });

                Intent i=new Intent(Profile.this,com.example.firestore_example.MainActivity.class);
               i.putExtra("AAA",una);
                startActivity(i);

            }
       });

        una=ETuna.getText().toString();
    }
}
