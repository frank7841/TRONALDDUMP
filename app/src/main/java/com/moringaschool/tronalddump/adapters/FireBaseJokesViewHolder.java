package com.moringaschool.tronalddump.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.tronalddump.Constants;
import com.moringaschool.tronalddump.R;
import com.moringaschool.tronalddump.models.Jokes;
import com.moringaschool.tronalddump.ul.DisplayActivity;

import java.util.ArrayList;

public class FireBaseJokesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    View mView;
    Context mContext;
    public FireBaseJokesViewHolder(View itemView) {
        super(itemView);
        mView=itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }
    public void bindJoke(Jokes joke){
        TextView mbody = (TextView) mView.findViewById(R.id.jokes_body);
        TextView mcategory = (TextView) mView.findViewById(R.id.category_joke);
        TextView mId = (TextView) mView.findViewById(R.id.joke_number);

        mbody.setText(joke.getJoke());
        mcategory.setText(joke.getCategory());
        mId.setText(joke.getId());
    }

    @Override
    public void onClick(View view) {
        final ArrayList<Jokes>jokesArrayList= new ArrayList<>();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_SAVED_JOKE);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot :dataSnapshot.getChildren()){
                    jokesArrayList.add(snapshot.getValue(Jokes.class));
                }
                    int itemPosition= getLayoutPosition();
                Intent intent = new Intent(mContext, DisplayActivity.class);
                intent.putExtra("position", itemPosition + "");
//                intent.putExtra("jokes", Parcels.wrap(restaurants));
                mContext.startActivity(intent);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
