package com.moringaschool.tronalddump;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;

public class ObamaActivity extends AppCompatActivity {
    @BindView(R.id.listView) ListView mListView;
    public static final String TAG = ObamaActivity.class.getSimpleName();
    private  String[] obama = new String[]{"Our great African American President " +
            "hasn't exactly had a positive impact on the thugs who are so happily and" +
            " openly destroying Baltimore! - 28 April 2015"

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obama);


}
