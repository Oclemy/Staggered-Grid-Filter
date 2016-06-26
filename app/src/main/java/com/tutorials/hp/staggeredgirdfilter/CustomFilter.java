package com.tutorials.hp.staggeredgirdfilter;

import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;

/**
 * Created by Oclemmy on 3/25/2016 for ProgrammingWizards Channel.
 */
public class CustomFilter extends Filter
{
    MyAdapter adapter;
    ArrayList<Movie> filterList;

    public CustomFilter(MyAdapter adapter, ArrayList<Movie> filterList) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    //FILTER
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();

        //VALIDITY
        if(constraint != null && constraint.length()>0)
        {
            constraint=constraint.toString().toUpperCase();
            ArrayList<Movie> filteredMovies=new ArrayList<>();

            for (Movie m: filterList)
            {
                if(m.getName().toUpperCase().contains(constraint))
                {
                    filteredMovies.add(m);
                }
            }


            results.count=filteredMovies.size();
            results.values = filteredMovies;

            return  results;
        }

        results.count=filterList.size();
        results.values = filterList;

        return results;
    }

    //DISLAY
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.movies= (ArrayList<Movie>) results.values;
        adapter.notifyDataSetChanged();
    }
}
