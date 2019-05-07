package com.subtledesigns.mlpma;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPassword;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mPassword = findViewById(R.id.txt_registerPassword);
        mEmail = findViewById(R.id.txt_registerEmail);

        auth = FirebaseAuth.getInstance();
    }

    public void createUser(View v){

        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        if(email.equals("") && password.equals("")){
            Toast.makeText(getApplicationContext(), "Please fill in email and password", Toast.LENGTH_LONG).show();
        }

        else{
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "User Registered Successfully",
                                        Toast.LENGTH_LONG).show();
                                finish();
                                startActivity(new Intent(getApplicationContext(), ProductsActivity.class));
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "User could not be created",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }
}
