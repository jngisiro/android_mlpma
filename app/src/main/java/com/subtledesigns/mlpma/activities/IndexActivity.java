package com.subtledesigns.mlpma.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.subtledesigns.mlpma.R;
import com.subtledesigns.mlpma.model.Product;

import java.util.List;

public class IndexActivity extends AppCompatActivity {

    private final String JSONURL = "";
    private jsonArrayRequest;
    private RequestQueue;
    private List<Product> products;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }
}
