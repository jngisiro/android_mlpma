package com.subtledesigns.mlpma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProductsActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    TextView profileText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        profileText = findViewById(R.id.txt_profileText);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        profileText.setText(user.getEmail());
    }

    public void signOut(View v){
        auth.signOut();
        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
