package com.cheng.notes.Activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.cheng.notes.Adapter.MyFragmentAdapter;
import com.cheng.notes.Fragment.OneFragment;
import com.cheng.notes.R;
import com.cheng.notes.View.MyviewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 2016/12/20.
 */

public class LauncherActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    //记录当前按下时间
    private long mPressTime;
    private TabLayout tabLayout;
    private MyviewPager viewPager;
    private List<String> mDatas;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        initView();
        initData();

    }



    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //getSupportFragmentManager().beginTransaction().add(R.id.content_main, new ContentFragment()).commit();
        tabLayout= (TabLayout) findViewById(R.id.tab);
        viewPager= (MyviewPager) findViewById(R.id.vp);

    }

    private void initData() {
        mDatas=new ArrayList<>();
        fragments=new ArrayList<>();
        for (int i=0;i<4;i++)
        {
            mDatas.add("item"+i);
            fragments.add(new OneFragment());
        }
        Log.e("cheng","mdata="+mDatas+"fragments="+fragments);
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(),fragments,mDatas));
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            long nowTime = System.currentTimeMillis();
            if (nowTime - mPressTime > 2000) {
                Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
                mPressTime = nowTime;
            } else {
                this.finish();
                System.exit(0);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }


        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
