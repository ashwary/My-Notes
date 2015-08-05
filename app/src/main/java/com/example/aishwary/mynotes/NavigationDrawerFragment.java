package com.example.aishwary.mynotes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class NavigationDrawerFragment extends Fragment {

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;

    public NavigationDrawerFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer = Boolean.valueOf(AppSharedPreferences.hasUserLearned(getActivity(),
                AppConstant.KEY_USER_LEARNED_DRAWER, AppConstant.FALSE));
        if (savedInstanceState != null) {
            mFromSavedInstanceState = true;

        }

    }

    @Nullable //Denotes that a parameter, field or method return value can be null.
    //When decorating a method call parameter, this denotes that the parameter can legitimately be null
    // and the method will gracefully deal with it. Typically used on optional parameters.
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(R.layout.fragment_navigation_drawer, container, false);
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        View containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout,
                toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override

            public void onDrawerSlide(View drawerView, float slideOffset) {
               if (slideOffset < 0.6){
                   toolbar.setAlpha(1 - slideOffset / 2);
               }
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                if (!mUserLearnedDrawer){
                    mUserLearnedDrawer = true;
                    AppSharedPreferences.setUserLearned(getActivity(),
                            AppConstant.KEY_USER_LEARNED_DRAWER, AppConstant.TRUE);
                }
            }

            @Override

            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

        };
    }


}















