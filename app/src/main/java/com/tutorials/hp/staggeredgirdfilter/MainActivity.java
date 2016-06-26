package com.tutorials.hp.staggeredgirdfilter;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView rv;
    MyAdapter adapter;
    SearchView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rv= (RecyclerView) findViewById(R.id.mRecycler);
        sv= (SearchView) findViewById(R.id.mSearch);

        adapter=new MyAdapter(this,getMovies());
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,1));
        rv.setAdapter(adapter);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });


    }

    private ArrayList<Movie> getMovies() {
        //COLECTION OF CRIME MOVIES
        ArrayList<Movie> movies=new ArrayList<>();


        Movie movie=new Movie("BlackList",R.drawable.red);

        //ADD ITR TO COLLECTION
        movies.add(movie);

        movie=new Movie("Ghost Rider",R.drawable.rider);
        movies.add(movie);


        movie=new Movie("Fruts",R.drawable.fruits);
        movies.add(movie);

        movie=new Movie("Breaking Bad",R.drawable.breaking);
        movies.add(movie);

        movie=new Movie("Crisis",R.drawable.crisis);
        movies.add(movie);


        movie=new Movie("Star Wars",R.drawable.starwars);
        movies.add(movie);

        movie=new Movie("Shuttle Carrier",R.drawable.shuttlecarrier);
        movies.add(movie);



        movie=new Movie("Men In Black",R.drawable.meninblack);
        movies.add(movie);

        movie=new Movie("Game Of Thrones",R.drawable.thrones);
        movies.add(movie);



        return movies;
    }


}
