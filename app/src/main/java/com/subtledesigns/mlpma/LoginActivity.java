package com.subtledesigns.mlpma;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText mEmail, mPassword;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.txt_email);
        mPassword = findViewById(R.id.txt_password);

        auth = FirebaseAuth.getInstance();
    }

    public void loginUser(View v){
        if (mEmail.getText().toString().equals("") || mPassword.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Please fill in all the values",
                    Toast.LENGTH_LONG).show();
        }
        else{
            auth.signInWithEmailAndPassword(mEmail.getText().toString(), mPassword.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Login Success",
                                        Toast.LENGTH_LONG).show();
                                finish();
                                startActivity(new Intent(getApplicationContext(), ProductsActivity.class));
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Could not log you in", Toast.LENGTH_LONG);
                            }
                        }

                    });
        }
    }
}
