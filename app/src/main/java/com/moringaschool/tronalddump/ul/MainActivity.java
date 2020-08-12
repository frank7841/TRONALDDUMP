package com.moringaschool.tronalddump.ul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.moringaschool.tronalddump.JebBushActivity;
import com.moringaschool.tronalddump.LindseyGrahamActivity;
import com.moringaschool.tronalddump.ObamaActivity;
import com.moringaschool.tronalddump.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] nameList;
    ArrayList<String> arraylist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Generating Sample Data
        nameList = new String[]{"Hillary Clinton", "Ted Cruz", "Jeb Bush",
                "Marco Rubio", "President Obama", "Elizabeth Warren", "John Kasich", "Bernie Sanders",
                "Bill Clinton", "Lindsey Graham", "Ben Carson", "Carly Fiorina", "John McCain", "Rick Perry",
                "George Pataki", "Scott Walker", "Tim Kaine", "Rand Paul", "Donald Trump", "George W. Bush",
                "Megyn Kelly", "Women", "Bobby Jindal", "Martin O'Malley", "Tom Ridge", "Michael Nutter",
                "Barack Obama", "Mexico", "Immigrants", "Cory Booker", "Sam Liccardo", "Lincoln Chafee", "Apologies",
                "Muslims", "Bakari Sellers", "Illegal Immigrants", "Chris Christie", "Arianna Huffington",
                "Neil Young", "History", "Sexual Assults", "Military", "Marty Walsh", "Ben Cardin", "Stephanie Rawlings-Blake",
                "Mitt Romney", "Ivanka Trump", "Ruth Bader Ginsburg", "Joseph R. Biden Jr.",
                "Muammar Gaddafi", "Money", "Bette Midler"};

        //locating List view in activity_main.xml
        list =(ListView) findViewById(R.id.listView);
        for (int i=0;i< nameList.length;i++){
            String names = nameList[i];
            arraylist.add(names);
        }
        //Passing the results to ListView Class
        adapter = new ListViewAdapter(this, arraylist);
        list.setAdapter(adapter);

        //locate search view in activity_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("source", adapter.getItem(position));
                startActivity(intent);
            }
        });

        mObamaButton.setOnClickListener(this);
        mBushButton.setOnClickListener(this);
        mGrahamButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if (v== mObamaButton) {
            Toast.makeText(MainActivity.this, "Hey Frank Lets do this", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ObamaActivity.class);
            startActivity(intent);
        }
        else if (v== mBushButton){
            Intent bushIntent = new Intent(MainActivity.this, JebBushActivity.class);
            startActivity(bushIntent);
        }
        else if(v==mGrahamButton){
            Intent grahamIntent = new Intent(MainActivity.this, LindseyGrahamActivity.class);
            startActivity(grahamIntent);
        }

    }
}