package com.subtledesigns.mlpma;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Button mAddData;
    private EditText mValueField;
    private EditText mKeyField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mValueField = findViewById(R.id.txt_valueField);
        mKeyField = findViewById(R.id.txt_keyField);
        //FirebaseApp.initializeApp(this);

        // Write a message to the database
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference rootRef = database.getReference("users");

        rootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(getApplicationContext(), "Added ".concat(value), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//
//        myRef.setValue("Hello, World!");

       mAddData = findViewById(R.id.btn_addData);
       mAddData.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String value = mValueField.getText().toString();
               String key = mKeyField.getText().toString();
               rootRef.child(key).setValue(value);
           }
       });
    }
}
