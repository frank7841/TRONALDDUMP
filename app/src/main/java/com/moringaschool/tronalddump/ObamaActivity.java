package com.moringaschool.tronalddump;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ObamaActivity extends AppCompatActivity {
    @BindView(R.id.activityname) TextView mActivityName;
    @BindView(R.id.listView) ListView mListView;
    public static final String TAG = ObamaActivity.class.getSimpleName();
    private String[] ObamaQuotes = new String[]{"Our great African American President hasn't exactly had a positive impact on the thugs who are so happily and openly destroying Baltimore! - 28 April 2015",
            "An 'extremely credible source' has called my office and told me that Barack Obama's birth certificate is a fraud. - 6 August 2012"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obama);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ObamaQuotes);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        Intent intent = getIntent();
        String barack = intent.getStringExtra("President Barack Obama");
        Toast.makeText(this, barack, Toast.LENGTH_LONG).show();

    }
}
