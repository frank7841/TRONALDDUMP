package com.moringaschool.tronalddump;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JebBushActivity extends AppCompatActivity {
    @BindView(R.id.jebBushTextView)
    TextView mJebBushTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jebbush);
        ButterKnife.bind(this);
    }
    Intent bushIntent = getIntent();
    String jebBush =bushIntent.getStringExtra("He said");
}
