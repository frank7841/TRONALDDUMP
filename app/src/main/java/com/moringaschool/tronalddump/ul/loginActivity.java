package com.moringaschool.tronalddump.ul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.moringaschool.tronalddump.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class loginActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.registerTextView) TextView mregisterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mregisterTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==mregisterTextView){
            Intent intent = new Intent(loginActivity.this, CreateAccountActivity.class);
            startActivity(intent);
            finish();
        }

    }
}