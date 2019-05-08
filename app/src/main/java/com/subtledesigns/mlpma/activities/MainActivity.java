package com.subtledesigns.mlpma.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.subtledesigns.mlpma.R;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    private Button mAddData;
    private EditText mValueField;
    private EditText mKeyField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openRegister(View view){
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }

    public void openLogin(View view){
        startActivity(new Intent(this, LoginActivity.class));
    }
}
