package com.cs401.ads;

import android.graphics.Color;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MechanicList extends AppCompatActivity {

    TableLayout myMechanicListTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic_list);
        myMechanicListTab=(TableLayout)findViewById(R.id.tableMechanicList);
        viewMechanic();
    }

    public void viewMechanic(){

        // this is to enable networking on the main thread, don't touch it for now
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        // set up rest api
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080").addConverterFactory(GsonConverterFactory.create()).build();
        MechanicInfo service = retrofit.create(MechanicInfo.class);
        int num = -1;
        TableRow mechanicTableRow;
        TextView nameTab, addressTab;
        int leftRowMargin = 0;
        int topRowMargin = 0;
        int rightRowMargin = 0;
        int mediumSize = (int) getResources().getDimension(R.dimen.font_size_medium);
        int textSize = (int) getResources().getDimension(R.dimen.font_size_verysmall);
        int smallTextSize = (int) getResources().getDimension(R.dimen.font_size_small);



        try {

            List<Mechanic> mechanics = service.list().execute().body().docs;

            String str1 = "";
            String str2 = "";

            for (Mechanic mechanic : mechanics) {

                str1 = mechanic.name;
                str2 = mechanic.address+" "+mechanic.city+", "+mechanic.state+",   "+mechanic.zipCode;
                mechanicTableRow = new TableRow(this);

                nameTab = new TextView(this);
                nameTab.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
                nameTab.setGravity(Gravity.LEFT);
                nameTab.setPadding(5,15,0,15);
                if(num == - 1){
                    nameTab.setText("Name");
                    nameTab.setBackgroundColor(Color.parseColor("#f0f0f0"));
                    nameTab.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                }
                else{
                    nameTab.setBackgroundColor(Color.parseColor("#f8f8f8"));
                    nameTab.setText(String.valueOf(str1));
                    nameTab.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                }

                addressTab = new TextView(this);
                addressTab.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
                addressTab.setGravity(Gravity.LEFT);
                addressTab.setPadding(5,15,0,15);

                if(num == - 1){
                    addressTab.setText("Address");
                    addressTab.setBackgroundColor(Color.parseColor("#f0f0f0"));
                    addressTab.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                }
                else{

                    addressTab.setBackgroundColor(Color.parseColor("#f8f8f8"));
                    addressTab.setText(String.valueOf(str2));
                    addressTab.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);

                }

                mechanicTableRow.addView(nameTab);
                mechanicTableRow.addView(addressTab);
                myMechanicListTab.addView(mechanicTableRow,new TableLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                num++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }











    }



}
