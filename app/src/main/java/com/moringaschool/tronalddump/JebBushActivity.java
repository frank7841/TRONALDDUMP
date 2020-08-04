package com.moringaschool.tronalddump;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JebBushActivity extends AppCompatActivity {
    @BindView(R.id.jebBushTextView) TextView mJebBushTextView;
    @BindView(R.id.jlistView) ListView mJListView;

    private String[] jebBush = new String[]{"I have an idea for Jeb Bush whose campaign is a disaster. Try using your last name & don’t be ashamed of it! - 18 December 2015",
            "Jeb failed as Jeb! He gave up and enlisted Mommy and his brother (who got us into the quicksand of Iraq). Spent $120 million.Weak-no chance! - 11 February 2016",
            "Jeb’s policies in Florida helped lead to its almost total collapse. Right after he left he went to work for Lehman Brothers—wow! - 8 September 2015",
            "Remember Jeb Bush wants COMMON CORE (education from D.C.) and is very weak on ILLEGAL IMMIGRATION (\"come as act of love\"). Not a leader! - 9 February 2016"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jebbush);
        ButterKnife.bind(this);

       ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, jebBush);
        mJListView.setAdapter(adapter);
        mJListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        Intent bushIntent = getIntent();
        String bush = bushIntent.getStringExtra("What He said About Jeb Bush:");
        Toast.makeText(JebBushActivity.this, bush, Toast.LENGTH_LONG).show();

    }
}
