package com.moringaschool.tronalddump;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class ObamaQuotesArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mObama;

    public ObamaQuotesArrayAdapter( int resource, Context mContext, String[] mObama) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mObama = mObama;
    }
    @Override
    public  Object getItem(int position){
        String obamaQuote = mObama[position];
        return String.format("%s \nHe Said:%s", obamaQuote);
    }
    @Override
    public int getCount(){
        return mObama.length;
    }


}
