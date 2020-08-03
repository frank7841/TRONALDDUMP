package com.moringaschool.tronalddump;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ObamaActivity extends AppCompatActivity {
    @BindView(R.id.activityname)
    TextView mActivityName;
    @BindView(R.id.listView)
    ListView mListView;
    public static final String TAG = ObamaActivity.class.getSimpleName();
    private String[] ObamaQuotes = new String[]{"Our great African ", "American President hasn't ", "exactly had a positive impact on the thugs who", " are so happily and openly destroying Baltimore!", " - 28 April 2015"


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obama);
        ButterKnife.bind(this);
        ObamaQuotesArrayAdapter adapter = new ObamaQuotesArrayAdapter(this, android.R.layout.simple_list_item_2, ObamaQuotes);
        mListView.setAdapter(adapter);

        Intent intent = getIntent();
        String barack = intent.getStringExtra("President Barack Obama");
        Toast.makeText(this, barack, Toast.LENGTH_LONG).show();

    }
}
