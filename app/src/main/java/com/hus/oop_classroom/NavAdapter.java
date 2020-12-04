package com.hus.oop_classroom;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NavAdapter extends BaseAdapter {
    ArrayList<Select> list;

    public NavAdapter(ArrayList<Select> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView==null){
            view=View.inflate(parent.getContext(),R.layout.select , null);

        }else {
            view = convertView;
        }
        View  icon = view.findViewById(R.id.icon);
        TextView content = view.findViewById(R.id.content);
        icon.setBackgroundResource(list.get(position).getId());
        content.setText(list.get(position).getContent());
        return view;
    }
}
