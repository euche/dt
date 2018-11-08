package ng.dreammesh.app.dreamtunes.custom.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ng.dreammesh.app.dreamtunes.R;
import ng.dreammesh.app.dreamtunes.custom.adapter.albumcoverAdapter;
import ng.dreammesh.app.dreamtunes.custom.models.albumCover;
import ng.dreammesh.app.dreamtunes.custom.activities.charts;

/**
 * A simple {@link Fragment} subclass.
 */
public class homeFragment extends Fragment {



    private List<albumCover> aco1  = new ArrayList<>(); //recently played

    private List<albumCover>acrp = new ArrayList<>(); //new releases

    private List<albumCover> acalbums = new ArrayList<>();

    private RecyclerView hfr1, hfra,hfa;


    TextView charts,albums1;


    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);

       View hf1 = inflater.inflate(R.layout.fragment_home, container, false);


        albumCover [] ac={ new albumCover("Power Trip",R.drawable.art1,"J Cole")
                ,new albumCover("New York Times", R.drawable.art2,"J Cole"),
                new albumCover("Magic",R.drawable.ghoststories,"Coldplay")
                ,new albumCover("1985",R.drawable.kod,"Jcole"),
                new albumCover("The Fever",R.drawable.churchclothes,"Lecrae") };


            for(albumCover temp : ac){            //insert albumCover into the arraylist declared above.

            aco1.add(temp);


            }

            for(albumCover temp1:ac){

                acrp.add(temp1);
            }


            for (albumCover temp2: ac){

                acalbums.add(temp2);
            }







       //Recently played
       hfr1 = (RecyclerView) hf1.findViewById(R.id.acSlider);
        LinearLayoutManager HF = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);    //specifying the layout manager to use

        hfr1.setLayoutManager(HF);

        hfr1.setHasFixedSize(true);



        albumcoverAdapter adapter = new albumcoverAdapter(aco1,getContext());
        hfr1.setAdapter(adapter);




        //New releases
        hfra =(RecyclerView) hf1.findViewById(R.id.recent_added);
        LinearLayoutManager RA = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        hfra.setLayoutManager(RA);
        hfra.setHasFixedSize(true);


        albumcoverAdapter adapter1 = new albumcoverAdapter(acrp,getContext());
        hfra.setAdapter(adapter1);





        //albums

        hfa = (RecyclerView) hf1.findViewById(R.id.albums);
        LinearLayoutManager HA = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        hfa.setLayoutManager(HA);
        hfa.setHasFixedSize(true);

        albumcoverAdapter adapter2 = new albumcoverAdapter(acalbums,getContext());
        hfa.setAdapter(adapter2);








        charts = (TextView) hf1.findViewById(R.id.chartsid);
        albums1 = (TextView) hf1.findViewById(R.id.albumsid);



        charts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getContext(), charts.class);
                getActivity().startActivity(i);


            }
        });


        albums1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getContext(), charts.class);
                getActivity().startActivity(i);

            }
        });




        return hf1;   //return inflated home fragment

    }


    @Override
    public void onCreate( Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);





    }




    public void chartsup (View v) {







    }




}
