package com.subtledesigns.mlpma;

import android.app.ProgressDialog;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPassword;
    private FirebaseAuth auth;
    private DatabaseReference rootRef;
    private FirebaseUser currentUser;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mPassword = findViewById(R.id.txt_registerPassword);
        mEmail = findViewById(R.id.txt_registerEmail);

        auth = FirebaseAuth.getInstance();
        rootRef = FirebaseDatabase.getInstance().getReference("users");
        dialog = new ProgressDialog(this);
    }

    public void createUser(View v){
        dialog.setMessage("Registering...");
        dialog.show();
        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();

        if(email.equals("") && password.equals("")){
            Toast.makeText(getApplicationContext(), "Please fill in email and password", Toast.LENGTH_LONG).show();
            dialog.dismiss();
        }

        else{
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(), "User Registered Successfully",
                                        Toast.LENGTH_LONG).show();

                                // Save user in database
                                currentUser = auth.getCurrentUser();
                                User newUser = new User(email, password);

                                rootRef.child(currentUser.getUid()).setValue(newUser);

                                finish();
                                startActivity(new Intent(getApplicationContext(), ProductsActivity.class));
                            }
                            else{
                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(), "User could not be created",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }
}
