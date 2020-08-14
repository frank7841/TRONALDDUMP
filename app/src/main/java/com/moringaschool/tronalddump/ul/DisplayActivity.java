package com.moringaschool.tronalddump.ul;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.tronalddump.R;
import com.moringaschool.tronalddump.network.TronalDump;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayActivity extends AppCompatActivity {

    private Retrofit retrofit;//
    private TronalDump tronalDump;
    @BindView(R.id.joke_text) EditText jokeText;
    @BindView(R.id.get_joke_btn) Button jokebutton;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
                ButterKnife.bind(this);

        retrofit= new Retrofit.Builder()
                .baseUrl("https://sv443.net/jokeapi/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        tronalDump=retrofit.create(TronalDump.class);

        jokeText
    }

}


