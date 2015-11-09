package com.example.raven.testbabiescharts;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<Baby> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        mAdapter = new ArrayAdapter<Baby>(MainActivity.this, android.R.layout.simple_list_item_1);
        listView.setAdapter(mAdapter);

        Button btn = (Button) findViewById(R.id.btn_babies);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new BabiesTask().execute(0,0);
            }
        });
    }

    public static final String BABIES_URL = "http://54.65.97.166:3000/babies";

    class BabiesTask extends AsyncTask<Integer, Integer, String>  {

        @Override
        protected String doInBackground(Integer... params) {
            int i = 0;
            int j = 0;
            String urlText = String.format(BABIES_URL);

            try {
                URL url = new URL(urlText);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                int code = conn.getResponseCode();
                if(code == HttpURLConnection.HTTP_OK)   {
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line=br.readLine()) != null)    {
                        sb.append(line).append("\n\r");
                    }
                    return sb.toString();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s != null)   {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(s);
                Gson gson = new Gson();
//                BabiesResult babiesResult = gson.fromJson(s, BabiesResult.class);
//                for(Baby baby : babiesResult.babies.babyList)  {
//                    mAdapter.add(baby);
//                }
            }else   {
                Toast.makeText(MainActivity.this, "Error...T.T", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
