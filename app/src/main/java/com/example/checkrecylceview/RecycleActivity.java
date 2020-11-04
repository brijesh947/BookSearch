package com.example.checkrecylceview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleActivity extends AppCompatActivity {
    private static final String TAG = "RecycleActivity";
    private TextView mTitleBook;
    private TextView mAuthorBook;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyle_activity);
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_TAG);
        mTitleBook = findViewById(R.id.bookName);
        mAuthorBook = findViewById(R.id.authorName);
        new FetchBook(recyclerView).execute(message);

    }


}
