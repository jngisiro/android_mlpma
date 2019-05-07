package com.subtledesigns.mlpma;

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
    // private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mPassword = findViewById(R.id.txt_password);
       // password = mPassword.getText().toString();
        auth = FirebaseAuth.getInstance();
    }

    private void addUser(View v){

    }

    public void createUser(View v){

        Toast.makeText(getApplicationContext(), "Ruuning add user", Toast.LENGTH_LONG).show();
        mEmail = findViewById(R.id.txt_email);
        String email = mEmail.getText().toString();

//        if(email.equals("") && password.equals("")){
//            Toast.makeText(getApplicationContext(), "Please fill in email and password", Toast.LENGTH_LONG).show();
//        }

//        else{
//            String email = mEmail.getText().toString();
//            String password = mPassword.getText().toString();
//            auth.createUserWithEmailAndPassword(email, password)
//                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if(task.isSuccessful()){
//                                Toast.makeText(getApplicationContext(), "User Registered Successfully",
//                                        Toast.LENGTH_LONG);
//                            }
//                            else{
//                                Toast.makeText(getApplicationContext(), "User could not be created",
//                                        Toast.LENGTH_LONG);
//                            }
//                        }
//                    });
//        }
    }
}
