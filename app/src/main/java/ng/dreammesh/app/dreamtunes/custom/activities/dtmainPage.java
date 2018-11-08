package ng.dreammesh.app.dreamtunes.custom.activities;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import ng.dreammesh.app.dreamtunes.R;
import ng.dreammesh.app.dreamtunes.custom.fragments.homeFragment;
import ng.dreammesh.app.dreamtunes.custom.fragments.playlistFragment;
import ng.dreammesh.app.dreamtunes.custom.fragments.profileFragment;
import ng.dreammesh.app.dreamtunes.custom.fragments.searchFragment;

import android.support.v4.app.Fragment;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;


public class dtmainPage extends AppCompatActivity {




    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int [] tabIcons = {R.drawable.baseline_home_black_18dp,R.drawable.baseline_search_black_18dp,R.drawable.baseline_music_note_black_18dp,R.drawable.baseline_person_black_18dp};

    private int current_page;//for current icon


    private BottomSheetBehavior BS;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtmain_page);


        viewPager = (ViewPager)findViewById(R.id.viewpager);
        setupViewpager(viewPager);

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        setupTabicons();



        //        for swiping tabs
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

//        for tabs click and change
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));




        //for changing icons
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                current_page = position;
                setupTabicons();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


       tabLayout.getTabAt(0).setIcon(R.drawable.home_blue);


       //CODE FOR BOTTOMSHEET
        View bs1 = findViewById(R.id.bottom_sheet1);

        BS = BottomSheetBehavior.from(bs1);

        final FrameLayout mplayerCollapsed  = (FrameLayout)  findViewById(R.id.player_col);

        final FrameLayout mplayerExpanded = (FrameLayout) findViewById(R.id.player_exp);

        BS.setState(BottomSheetBehavior.STATE_HIDDEN);



        //callback for bottom sheet states e.g .STATE_COLLAPSED to be seen
        BS.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                switch(newState){

                    //shows action for this state
                    case BottomSheetBehavior.STATE_EXPANDED:{

                        //framelayout mplayercollasped disappears
                        mplayerCollapsed.setVisibility(View.GONE);

                        //framelayout mplayerexpanded is visble
                        mplayerExpanded.setVisibility(View.VISIBLE);

                    }
                    break;

                    case BottomSheetBehavior.STATE_COLLAPSED:{

                        mplayerCollapsed.setVisibility(View.VISIBLE);
                        mplayerExpanded.setVisibility(View.GONE);

                    }
                    break;


                }



            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });




    }






    private void setupTabicons() {

//        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
//        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
//        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
//        tabLayout.getTabAt(3).setIcon(tabIcons[3]);


        for(int i = 0; i < 4;i++){

            tabLayout.getTabAt(i).setIcon(getResource(i));


        }

        tabLayout.getTabAt(current_page).setIcon(getSelectedIcons(current_page));

    }


    // for black icons
    private int getResource(int no){
        switch(no){

            case 0:
                return R.drawable.home;


            case 1:
                return R.drawable.search;


            case 2:
                return R.drawable.collection;


            case 3:
                return  R.drawable.profile;

            default:
                return 10;

        }

    }


    private int getSelectedIcons(int no){

        switch(no){

            case 0:
                return R.drawable.home_blue;

            case 1:

                return R.drawable.search_blue;

            case 2:

                 return R.drawable.collection_name;

            case 3:

                return R.drawable.profile_blue;

                default:
                    return 10;


        }



    }





    private void setupViewpager(ViewPager viewPager) {

        // we are going to create an VIEWPAGER ADAPTER CLASS below

        ViewPagerAdapter dta = new ViewPagerAdapter(getSupportFragmentManager());
        dta.addFragment(new homeFragment(),"ONE");
        dta.addFragment(new searchFragment(),"TWO");
        dta.addFragment(new playlistFragment(),"THREE");
        dta.addFragment(new profileFragment(),"FOUR");

        viewPager.setAdapter(dta);



    }




    public class ViewPagerAdapter extends FragmentPagerAdapter{

       private final List<Fragment> dFragmentList =  new ArrayList<>();
       private final List<String> dFragmentTitleList = new ArrayList<>();





        public ViewPagerAdapter(FragmentManager fm) { //constructor
            super(fm);
        }

        @Override
        public int getCount() {
            return dFragmentList.size();
        }

        @Override
        public Fragment getItem(int position) {

            return dFragmentList.get(position);

        }



        @Override
        public CharSequence getPageTitle(int position) {
           // return super.getPageTitle(position);

           // return dFragmentTitleList.get(position);

            return null; //to display only ICON


        }

        public void addFragment(Fragment fragment, String title){

            dFragmentList.add(fragment);
            dFragmentTitleList.add(title);



        }



    }


// for the playlist activity
    public void clickCardExpanded(){


        BS.getPeekHeight();
        BS.setState(BottomSheetBehavior.STATE_EXPANDED);

    }











}
