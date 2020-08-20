package com.moringaschool.tronalddump.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.tronalddump.R;
import com.moringaschool.tronalddump.models.Jokes;

import java.util.List;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.recyclerHolder> {
    //varriables Declaration;
    private Context mContext;
    private List<Jokes>jokesArrayList;

    public recyclerViewAdapter(Context mContext, List<Jokes> jokesArrayList) {
        this.mContext = mContext;
        this.jokesArrayList = jokesArrayList;
    }


    @NonNull
    @Override
    public recyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jokes_row,parent,false);
        recyclerHolder recyclerHolder = new recyclerHolder(view);
        return recyclerHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerHolder holder, int position) {
        Jokes alljokes = jokesArrayList.get(position);
        holder.body.setText(alljokes.getJoke());
        holder.category.setText(alljokes.getCategory());
        holder.id.setText(String.valueOf(alljokes.getId()));
    }

    @Override
    public long getItemId(int position){return position;}

    @Override
    public int getItemCount() {
        return jokesArrayList.size();
    }
    public static class recyclerHolder extends RecyclerView.ViewHolder {
        private TextView body,category, id;
        public recyclerHolder(@NonNull View itemView) {
            super(itemView);
            body = itemView.findViewById(R.id.jokes_body);
            category = itemView.findViewById(R.id.category_joke);
            id = itemView.findViewById(R.id.joke_number);
        }
    }
}
