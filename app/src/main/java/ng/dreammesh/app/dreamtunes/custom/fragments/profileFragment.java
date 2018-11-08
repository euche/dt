package ng.dreammesh.app.dreamtunes.custom.fragments;



import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ng.dreammesh.app.dreamtunes.R;
import ng.dreammesh.app.dreamtunes.custom.models.profileResposnse;
import ng.dreammesh.app.dreamtunes.custom.persistent.utils;
import ng.dreammesh.app.dreamtunes.custom.service.dreamtunesAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class profileFragment extends Fragment {



    ImageView ppic;

    private TextView profileName;

    private TextView profileEmail;


    



    private static String authtoken = "Bearer";

    public profileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_profile, container, false);


        View pf = inflater.inflate(R.layout.fragment_profile, container, false);


        ppic = (ImageView)pf.findViewById(R.id.proficPic);


        profileName = pf.findViewById(R.id.userProfilename) ;

        profileEmail = pf.findViewById(R.id.userProfileemail);

        
        Bitmap imageBitmap= BitmapFactory.decodeResource(getResources(),  R.drawable.kod); //R.drawable.id is an INTEGER

        RoundedBitmapDrawable roundedBitmapDrawable=
                RoundedBitmapDrawableFactory.create(getResources(), imageBitmap);

        roundedBitmapDrawable.setCircular(true);
//        roundedBitmapDrawable.setCornerRadius(500.0f);
        roundedBitmapDrawable.setAntiAlias(true);
        ppic.setImageDrawable(roundedBitmapDrawable);


        utils tokenizer = new utils();

         String token = tokenizer.getPreftoken(getActivity(),"TOKEN");

        Log.e("Fragment ", "SHOW THE TOKEN "+token);


          String finaltokenizer =    authtoken+" "+token;




        viewmyProfile( finaltokenizer );






        return pf;
    }







    private void viewmyProfile(String token){


        Retrofit.Builder vp = new Retrofit.Builder().baseUrl("http://192.168.10.132:8000/api/").addConverterFactory(GsonConverterFactory.create());

        Retrofit cpb = vp.build();

        dreamtunesAPI vmp =  cpb.create((dreamtunesAPI.class));

        Call<profileResposnse>  profileResponseCall =  vmp.viewProfile(token);


        profileResponseCall.enqueue(new Callback<profileResposnse>() {
            @Override
            public void onResponse(Call<profileResposnse> call, Response<profileResposnse> response) {

  //             

                if(response.body().getStatus().equals("success")){

                     Log.e("Results","success "+ response.body().getStatus());

                     profileName.setText(response.body().getData().getName());

                     profileEmail.setText(response.body().getData().getEmail());




                } else{

                          Log.e("Response","No response from the Server");

                }

                


            }

            @Override
            public void onFailure(Call<profileResposnse> call, Throwable t) {


                Log.e("FRAGMENT ","FAILURE")         ;

            }
        });


        













    }




}
