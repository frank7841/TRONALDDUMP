package com.moringaschool.tronalddump;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LindseyGrahamActivity extends AppCompatActivity {
    @BindView(R.id.linseyGraham) TextView mLinseyGraham;
    @BindView(R.id.listView)ListView mListView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lindseygraham);
        ButterKnife.bind(this);

    }
}
