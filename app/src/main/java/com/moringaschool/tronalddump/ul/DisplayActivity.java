package com.moringaschool.tronalddump.ul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.moringaschool.tronalddump.R;
import com.moringaschool.tronalddump.TronaldDump;
import com.moringaschool.tronalddump.network.TronalDump;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayActivity extends AppCompatActivity {
    private Button refresh;
    private String source;
    private TextView notification;
    private TextView quoteBox;
    private int index=0;
    ///retrofit binder

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.tronalddump.io/")//API baseUrl
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private final TronalDump service = retrofit.create(TronalDump.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        source=getIntent().getStringExtra("source");
        generateQuote(source);

        refresh = findViewById(R.id.button_activity_refresh);//find button activity refresh
        quoteBox = findViewById(R.id.textView_activity_quoteView);
        notification = findViewById(R.id.textView_activity_notification);

    }
    public void generateQuote(String source) {
        Call<TronaldDump> call = service.searchQuote(source);
        call.enqueue(new Callback<TronaldDump>() {
            @Override
            public void onResponse(Call<TronaldDump> call, Response<TronaldDump> response) {
                if (index >= response.body().getEmbedded().getTag().size()) {
                    index = 0;
                    notification.setText("All Available Quotes Have Been Displayed");
                }
                quoteBox.setText(response.body().getEmbedded().getTag().get(index).getValue());
            }

            @Override
            public void onFailure(Call<TronaldDump> call, Throwable t) {

            }
        });
    }
        public void refreshQuote(View view) {
            index++;
            notification.setText("");
            generateQuote(source);
    }
}