package ng.dreammesh.app.dreamtunes.custom.activities;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ng.dreammesh.app.dreamtunes.R;
import ng.dreammesh.app.dreamtunes.custom.models.User;
import ng.dreammesh.app.dreamtunes.custom.models.UserResponse;
import ng.dreammesh.app.dreamtunes.custom.service.dreamtunesAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class registerActivity extends AppCompatActivity {


    TextView login;

    private EditText  userName;

    private EditText userEmail;

    private EditText userPassword;

    private EditText userPassword1;

    private ProgressDialog dialog;


    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        login = (TextView)findViewById(R.id.loginText);

           userName =  findViewById(R.id.prefName);
          userEmail =  findViewById(R.id.prefEmail);
          userPassword =  findViewById(R.id.prefPassword);

          userPassword1 = findViewById(R.id.newpasswordInput);


        Button createUser =  findViewById(R.id.signupButton);

        createUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Create the USER Class object for the Method below.

                User username = new User(

                        userName.getText().toString(),

                        userEmail.getText().toString(),

                        userPassword.getText().toString()



                );



                sendregisterUserDetails(username);

            }
        });





    }




    private void sendregisterUserDetails(User user){


        if(!validateRegisterForm()){

            return;

        }


        //Validate email address
        if(!userEmail.getText().toString().matches(emailPattern)){

            userEmail.setError("Invalid email address");

            return;

        }




         //Validate Password mismatch
        if(!userPassword1.getText().toString().equals(userPassword.getText().toString())){



            userPassword.setError("Password mismatch");
            userPassword1.setError("password mismatch");



            return;
        }


         //Progress dialog
         dialog =  new ProgressDialog(registerActivity.this);
         dialog.setMessage("Please Wait, Its loading");
         dialog.show();


        //Create Retrofit instance
        Retrofit.Builder b = new Retrofit.Builder().baseUrl(" http://192.168.10.132:8000/api/ ").addConverterFactory(GsonConverterFactory.create());

        Retrofit r = b.build();

        dreamtunesAPI userClient = r.create(dreamtunesAPI.class);






        //pass USER object through the CALL object(Retrofit).

               Call<UserResponse> usercall = userClient.registerUser(user);

               //using asynchronous method to parse data

           usercall.enqueue(new Callback<UserResponse>() {
               @Override
               public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                  dialog.dismiss();

                   Toast.makeText(registerActivity.this,"Show id"+response.body().getData().getId(),Toast.LENGTH_LONG).show();

                   moveloginactivity();


                   Log.e("Results","suceess");

               }

               @Override
               public void onFailure(Call<UserResponse> call, Throwable t) {

                   dialog.dismiss();

                   Toast.makeText(registerActivity.this,"Network Parsing error",Toast.LENGTH_SHORT).show();

               }
           });

    }






    public void loginPage(View v){

        Intent i2 =  new Intent(registerActivity.this, loginActivity.class);
        startActivity(i2);


    }


    private  void moveloginactivity(){

        Intent i3 = new Intent(registerActivity.this,loginActivity.class);
        startActivity(i3);
    }





    private boolean validateRegisterForm(){

        boolean valid = true;

        String name = userName.getText().toString();

        if(TextUtils.isEmpty(name)){

            userName.setError("Required");
            valid = false;

        }else{

            userName.setError(null);

        }


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


        String password1 = userPassword1.getText().toString();

        if(TextUtils.isEmpty(password1)){

            userPassword1.setError("Required");
            valid = false;

        }else{

            userPassword1.setError(null);

        }






     return valid;


    }








}
