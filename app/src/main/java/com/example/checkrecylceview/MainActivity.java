package com.example.checkrecylceview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TAG = "MainActivity";
    private EditText mBookInput;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBookInput = findViewById(R.id.bookInput);
        button = findViewById(R.id.searchButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,RecycleActivity.class);
                String message = mBookInput.getText().toString();
                intent.putExtra(EXTRA_TAG,message);
                startActivity(intent);
            }
        });
    }

}
