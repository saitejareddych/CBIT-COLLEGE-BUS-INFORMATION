package com.example.mani.bus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int count=1;
    String[] busno={"39,30,34","29,17,10","90 , 92 , 94","29 , 17 , 18 , 20","10","19 , 10 , 12 , 14","19 , 12 , 14","19","19 , 12 , 14",
            "29 , 12 , 14 , 17 , 18 , 20 , 22 , 24 , 26 , 30 , 32 , 34","39 , 30 , 32, 34","39","39 , 30 , 32 , 34","39 , 34","39 , 17 , 18","49 , 44 , 48",
            "59 , 50 , 52","59, 54"," 59 , 52 , 50","50","14, 18","24","68","48","52","28","28,24","29","28,26,50","29,20","22","19,12,14","54","48","22 , 24 , 26","62 , 64 ,66","62,64","66,68",
    "68","62,64","50 , 54","50,54","54","24,26","50","69 , 60 , 62 , 64 , 66 , 68","69 , 62 , 60","69 , 52 , 54","32","19 , 12","49,44"};
    String[] location={"abids","rtc x road","langar house","musheerabad","amberpet","vidyanagar","nallakunta","narayanguda","himayathnagar",
            "mp","kothapet","chaitanyapuri","dsnr","koti","lakdikapool","attapur","sr nagar","jubilee check post","esi","ameerpet","habsiguda","thirumalgerry ",
            "balanagar","chandrayangutta","lvp","patny","begampet","radhika","care hospital","malkajgiri","west maredpalli","liberty","hitech city","bn reddy","life style","jntu","nizampet",
    "kphb","malaysian township","talky town","orr","darga","madhapur","paradise","tolichowki","gachibowli","bhel","miyapur","basheerbagh","uppal x road",
    "lb nagar"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton b =(FloatingActionButton)findViewById(R.id.fab2);
        final AutoCompleteTextView area = (AutoCompleteTextView) findViewById(R.id.place);
        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,location);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/1ZAXO6zcwb5LOuXD6nza9HVZEB5M5Eh92Bcj5FqVwZ5A/viewform"));
                startActivity(browserIntent);


            }
        });

        area.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                area.setThreshold(1);
                area.setAdapter(adapter1);
            }
        });
        area.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String place = area.getText().toString();
                for (int i = 0; i < 51; i++) {
                    if (location[i].equals(place)) {
                        Intent intent = new Intent(MainActivity.this, BusList.class);
                        intent.putExtra("num", place);
                        startActivity(intent);
                        count = count - 1;
                        break;
                    }
                }
                if (count == 1) {
                    Toast.makeText(getApplicationContext(), "Try again with a valid location", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String place = area.getText().toString();
                for (int i = 0; i < 50; i++) {
                    if (location[i].equals(place)) {
                        Intent intent = new Intent(MainActivity.this, BusList.class);
                        intent.putExtra("num", place);
                        startActivity(intent);
                        count = count - 1;
                        break;
                    }
                }
                if (count == 1) {
                    Toast.makeText(getApplicationContext(), "Try again with a valid location", Toast.LENGTH_SHORT).show();
                }


                // Intent intent = new Intent(MainActivity.this, numbers.class);
                //intent.putExtra("num", place);
                // startActivity(intent);
            }

        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            Intent intent = new Intent(MainActivity.this,contact.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(MainActivity.this, gallery.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/1ZAXO6zcwb5LOuXD6nza9HVZEB5M5Eh92Bcj5FqVwZ5A/viewform"));
            startActivity(browserIntent);

        } else if (id == R.id.nav_manage) {
            Intent intent = new Intent(MainActivity.this, FeeStructure.class);
            startActivity(intent);

        }
        else if(id==R.id.inst) {
            Intent intent = new Intent(MainActivity.this,Instructions.class);
            startActivity(intent);
        }
        else if(id==R.id.inststu) {
            Intent intent = new Intent(MainActivity.this,StudentInstructions.class);
            startActivity(intent);
        }
        else if(id==R.id.website){
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cbit.ac.in/"));
            startActivity(browserIntent);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
