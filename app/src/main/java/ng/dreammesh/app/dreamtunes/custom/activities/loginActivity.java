package ng.dreammesh.app.dreamtunes.custom.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import ng.dreammesh.app.dreamtunes.R;
import ng.dreammesh.app.dreamtunes.custom.models.loginUser;
import ng.dreammesh.app.dreamtunes.custom.models.userToken;
import ng.dreammesh.app.dreamtunes.custom.persistent.utils;
import ng.dreammesh.app.dreamtunes.custom.service.dreamtunesAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class loginActivity extends AppCompatActivity {

    TextView signup;

    private AutoCompleteTextView userEmail;
    private EditText userPassword;

    private String token;



    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

     signup = findViewById(R.id.signupPress);



       userEmail  =  findViewById(R.id.emailInput);
       userPassword =  findViewById(R.id.passwordInput);


        Button userLogin = findViewById(R.id.loginButton);


        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                loginUser username = new loginUser( userEmail.getText().toString(),userPassword.getText().toString());


                sendloginUserdetails(username);

            }
        });




    }



    private void sendloginUserdetails(loginUser user){

       if(!validateLoginform()){

           return;

       }


       dialog = new ProgressDialog(loginActivity.this);
        dialog.setMessage("Please Wait... ");
        dialog.show();


        Retrofit.Builder l = new Retrofit.Builder().baseUrl("http://192.168.10.132:8000/api/").addConverterFactory(GsonConverterFactory.create());

        Retrofit r = l.build();

        dreamtunesAPI userLoginclient =  r.create(dreamtunesAPI.class);


        Call<userToken> logincall = userLoginclient.authenticateUser(user);


       logincall.enqueue(new Callback<userToken>() {
           @Override
           public void onResponse(Call<userToken> call, Response<userToken> response) {

               dialog.dismiss();




 //              Toast.makeText(loginActivity.this, "Show status "+response.body().getStatus(),Toast.LENGTH_LONG).show();

               if(response.body().getStatus().toString() .equals("success") ){


//                   Toast.makeText(loginActivity.this,"Show Token: "+response.body().getData().getToken(),Toast.LENGTH_LONG).show();

                   Log.e("Results","success "+ response.body().getData().getToken());



                   utils storeToken = new utils();

                   token = response.body().getData().getToken();

                   Log.e("TOKEN","STORED TOKEN"+token);

                   storeToken.storedata(getApplicationContext(),token);

              Log.e("SHOW TOKEN"," SHOW TOKEN"+storeToken.getPreftoken(getApplicationContext(),"TOKEN"));









                   movetoMainmusicactivity();




               }else{


                   Log.e("Response","Invalid username or Password");

                 //  Toast.makeText(loginActivity.this,"Invalid username or Password",Toast.LENGTH_LONG);

                   showAlertDialogButtonClicked();


               }



//               Toast.makeText(loginActivity.this,"Show Token: "+response.body().getData().getToken(),Toast.LENGTH_LONG).show();
//
//               Log.e("Results","success "+ response.body().getData().getToken());
//
//
//
//              utils storeToken = new utils();
//
//              token = response.body().getData().getToken();
//
//               Log.e("TOKEN","STORED TOKEN"+token);
//
//              storeToken.storedata(getApplicationContext(),token);
//
////              Log.e("SHOW TOKEN"," SHOW TOKEN"+storeToken.getPreftoken(getApplicationContext(),"TOKEN"));
//
//
//
//
//
//
//
//
//
//               movetoMainmusicactivity();

           }

           @Override
           public void onFailure(Call<userToken> call, Throwable t) {

               dialog.dismiss();

               Toast.makeText(loginActivity.this,"Check your Network Connection",Toast.LENGTH_SHORT).show();

           }
       });




    }





    public void setSignup(View signup) {


        Intent i = new Intent(loginActivity.this,registerActivity.class);
        startActivity(i);




    }


    public void showAlertDialogButtonClicked() {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Login");
        builder.setMessage("Invalid Username or Password");

        // add a button
        builder.setPositiveButton("OK", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }




    private void movetoMainmusicactivity(){

        Intent intent = new Intent(loginActivity.this,dtmainPage.class);
        startActivity(intent);

    }


    private boolean validateLoginform(){

        boolean valid = true;


        String email = userEmail.getText().toString();

        if(TextUtils.isEmpty(email)){

            userEmail.setError("Required");
            valid = false;

        }else{

            userEmail.setError(null);

        }



        String password = userPassword.getText().toString();
        if(TextUtils.isEmpty(password)){

            userPassword.setError("Required");
            valid = false;

        }else{

            userPassword.setError(null);

        }





       return  valid;
    }






}
