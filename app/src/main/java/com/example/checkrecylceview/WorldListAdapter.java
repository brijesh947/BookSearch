package com.example.checkrecylceview;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;

public class WorldListAdapter extends RecyclerView.Adapter<WorldListAdapter.ProgrammingViewHolder> {

    private String[] bookName;
    private String[] authorName;


    public WorldListAdapter(String[] bookName, String[] authorName) {
        this.bookName = bookName;
        this.authorName = authorName;
    }

    @NonNull
    @Override

    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fetching_data, parent, false);
        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, int position) {
        String book = bookName[position];
        String author = authorName[position];
        holder.mBookName.setText(book);
        holder.mAuthorName.setText(author);
    }

    @Override
    public int getItemCount() {
        return bookName.length;
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder {

        public TextView mBookName;
        public TextView mAuthorName;

        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);
            mBookName = itemView.findViewById(R.id.bookName);
            mAuthorName = itemView.findViewById(R.id.authorName);
        }
    }
}
