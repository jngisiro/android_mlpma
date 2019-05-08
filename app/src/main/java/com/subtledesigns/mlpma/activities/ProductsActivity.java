package com.subtledesigns.mlpma.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.subtledesigns.mlpma.R;

public class ProductsActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    StorageReference storageReference;
    TextView profileText;
    Uri imageUri;
    ImageView imageView;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        dialog = new ProgressDialog(this);

        imageView = findViewById(R.id.image_product);
        profileText = findViewById(R.id.txt_profileText);

        storageReference = FirebaseStorage.getInstance().getReference().child("user-images");
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        profileText.setText(user.getEmail());
    }

    public void signOut(View v){
        dialog.setMessage("Signing Out...");
        dialog.show();
        auth.signOut();
        dialog.dismiss();
        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    public void openGallery(View v){
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, 12);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 12 && resultCode == RESULT_OK && data != null){
            imageUri = data.getData();
            imageView.setImageURI(imageUri);

            // Upload the uri image to firebase
            dialog.setMessage("Uploading image");
            dialog.show();
            StorageReference sRef = storageReference.child(user.getUid() + ".jpg");
            sRef.putFile(imageUri)
                    .addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if(task.isSuccessful()){
                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(), "File uploaded Succesfully",
                                        Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Could not upload image", Toast.LENGTH_LONG).show();
                                dialog.dismiss();
                            }
                        }
                    });
        }
    }
}
