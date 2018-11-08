package ng.dreammesh.app.dreamtunes.custom.adapter;


import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView; // For RECYCLERVIEW CLASS
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;             //FOR TEXTVIEW
import android.widget.ImageView;            //FOR IMAGEVIEW
import android.view.ViewGroup;

//import android.support.v4.app.Fragment;
import android.app.Fragment;

import android.app.FragmentTransaction;
import android.widget.Toast;

import java.util.List;

import ng.dreammesh.app.dreamtunes.R;
import ng.dreammesh.app.dreamtunes.custom.activities.dtmainPage;
import ng.dreammesh.app.dreamtunes.custom.fragments.playerrsheet;
import ng.dreammesh.app.dreamtunes.custom.models.albumCover;


public class albumcoverAdapter extends RecyclerView.Adapter<albumcoverAdapter.acviewHolder> {

private List<albumCover> ac1;
private Context c;


    public albumcoverAdapter(List<albumCover> ac1, Context c) {

        this.ac1 = ac1;
        this.c = c;

    }








    public static class acviewHolder extends RecyclerView.ViewHolder{

        private ImageView aca;
        private TextView acs;
        private TextView acan;



    public acviewHolder(final View itemView) {
        super(itemView);



        aca = (ImageView)itemView.findViewById(R.id.acImage);
        acs =(TextView)itemView.findViewById(R.id.song_name);
        acan = (TextView)itemView.findViewById(R.id.artist_name);


        //click CardView

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                itemView.getContext().startActivity(new Intent(itemView.getContext(),songplay.class));

//                itemView.getContext();

//                dtmainPage activity = (dtmainPage) itemView.getContext();
//                bottomshhet myFragment = new bottomshhet();
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.bottom_sheet, myFragment).addToBackStack(null).commit();




                dtmainPage activity = (dtmainPage) itemView.getContext();
                activity.clickCardExpanded();



//                playerrsheet  p1 = new playerrsheet();


//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.sp, p1).addToBackStack(null).commit();

//                p1.playmusic();




            }
        });


    }


}





    @Override
    public acviewHolder onCreateViewHolder( ViewGroup parent, int viewType) {


        View vh = LayoutInflater.from(parent.getContext()).inflate(R.layout.accardview,parent,false);
        return new acviewHolder(vh);


      // return null;

    }


    @Override
    public void onBindViewHolder( acviewHolder holder, int position) {


        albumCover test = ac1.get(position);

        holder.aca.setImageResource(test.getImageResourceId());
        holder.acs.setText(test.getName());
        holder.acan.setText(test.getArtist());



    }


    @Override
    public int getItemCount() {
        return ac1.size();
    }
}
