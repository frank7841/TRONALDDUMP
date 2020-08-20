package com.moringaschool.tronalddump.ul;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.tronalddump.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    @BindView(R.id.textView2) TextView mTexview2;
    @BindView(R.id.nextbutton) Button mButton;
    @BindView(R.id.savedButton) Button savedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        savedButton.setOnClickListener(this);
        mButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent memepage= new Intent(MainActivity.this,DisplayActivity.class);
        startActivity(memepage);
        if (view ==savedButton){
            Intent intent = new Intent(MainActivity.this, SavedJokesListActivity.class);
            startActivity(intent);
        }
    }
}