package com.example.mani.bus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class BusList extends AppCompatActivity {
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
        setContentView(R.layout.activity_bus_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String num="";
        String bus = intent.getExtras().getString("num");
        TextView result=(TextView) findViewById(R.id.result);
        TextView result1=(TextView)findViewById(R.id.result1);
        for(int i=0;i<51;i++)
        {

            if(location[i].equals(bus))
            {
                    num=(busno[i]);
                result1.setText("The following busses go from "+bus +": \n");
                result.setText(num);
            }
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/1ZAXO6zcwb5LOuXD6nza9HVZEB5M5Eh92Bcj5FqVwZ5A/viewform"));
                startActivity(browserIntent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
