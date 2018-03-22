package com.example.vaibhav.questtothetop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {
    Button playagain,home;
    TextView score,comment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        playagain=(Button) findViewById(R.id.playagain);
        home=(Button) findViewById(R.id.home);
        score=(TextView) findViewById(R.id.score);
        comment=(TextView) findViewById(R.id.comment);
        Intent i = getIntent();
        String s = i.getStringExtra("score");
        int sc=Integer.parseInt(s);
        score.setText(s+"/5");
        switch (sc) {
            case 0:comment.setText("HOMEWORK NOT DONE");
                break;
            case 1:comment.setText("UNSATISFACTORY");
                break;
            case 2:comment.setText("HARD LUCK");
                break;
            case 3:comment.setText("GOOD JOB");
                break;
            case 4:comment.setText("FABULOUS");
                break;
            case 5:comment.setText("AWESOME");
                break;
        }
        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(EndActivity.this,MainActivity.class);
                startActivity(i);
                EndActivity.this.finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(EndActivity.this,StartActivity.class);
                startActivity(i);
                EndActivity.this.finish();
            }
        });
    }
}
