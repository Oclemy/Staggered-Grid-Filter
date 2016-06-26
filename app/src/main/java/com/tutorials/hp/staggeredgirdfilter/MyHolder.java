package com.tutorials.hp.staggeredgirdfilter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Oclemmy on 3/25/2016 for ProgrammingWizards Channel.
 */
public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView img;
    TextView nametxt;
    ItemClickListener itemClickListener;

    public MyHolder(View itemView) {
        super(itemView);

        nametxt= (TextView) itemView.findViewById(R.id.nameTxt);
        img= (ImageView) itemView.findViewById(R.id.movieImage);

        itemView.setOnClickListener(this);

    }

    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
    }
}
