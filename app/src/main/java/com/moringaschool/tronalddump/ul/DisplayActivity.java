package com.moringaschool.tronalddump.ul;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.tronalddump.Constants;
import com.moringaschool.tronalddump.R;
import com.moringaschool.tronalddump.adapters.recyclerViewAdapter;
import com.moringaschool.tronalddump.models.Jokes;
import com.moringaschool.tronalddump.network.TronalDump;

import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringaschool.tronalddump.Constants.JOKE_BASE_URL;

public class DisplayActivity<Private> extends AppCompatActivity {

    private AlertDialog.Builder alertDialogBuilder;
    private ProgressDialog progressDialog;
    private Retrofit retrofit;//
    private TronalDump tronalDump;
    private DatabaseReference msearchedJokeRefference;
    private ValueEventListener mSearchedJokeEventListener;

    private SharedPreferences sharedPreferences;//Shared Prefference
    private  SharedPreferences.Editor mEditor;
    private String mRecentName;

    @BindView(R.id.joke_text) EditText jokeText;
    @BindView(R.id.get_joke_btn) Button jokebutton;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.im_feeling_lucky_btn) Button feelinglucky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        msearchedJokeRefference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_JOKE);//Pin points Node location
        mSearchedJokeEventListener = msearchedJokeRefference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot JokeNameSnapshot : dataSnapshot.getChildren()) {
                    String text = JokeNameSnapshot.getValue().toString();
                    Log.d("JokeName updated", "JokeName: " + text); //log

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);


        retrofit = new Retrofit.Builder()
                .baseUrl(JOKE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        tronalDump = retrofit.create(TronalDump.class);

        LinearLayoutManager linearlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearlayoutManager);
        recyclerView.setHasFixedSize(true);
        jokebutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String text = jokeText.getText().toString();
//                String name_of_joke = jokeText.getText().toString();
                progressDialog = new ProgressDialog(DisplayActivity.this);
                progressDialog.setMessage("Loading");
                progressDialog.setCancelable(false);
                progressDialog.show();
                saveJokeName(text);
                getJoke(text);
//                addToSharedPreferences(name_of_joke);


            }
        });
        feelinglucky.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(DisplayActivity.this);
                progressDialog.setMessage("Loading");
                progressDialog.setCancelable(false);
                progressDialog.show();
                feelingLucky();

            }
        });
//        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mRecentName =sharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY,null);
//        Log.d("Shared Joke name is ", mRecentName);
//        mEditor = sharedPreferences.edit();
    }
//        @Override
//        public boolean onCreateOptionsMenu(Menu menu){
//            MenuInflater inflater = getMenuInflater();
//            inflater.inflate(R.menu.menu_search, menu);
//            ButterKnife.bind(this);
//            MenuItem menuItem = menu.findItem(R.id.action_serach);
//            SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
//
//            //Search View Listeners
//            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
//
//                @Override
//                public boolean onQueryTextSubmit(String query) {
//
//                    getJoke(query);
//                    return false;
//                }
//
//                @Override
//                public boolean onQueryTextChange(String newText) {
//                    return false;
//                }
//            });
//
//            return true;
//
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        return super.onOptionsItemSelected(item);
//
//    }
//        private void addToSharedPreferences(String name_of_joke) {
//        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, name_of_joke).apply();
//    }


    private void getJoke(String text){
        tronalDump.getJoke(text).enqueue(new Callback<Jokes>() {
            @Override
            public void onResponse(Call<Jokes> call, Response<Jokes> response) {
                progressDialog.dismiss();
                int statusCode = response.code();
                Jokes joke = response.body();

                recyclerViewAdapter recyclerViewAdapter1 = new recyclerViewAdapter(getApplicationContext(), Collections.singletonList(joke));
                recyclerView.setAdapter(recyclerViewAdapter1);
            }

            @Override
            public void onFailure(Call<Jokes> call, Throwable t) {
                progressDialog.dismiss();
            }
        });

    }
    private void feelingLucky(){
        tronalDump.getRandomJoke().enqueue(new Callback<Jokes>() {
            @Override
            public void onResponse(Call<Jokes> call, Response<Jokes> response) {
                progressDialog.dismiss();
                final Jokes joke = response.body();

                String title = "Random Text";
                alertDialogBuilder = new AlertDialog.Builder(DisplayActivity.this);
                alertDialogBuilder.setTitle(title)
                        .setMessage(joke.getJoke())
                        .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                DatabaseReference jokeRef= FirebaseDatabase
                                        .getInstance()
                                        .getReference(Constants.FIREBASE_CHILD_SAVED_JOKE);
                                jokeRef.push().setValue(joke);

                            }
                        })
                        .setNegativeButton("Boring", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                alertDialogBuilder.show();

            }

            @Override
            public void onFailure(Call<Jokes> call, Throwable t) {
                progressDialog.dismiss();

            }
        });
    }
    public void saveJokeName(String text){
        msearchedJokeRefference.push().setValue(text);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        msearchedJokeRefference.removeEventListener(mSearchedJokeEventListener);
    }

}


