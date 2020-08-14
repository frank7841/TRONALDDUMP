package com.moringaschool.tronalddump.ul;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.tronalddump.R;
import com.moringaschool.tronalddump.network.TronalDump;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayActivity extends AppCompatActivity {

    private Retrofit retrofit;//
    private TronalDump tronalDump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        retrofit= new Retrofit.Builder()
                .baseUrl("https://sv443.net/jokeapi/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        tronalDump=retrofit.create(TronalDump.class);
    }

}


