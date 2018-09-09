package com.example.administrator.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class sojuListAdapter extends BaseAdapter {

    private Context context;
    private List<soju> sojuList;

    public sojuListAdapter(Context context, List<soju> sojuList) {
        this.context = context;
        this.sojuList = sojuList;
    }

    @Override
    public int getCount() {
        return sojuList.size();
    }

    @Override
    public Object getItem(int i) {
        return sojuList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.soju_name, null);
        TextView name = (TextView)v.findViewById(R.id.name);
        TextView number = (TextView)v.findViewById(R.id.number);
        TextView address = (TextView)v.findViewById(R.id.address);

        name.setText(sojuList.get(i).getName());
        number.setText(sojuList.get(i).getNumber());
        address.setText(sojuList.get(i).getAddress());

        v.setTag(sojuList.get(i).getName());
        return v;
    }
}
