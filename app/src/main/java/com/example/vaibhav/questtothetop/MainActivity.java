package com.example.vaibhav.questtothetop;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> names=new ArrayList<>();
    ArrayList<String> temp=new ArrayList<>();
    HashMap<String,Drawable> quiz_questions=new HashMap<>();
    Button button1,button2,button3,button4;
    ImageView logo;
    TextView mtextfield;
    private int no_of_questions=5;
    //boolean flag=false;
    private int mycount=0;
    private int count=0;
    TextView score;
    HashSet<String> quiz=new HashSet<>();
    final Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtextfield=(TextView)findViewById(R.id.timer);
        score = (TextView) findViewById(R.id.score);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        logo = (ImageView) findViewById(R.id.logo);
        score=(TextView)findViewById(R.id.score);
        AssetManager am = this.getAssets();
        try {
            InputStream inputStream = am.open("logo.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = in.readLine()) != null) {
                String word = line.trim();
                names.add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast toast = Toast.makeText(this, "Could not load logo.txt", Toast.LENGTH_LONG);
            toast.show();
        }
        for (int i = 0; i < names.size(); i++) {
            String s = names.get(i);
            Log.i("image name", s);
            Drawable drawable = getResources().getDrawable(getResources().getIdentifier(s, "drawable", getPackageName()));
            quiz_questions.put(names.get(i), drawable);
            Log.i("Hashmap", quiz_questions.get(names.get(i)).toString());
            temp.add(names.get(i));
        }
        newquestion();
    }
    void newactivity() {
        String val = String.valueOf(count);
        Intent i = new Intent(MainActivity.this, EndActivity.class);
        i.putExtra("score", val);
        startActivity(i);
        MainActivity.this.finish();
    }
    void newquestion(){
        button1.setClickable(true);
        button2.setClickable(true);
        button3.setClickable(true);
        button4.setClickable(true);
        button1.setTextColor(getResources().getColor(R.color.black));
        button2.setTextColor(getResources().getColor(R.color.black));
        button3.setTextColor(getResources().getColor(R.color.black));
        button4.setTextColor(getResources().getColor(R.color.black));
        Random random = new Random();
        int temp;
        do {
                temp = random.nextInt(names.size());
        }while(quiz.contains(names.get(temp)));
        final int r=temp;
        quiz.add(names.get(r));
        Drawable res = quiz_questions.get(names.get(r));
        HashSet<String> options=new HashSet<>();
        logo.setImageDrawable(res);
        int x = random.nextInt(4) + 1;
        int a;
        switch (x) {
            case 1:
                button1.setText(names.get(r));
                options.add(names.get(r));
                do {
                    a = random.nextInt(names.size());
                } while (options.contains(names.get(a)));
                options.add(names.get(a));
                button2.setText(names.get(a));
                do {
                    a = random.nextInt(names.size());
                } while (options.contains(names.get(a)));
                options.add(names.get(a));
                button3.setText(names.get(a));
                do {
                    a = random.nextInt(names.size());
                } while (options.contains(names.get(a)));
                options.add(names.get(a));
                button4.setText(names.get(a));
                break;
            case 2:
                button2.setText(names.get(r));
                options.add(names.get(r));
                do {
                    a = random.nextInt(names.size());
                } while (options.contains(names.get(a)));
                options.add(names.get(a));
                button1.setText(names.get(a));
                do {
                    a = random.nextInt(names.size());
                } while (options.contains(names.get(a)));
                options.add(names.get(a));
                button3.setText(names.get(a));
                do {
                    a = random.nextInt(names.size());
                } while (options.contains(names.get(a)));
                options.add(names.get(a));
                button4.setText(names.get(a));
                break;
            case 3:
                button3.setText(names.get(r));
                options.add(names.get(r));
                do {
                    a = random.nextInt(names.size());
                } while (options.contains(names.get(a)));
                options.add(names.get(a));
                button2.setText(names.get(a));
                do {
                    a = random.nextInt(names.size());
                } while (options.contains(names.get(a)));
                options.add(names.get(a));
                button1.setText(names.get(a));
                do {
                    a = random.nextInt(names.size());
                } while (options.contains(names.get(a)));
                options.add(names.get(a));
                button4.setText(names.get(a));
                break;
            case 4:
                button4.setText(names.get(r));
                options.add(names.get(r));
                do {
                    a = random.nextInt(names.size());
                } while (options.contains(names.get(a)));
                options.add(names.get(a));
                button2.setText(names.get(a));
                do {
                    a = random.nextInt(names.size());
                } while (options.contains(names.get(a)));
                options.add(names.get(a));
                button3.setText(names.get(a));
                do {
                    a = random.nextInt(names.size());
                } while (options.contains(names.get(a)));
                options.add(names.get(a));
                button1.setText(names.get(a));
                break;
        }
        final CountDownTimer cdt=new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                mtextfield.setText("seconds remaining: " + millisUntilFinished / 1000);
                if(mycount==no_of_questions) {
                    cancel();
                    newactivity();
                }
            }

            public void onFinish() {
                mycount++;
                if(mycount<no_of_questions) {
                    newquestion();
                }
                else {
                    newactivity();
                }
            }
        }.start();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1.setClickable(false);
                button2.setClickable(false);
                button3.setClickable(false);
                button4.setClickable(false);
                if (button1.getText().toString() == names.get(r)) {
                    button1.setTextColor(getResources().getColor(R.color.correct));
                    count=count+1;
                    score.setText("My score:"+count+"/5");
                } else {
                    button1.setTextColor(getResources().getColor(R.color.wrong));
                }
                mycount++;
                if(mycount<no_of_questions){
                    cdt.cancel();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            newquestion();
                        }
                    },200);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1.setClickable(false);
                button2.setClickable(false);
                button3.setClickable(false);
                button4.setClickable(false);
                if (button2.getText().toString() == names.get(r)) {
                    button2.setTextColor(getResources().getColor(R.color.correct));
                    count++;
                    score.setText("My score:"+count+"/5");
                } else {
                    button2.setTextColor(getResources().getColor(R.color.wrong));
                }
                mycount++;
                if(mycount<no_of_questions){
                    cdt.cancel();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            newquestion();
                        }
                    },200);
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1.setClickable(false);
                button2.setClickable(false);
                button3.setClickable(false);
                button4.setClickable(false);
                if (button3.getText().toString() == names.get(r)) {
                    button3.setTextColor(getResources().getColor(R.color.correct));
                    count++;
                    score.setText("My score:"+count+"/5");
                } else {
                    button3.setTextColor(getResources().getColor(R.color.wrong));
                }
                mycount++;
                if(mycount<no_of_questions){
                    cdt.cancel();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            newquestion();
                        }
                    },200);
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1.setClickable(false);
                button2.setClickable(false);
                button3.setClickable(false);
                button4.setClickable(false);
                if (button4.getText().toString() == names.get(r)) {
                    button4.setTextColor(getResources().getColor(R.color.correct));
                    count++;
                    score.setText("My score:"+count+"/5");
                } else {
                    button4.setTextColor(getResources().getColor(R.color.wrong));
                }
                mycount++;

                if(mycount<no_of_questions){
                    cdt.cancel();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            newquestion();
                        }
                    },200);
                }
            }
        });
        if(mycount==no_of_questions){
            cdt.cancel();
            newactivity();
        }
    }
}
