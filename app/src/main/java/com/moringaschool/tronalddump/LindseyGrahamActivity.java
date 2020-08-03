package com.moringaschool.tronalddump;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LindseyGrahamActivity extends AppCompatActivity {
    @BindView(R.id.linseyGraham) TextView mLinseyGraham;
    @BindView(R.id.listView)ListView mListView;

    private String[] graham = new String[]{"Do good","Do More Good", "and aliitle more good"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lindseygraham);
        ButterKnife.bind(this);

        ObamaQuotesArrayAdapter adapter = new ObamaQuotesArrayAdapter(this, android.R.layout.simple_list_item_1, graham);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            }

        });
        Intent grahamIntent = getIntent();
        String grahamText= grahamIntent.getStringExtra("Lindsey Graham");
        Toast.makeText(LindseyGrahamActivity.this, grahamText, Toast.LENGTH_LONG).show();

    }
}
