package com.example.a355project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.security.keystore.StrongBoxUnavailableException;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class Activity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    public static final String PRICE_TEXT = "com.example.a355project.PRICE_TEXT";
    public static final String STYLE_TEXT = "com.example.a355project.STYLE_TEXT";
    public static final String DISTANCE_TEXT = "com.example.a355project.DISTANCE_TEXT";
    public static final String GROUP_TEXT = "com.example.a355project.GROUP_TEXT";
    public static final String FOOD_TEXT = "com.example.a355project.FOOD_TEXT";

    //intialized buttons
    Button buttonMap;

    //food style buttons
    Button buttonDelivery;
    Button buttonTakeout;
    Button buttonDineIn;

    String Style = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        //navigate button and openMaps intent to open Map utility and go to chosen place
        buttonMap = (Button) findViewById(R.id.buttonMap);
        Uri address = Uri.parse("geo:0,0 ?q=Canes+VCU"); //canes on campus for testing functionality
        final Intent openMaps = new Intent(Intent.ACTION_VIEW, address);

        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(openMaps.resolveActivity(getPackageManager()) != null) { //checks if there is an app installed that can handle gps
                    startActivity(openMaps); //opens openMaps Intent which calls google maps or other mapp utility to open

                }
            }

        });
    /*
    Spinner object creates the dropdown button for "Type of Food"
    */
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.TypeOfFood, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    /*
    Food style buttons stay dark when selected and return to default when unselected
     */

        buttonDelivery = findViewById(R.id.buttonDelivery);
        buttonDelivery.setOnClickListener(new View.OnClickListener() {
            int select = 1;
            @Override
            public void onClick(View v) {
                if(select == 1){
                    buttonDelivery.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                    select = 0;
                }
                else if(select == 0){
                    buttonDelivery.getBackground().clearColorFilter();
                    select = 1;
                }
                Style = Style + "Delivery";
            }
        });

        buttonTakeout = findViewById(R.id.buttonTakeout);
        buttonTakeout.setOnClickListener(new View.OnClickListener() {
            int select = 1;
            @Override
            public void onClick(View v) {
                if(select == 1){
                    buttonTakeout.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                    select = 0;
                }
                else if(select == 0){
                    buttonTakeout.getBackground().clearColorFilter();
                    select = 1;
                }
                Style = Style + "Takeout";
            }
        });

        buttonDineIn = findViewById(R.id.buttonDineIn);
        buttonDineIn.setOnClickListener(new View.OnClickListener() {
            int select = 1;
            @Override
            public void onClick(View v) {
                if(select == 1){
                    buttonDineIn.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                    select = 0;
                }
                else if(select == 0) {
                    buttonDineIn.getBackground().clearColorFilter();
                    select = 1;
                }
                Style = Style + "Dine-In";
            }
        });

        Button Activity4 = (Button) findViewById(R.id.Activity4);
        Activity4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });

    }

    //opens the mainActivity when the button is clicked
    public void openActivityMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void openActivity4(){

        Intent intent = new Intent(this, Activity4.class);
        intent.putExtra(STYLE_TEXT, Style);
        startActivity(intent);
    }

    /*** MADE BY JESUS ON 10/06/2020 ********************************************/
    /**** NEED TO FIX THIS BUTTON; DOES NOT CALL ACT3, GOES BACK TO MAIN ACT ****/
//    //opens tips menu from Activity2 (TIPS MENU = ACTIVITY3
//    public void openActivity3(View view) {
//        Intent tipsIntent = new Intent(this, Activity3.class);
//        startActivity(tipsIntent);
    //}
    /*** IF DELETED, NEED TO DELETE TIPS BUTTON ON ACT2.XML; ALL THE WAY AT THE BOTTOM *****/
}