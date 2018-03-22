package com.example.vaibhav.questtothetop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {
    Button play,help;
    TextView helpsection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        play=(Button) findViewById(R.id.play);
        help=(Button) findViewById(R.id.help);
        helpsection=(TextView) findViewById(R.id.helpsection);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(StartActivity.this,MainActivity.class);
                startActivity(i);
                StartActivity.this.finish();
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpsection.setText("This quiz contains 5 Logos questions.\nYou need to choose correct option from 4 alternatives.\nChoose fast !! You have only 10 seconds. ");
            }
        });
    }
}
