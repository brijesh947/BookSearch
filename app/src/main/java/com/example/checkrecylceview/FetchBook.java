package com.example.checkrecylceview;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class FetchBook extends AsyncTask<String, Void, String> {

    private static final String TAG = "FetchBook";


    RecyclerView recyclerView;

    public FetchBook(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }


    @Override
    protected String doInBackground(String... strings) {
        Log.d(TAG, "doInBackground: running ");
        return NetworkUtils.getBookInfo(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            int i = 0;

            String[] author = new String[itemsArray.length()];
            String[] title = new String[itemsArray.length()];
            while (i < itemsArray.length()) {
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");
                try {
                    author[i] = volumeInfo.getString("authors");
                    title[i] = volumeInfo.getString("title");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                i++;
            }
            if (author.length != 0 && title.length != 0) {
                recyclerView.setAdapter(new WorldListAdapter(title, author));
            }
        } catch (Exception e) {
            e.printStackTrace();
//            mTitleBook.setText("No results");
//            mAuthorBook.setText(" ");
        }
    }
}
