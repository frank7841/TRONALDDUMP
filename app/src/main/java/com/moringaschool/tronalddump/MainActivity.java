package com.moringaschool.tronalddump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   @BindView(R.id.obamaButton) Button mObamaButton;
   @BindView(R.id.bushButton)Button mBushButton;
   @BindView(R.id.grahamButton)Button mGrahamButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mObamaButton.setOnClickListener(this);
        mBushButton.setOnClickListener(this);
        mGrahamButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if (v== mObamaButton) {
            Toast.makeText(MainActivity.this, "Hey Frank Lets do this", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ObamaActivity.class);
            startActivity(intent);
        }
        else if (v== mBushButton){
            Intent bushIntent = new Intent(MainActivity.this, JebBushActivity.class);
            startActivity(bushIntent);
        }

    }
}