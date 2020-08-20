package com.moringaschool.tronalddump.ul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.tronalddump.Constants;
import com.moringaschool.tronalddump.R;
import com.moringaschool.tronalddump.adapters.FireBaseJokesViewHolder;
import com.moringaschool.tronalddump.models.Jokes;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedJokesListActivity extends AppCompatActivity {
    private DatabaseReference mJokesRefference;
    private FirebaseRecyclerAdapter<Jokes, FireBaseJokesViewHolder> mFirebaseAdapter;
    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);


        mJokesRefference= FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_SAVED_JOKE);
        setUpFireBaseAdapter();
        showJokes();
    }

    private void setUpFireBaseAdapter() {
        FirebaseRecyclerOptions<Jokes> options = new FirebaseRecyclerOptions.Builder<Jokes>()
                .setQuery(mJokesRefference, Jokes.class)
                .build();
        mFirebaseAdapter= new FirebaseRecyclerAdapter<Jokes, FireBaseJokesViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FireBaseJokesViewHolder fireBaseJokesViewHolder, int i, @NonNull Jokes joke) {
                fireBaseJokesViewHolder.bindJoke(joke);
            }

            @NonNull
            @Override
            public FireBaseJokesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail,parent,false);
                return  new FireBaseJokesViewHolder(view);

            }
        };
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }
    @Override
    protected void onStart(){
        super.onStart();
        mFirebaseAdapter.startListening();
    }
    @Override
    protected void onStop(){
        super.onStop();
        if(mFirebaseAdapter !=null){
            mFirebaseAdapter.stopListening();
        }
    }
    private void showJokes(){
        mRecyclerView.setVisibility(View.VISIBLE);
    }

}