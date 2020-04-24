package com.example.firestore_example;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.annotation.Nullable;
public class MainActivity extends AppCompatActivity implements Adapter.onClick {

    TextView screen;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter myAdapter;
    String m, output, naav, waqqt, lavda;
    EditText et;
    Button enter;
    ArrayList<MSG> texts;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseUser user;
    CollectionReference chatRef = db.collection("Chatlog");
    CollectionReference userRef = db.collection("Users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.screen);
        et = findViewById(R.id.et);
        enter = findViewById(R.id.enter);
        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        Intent i = getIntent();
        lavda = i.getStringExtra("AAA");
        texts = new ArrayList<MSG>();
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            Intent intent = new Intent(MainActivity.this, com.example.firestore_example.LoginActivity.
                    class);
            startActivity(intent);
        }
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new Adapter(this, texts);
        myAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(myAdapter);

    }

    public void send(View v) {
        ZoneId z = ZoneId.of("Asia/Kolkata");
        LocalTime lt = LocalTime.now(z);
        output = lt.toString();
        final Message msg = new Message(lavda, et.getText().toString(), output);
        chatRef.add(msg);
//        texts.add(new MSG(m, naav, waqqt));
    }

    @Override
    protected void onStart() {
        super.onStart();
        chatRef.orderBy("samay").addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                String data = "";
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {

                    Message ms = documentSnapshot.toObject(Message.class);
                    m = ms.getMessage();
                    waqqt = ms.getSamay();
                    naav = ms.getUsername();
                    data += "  \n" + ms.getUsername() + ":   " + m + "    " + waqqt;
//                    texts.add(new MSG(m,naav,waqqt));

                }
//                screen.setText(data);
                texts.add(new MSG(m, naav, waqqt));
                myAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(myAdapter);
            }
        });
    }

    @Override
    public void onItemClicked(int index) {
    }
}