package ng.dreammesh.app.dreamtunes.custom.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import ng.dreammesh.app.dreamtunes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class playerrsheet extends Fragment {


    private BottomSheetBehavior BS;



    public playerrsheet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_playerrsheet, container, false);

       View ps = inflater.inflate(R.layout.fragment_playerrsheet, container, false);

//Declare bottomsheet as a view
        View bs = ps.findViewById(R.id.bottom_sheet1);


        //Attach it to the view
        BS = BottomSheetBehavior.from(bs);


        final FrameLayout mplayerCollapsed  = (FrameLayout)  ps.findViewById(R.id.player_col);

        final FrameLayout mplayerExpanded = (FrameLayout) ps.findViewById(R.id.player_exp);



        BS.setState(BottomSheetBehavior.STATE_HIDDEN);









        return ps;

    }










    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }



    public void playmusic(){
        BS.setState(BottomSheetBehavior.STATE_EXPANDED);
    }


    public void collaspse(){

        BS.setState(BottomSheetBehavior.STATE_COLLAPSED);


    }




}
