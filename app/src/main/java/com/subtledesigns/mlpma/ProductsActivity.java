package com.subtledesigns.mlpma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProductsActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
    }

    public void signOut(View v){
        auth.signOut();
        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
