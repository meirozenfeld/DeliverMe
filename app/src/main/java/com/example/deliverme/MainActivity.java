package com.example.deliverme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    Button signout;
    TextView text;
    TextView text_deliver;
   private Button send_btn, take_btn;

    DatabaseReference all_name;
    String x="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signout=(Button)findViewById(R.id.Logout);
        send_btn=(Button)findViewById(R.id.send_delivery);
        take_btn =(Button)findViewById(R.id.take_delivery);
        text_deliver = (TextView) findViewById(R.id.textGrid);

        ////**** this part for get name from user
        text = (TextView)findViewById(R.id.userName_);

        FirebaseUser take_id=FirebaseAuth.getInstance().getCurrentUser();

        String userId= take_id.getUid();

        DatabaseReference user = FirebaseDatabase.getInstance().getReference("users");
        DatabaseReference user1 = user.child(userId);
        DatabaseReference all_name = user1.child("allName");

        all_name.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                 x = dataSnapshot.getValue().toString();
                text.setText("Hallo "+x);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        ////****


        take_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_take();
            }
        });
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_send();
            }
        });
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                move_profile();
            }
        });
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }

        });
//        text_deliver.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                move_profile();
//            }
//        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_manu, menu);
        return true;
    }
    public void open_send()
    {
        Intent intent=new Intent(this, Client.class);
        startActivity(intent);
    }
    public void open_take()
    {
        Intent intent=new Intent(this, Delivery_Person.class);
        startActivity(intent);
    }
    public void move_profile()
    {
//        Toast.makeText(MainActivity.this,"clicked", LENGTH_SHORT).show();
        Intent intent=new Intent(this, Prof.class);
        startActivity(intent);
    }
}
///////132