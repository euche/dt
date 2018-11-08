package ng.dreammesh.app.dreamtunes.custom.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ng.dreammesh.app.dreamtunes.R;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        delayScreen();

        //to remove toolbar for splash screen.

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });





    }

    public void delayScreen (){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeActivity = new Intent (welcome.this , loginActivity.class);
                startActivity(homeActivity);
                finish();
            }
        }, 1000);
    }

}
