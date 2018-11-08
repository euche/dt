package ng.dreammesh.app.dreamtunes.custom.service;


import ng.dreammesh.app.dreamtunes.custom.models.User;
import ng.dreammesh.app.dreamtunes.custom.models.UserResponse;
import ng.dreammesh.app.dreamtunes.custom.models.loginUser;
import ng.dreammesh.app.dreamtunes.custom.models.profileResposnse;
import ng.dreammesh.app.dreamtunes.custom.models.userToken;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;



public interface dreamtunesAPI {



    @POST("createuser")
    Call<UserResponse>registerUser(@Body User user);


    @POST("me")
    Call<userToken>authenticateUser(@Body loginUser user);

    @GET("me")
    Call<profileResposnse>viewProfile(@Header("Authorization")  String token);









}
