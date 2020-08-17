//package com.moringaschool.tronalddump;
//
//import android.content.Context;
//import android.widget.ArrayAdapter;
//
//import androidx.annotation.NonNull;
//
//public class ObamaQuotesArrayAdapter extends ArrayAdapter {
//    private Context mContext;
//    private String[] mObamaQuotes;
//
//    public ObamaQuotesArrayAdapter( Context mContext, int resource, String[] mObamaQuotes) {
//        super(mContext, resource);
//        this.mContext = mContext;
//        this.mObamaQuotes = mObamaQuotes;
//    }
//    @Override
//    public  Object getItem(int position){
//        String obamaQuote = mObamaQuotes[position];
//        return String.format("%s \nHe Said:%s", obamaQuote);
//    }
//    @Override
//    public int getCount(){
//        return mObamaQuotes.length;
//    }
//
//
//}
