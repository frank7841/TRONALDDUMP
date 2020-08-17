package com.moringaschool.tronalddump.ul;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.moringaschool.tronalddump.R;
import com.moringaschool.tronalddump.adapters.recyclerViewAdapter;
import com.moringaschool.tronalddump.models.jokes;
import com.moringaschool.tronalddump.network.TronalDump;

import java.util.Collection;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringaschool.tronalddump.Constants.JOKE_BASE_URL;

public class DisplayActivity extends AppCompatActivity {
    private AlertDialog.Builder alertDialogBuilder;
    private ProgressDialog progressDialog;
    private Retrofit retrofit;//
    private TronalDump tronalDump;
        @BindView(R.id.joke_text) EditText jokeText;
    @BindView(R.id.get_joke_btn) Button jokebutton;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.im_feeling_lucky_btn) Button feelinglucky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
                ButterKnife.bind(this);

        retrofit= new Retrofit.Builder()
                .baseUrl(JOKE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        tronalDump=retrofit.create(TronalDump.class);

        LinearLayoutManager linearlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearlayoutManager);
        recyclerView.setHasFixedSize(true);
        jokebutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String text=jokeText.getText().toString();
                progressDialog = new ProgressDialog(DisplayActivity.this);
                progressDialog.setMessage("Loading");
                progressDialog.setCancelable(false);
                progressDialog.show();
                getJoke(text);
            }
        });
        feelinglucky.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(DisplayActivity.this);
                progressDialog.setMessage("Loading");
                progressDialog.setCancelable(false);
                progressDialog.show();
                feelingLucky();

            }
        });
    }
    private void getJoke(String text){
        tronalDump.getJoke(text).enqueue(new Callback<jokes>() {
            @Override
            public void onResponse(Call<jokes> call, Response<jokes> response) {
                progressDialog.dismiss();
                int statusCode = response.code();
                jokes joke = response.body();

                recyclerViewAdapter recyclerViewAdapter1 = new recyclerViewAdapter(getApplicationContext(), Collections.singletonList(joke));
                recyclerView.setAdapter(recyclerViewAdapter1);
            }

            @Override
            public void onFailure(Call<jokes> call, Throwable t) {
                progressDialog.dismiss();
            }
        });

    }
    private void feelingLucky(){
        tronalDump.getRandomJoke().enqueue(new Callback<jokes>() {
            @Override
            public void onResponse(Call<jokes> call, Response<jokes> response) {
                progressDialog.dismiss();
                jokes joke = response.body();

                String title = "Random Text";
                alertDialogBuilder = new AlertDialog.Builder(DisplayActivity.this);
                alertDialogBuilder.setTitle(title)
                        .setMessage(joke.getJoke())
                        .setPositiveButton("Boring", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("Ha! Ha", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                alertDialogBuilder.show();

            }

            @Override
            public void onFailure(Call<jokes> call, Throwable t) {
                progressDialog.dismiss();

            }
        });
    }
}


