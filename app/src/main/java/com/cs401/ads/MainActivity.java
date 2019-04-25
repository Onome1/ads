package com.cs401.ads;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
 public Button proButton;

 public void startProblemDetect(){
     proButton =(Button)findViewById(R.id.runDiagnostics);
     proButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent1 = new Intent(MainActivity.this,problemDetected.class);
             startActivity(intent1);
         }
     });


 }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startProblemDetect();
    }

}
