package com.example.prasad.appnavi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {
    String web;
    private int cam=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ImageButton buttonCam = (ImageButton)findViewById(R.id.imageCam);
        ImageButton buttonEbay = (ImageButton)findViewById(R.id.imageEbay);
        ImageButton buttonAli = (ImageButton)findViewById(R.id.imageAli);
        ImageButton buttonGear = (ImageButton)findViewById(R.id.imageGear);
        ImageButton buttonAmazon = (ImageButton)findViewById(R.id.imageAmazon);
        ImageButton buttonDeal = (ImageButton)findViewById(R.id.imageDeal);
        ImageButton buttonWow =(ImageButton) findViewById(R.id.imageWow);
        ImageButton buttonLabai = (ImageButton)findViewById(R.id.imageLabai);
        ImageButton buttonDaraz = (ImageButton)findViewById(R.id.imageDaraz);
        ImageButton buttonMydeal = (ImageButton)findViewById(R.id.imageMydeal);

        buttonEbay.setOnClickListener(this);
        buttonAli.setOnClickListener(this);
        buttonGear.setOnClickListener(this);
        buttonAmazon.setOnClickListener(this);
        buttonDeal.setOnClickListener(this);
        buttonWow.setOnClickListener(this);
        buttonLabai.setOnClickListener(this);
        buttonDaraz.setOnClickListener(this);
        buttonMydeal.setOnClickListener(this);
        buttonCam.setOnClickListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.collapseActionView) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id==R.id.home){
            Intent intent2 = new Intent(MainActivity.this, MainActivity.class); //go to cam window
            startActivity(intent2);
        }else if (id == R.id.nav_share) {
            setTitle("Share");
            First first=new First();
            FragmentManager fragmentmanger=getSupportFragmentManager();
            fragmentmanger.beginTransaction().replace(R.id.fragment,first).commit();
         } else if (id == R.id.settings) {
             second Sc=new second();
             setTitle("Settings");
             FragmentManager fragmentmanger=getSupportFragmentManager();
             fragmentmanger.beginTransaction().replace(R.id.fragment,Sc).commit();
        }else if(id==R.id.help){
             Third third=new Third();
             setTitle("Help");
             FragmentManager fragmentmanger=getSupportFragmentManager();
             fragmentmanger.beginTransaction().replace(R.id.fragment,third).commit();
         }

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageEbay:
                cam=0;
                web="https://www.ebay.com/";
                break;
            case R.id.imageDeal:
                cam=0;
                web="https://www.dx.com/";
                break;
            case R.id.imageAli:
                cam=0;
                web="https://www.aliexpress.com/";
                break;
            case R.id.imageAmazon:
                cam=0;
                web="https://www.amazon.com/";
                break;
            case R.id.imageGear:
                cam=0;
                web="https://www.gearbest.com/";
                break;
            case R.id.imageWow:
                cam=0;
                web="https://www.wow.lk/";
                break;
            case R.id.imageDaraz:
                cam=0;
                web="https://daraz.lk/";
                break;
            case R.id.imageLabai:
                cam=0;
                web="https://www.laabai.lk/";
                break;
            case R.id.imageMydeal:
                cam=0;
                web="https://www.mydeal.lk/";
                break;
            case R.id.imageCam:
                cam=1;
                break;


        }
        if(cam==1){
            Intent intent2 = new Intent(MainActivity.this, CamActivity.class); //go to cam window
            startActivity(intent2);
        }else {
            Intent intent1 = new Intent(MainActivity.this, Activity2.class); //go to second window
            intent1.putExtra("e", web);
            startActivity(intent1);
        }

    }

}
