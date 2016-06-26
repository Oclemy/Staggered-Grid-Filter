package com.tutorials.hp.staggeredgirdfilter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Oclemmy on 3/25/2016 for ProgrammingWizards Channel.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> implements Filterable {

    Context c;
    ArrayList<Movie> movies;
    ArrayList<Movie> filterList;
    CustomFilter filter;


    public MyAdapter(Context c, ArrayList<Movie> movies) {
        this.c = c;
        this.movies = movies;
        this.filterList=movies;
    }

    //IITIALIZE OUR VH
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,null);
        MyHolder holder=new MyHolder(v);
        return holder;
    }

    //BIND VIEWS TO DATA
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.nametxt.setText(movies.get(position).getName());
        holder.img.setImageResource(movies.get(position).getImg());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Toast.makeText(c,movies.get(pos).getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    //TOTAL
    @Override
    public int getItemCount() {
        return movies.size();
    }

    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter(this,filterList);
        }
        return filter;
    }
}
