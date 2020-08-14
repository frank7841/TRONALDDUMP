package com.moringaschool.tronalddump.ul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.moringaschool.tronalddump.R;
import com.moringaschool.tronalddump.adapters.ListViewAdapter;
import com.moringaschool.tronalddump.models.Embedded;
import com.moringaschool.tronalddump.models.TronaldDump;
import com.moringaschool.tronalddump.network.TronalDump;
import com.moringaschool.tronalddump.network.TronalDumpClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayActivity extends AppCompatActivity {

    private Retrofit retrofit;//
//    private Button refresh;
//    private String source;
//    private TextView notification;
//    private TextView quoteBox;
//    private int index=0;
//
//    public Embedded quotes;
//    private ListViewAdapter mAdapter;
//    ///retrofit binder

//    private OkHttpClient okHttpClient;
//    private final Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("https://api.tronalddump.io/")//API baseUrl
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();
//    private final TronalDump service = retrofit.create(TronalDump.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        refresh = findViewById(R.id.button_activity_refresh);//find button activity refresh
        quoteBox = findViewById(R.id.textView_activity_quoteView);
        notification = findViewById(R.id.textView_activity_notification);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.tronalddump.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final TronalDump service =
                retrofit.create(TronalDump.class);
        Call<TronaldDump> call = service.searchQuote(source);;
        TronalDump client = TronalDumpClient.getClient();
        Intent intent = getIntent();
        source = intent.getStringExtra("source");

        call.enqueue(new Callback<TronaldDump>() {
            @Override
            public void onResponse(Call<TronaldDump> call, Response<TronaldDump> response) {
                if (response.isSuccessful()) {

                    quotes = response.body().getEmbedded();
                    mAdapter = new ListViewAdapter(DisplayActivity.this, (List<String>) quotes);
                }

            }

            @Override
            public void onFailure(Call<TronaldDump> call, Throwable t) {

            }
        });
    }


}