package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class select_Activity extends AppCompatActivity {

    private ListView listView;
    private sojuListAdapter adapter;
    private List<soju> sojuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_);
        Intent intent = getIntent();

        listView = (ListView) findViewById(R.id.listView);
        sojuList = new ArrayList<soju>();
        adapter = new sojuListAdapter(getApplicationContext(), sojuList);
        listView.setAdapter(adapter);

        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("sojuList"));
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;
            String name, number, address;
            while(count < jsonArray.length()){
                JSONObject object = jsonArray.getJSONObject(count);
                name = object.getString("name");
                number = object.getString("number");
                address = object.getString("address");
                soju soju = new soju(name,number,address);
                sojuList.add(soju);
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
