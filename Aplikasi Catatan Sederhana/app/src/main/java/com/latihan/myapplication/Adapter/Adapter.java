package com.latihan.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.latihan.myapplication.Model.Data;
import com.latihan.myapplication.R;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> items;

    public Adapter(Activity activity,List<Data> items){
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null && inflater != null){
            convertView = inflater.inflate(R.layout.list_users,null);
        }

        if (convertView != null) {

            TextView name = convertView.findViewById(R.id.text_name);
            TextView email = convertView.findViewById(R.id.text_email);

            Data data = items.get(position);
            name.setText(data.getName());
            email.setText(data.getEmail());
        }
        return convertView;
    }
}
