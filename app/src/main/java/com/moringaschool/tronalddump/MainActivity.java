package com.moringaschool.tronalddump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.obama) Button mObama;
    @BindView(R.id.bush) Button mBush;
    @BindView(R.id.graham) Button mgraham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mObama.setOnClickListener(this);
//        mBush.setOnClickListener(this);
//        mgraham.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if (v== mObama){
            Intent intent = new Intent(MainActivity.this,ObamaActivity.class);
            startActivity(intent);
        }

    }
}