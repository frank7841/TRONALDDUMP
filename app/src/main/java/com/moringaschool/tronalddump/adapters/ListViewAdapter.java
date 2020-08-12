package com.moringaschool.tronalddump.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.moringaschool.tronalddump.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    //Varriable Declration

    Context mContext;
    LayoutInflater inflater;
    private List<String> namesList = null;
    private ArrayList<String> arraylist;

    public ListViewAdapter(Context context, List<String> NamesList) {
        mContext = context;
        this.namesList = NamesList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(NamesList);
    }
    public class ViewHolder{
        TextView name;
    }
    @Override
    public int getCount(){
        return namesList.size();
    }
    @Override
    public String getItem(int position){return namesList.get(position);

    }
    @Override
    public long getItemId(int position){return position;}

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null){
            holder=new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);


        }
    }
}
