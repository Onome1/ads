package com.cs401.ads;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class problemDetected extends AppCompatActivity {
    public Button repairShop;
    public void listRepairShop(){
        repairShop = (Button)findViewById(R.id.view_all);
        repairShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(problemDetected.this,MechanicList.class);
                startActivity(intent2);
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_detected);
        listRepairShop();
    }
}
