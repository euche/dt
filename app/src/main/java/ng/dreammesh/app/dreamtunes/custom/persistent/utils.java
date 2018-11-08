package ng.dreammesh.app.dreamtunes.custom.persistent;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class utils {





    public String getPreftoken( Context c,String key){

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(c);

        return sp.getString(key,"NULL");




    }






    public  void storedata(Context context,String token){

       SharedPreferences sd = PreferenceManager.getDefaultSharedPreferences(context);
       SharedPreferences.Editor editor = sd.edit();
       editor.putString("TOKEN",token);
       editor.apply();



    }





}