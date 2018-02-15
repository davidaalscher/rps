package com.example.david.rps;

import android.content.Intent;
import android.os.Handler;
//import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
//import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    int rock_value = 0;
    int paper_value = 0;
    int scissors_value = 0;
    int three = 3;
    int two = 2;
    int one = 1;
    String go = "GO!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                displayFirstCount(three);
            }
        }, 2000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                displaySecondCount(two);
            }
        }, 4000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                displayThirdCount(one);
            }
        }, 6000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                displayFourthCount(go);
            }
        }, 8000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                check();
            }
        }, 8500);
    }

    void check(){
        int player = determine_hand(rock_value, paper_value, scissors_value);
        int computer = determine_comp();
        if ((player == 1 && computer == 2) || (player == 2 && computer == 3) || (player == 3 && computer == 1)) {
            //Toast.makeText(this, "You lost", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, ScoreActivity.class);
            i.putExtra("score", "You Lost");
            startActivity(i);
        }
        if ((player == 2 && computer == 1) || (player == 3 && computer == 2) || (player == 1 && computer == 3)) {
            //Toast.makeText(this, "You win", Toast.LENGTH_LONG).show();
            Intent j = new Intent(this, ScoreActivity.class);
            j.putExtra("score", "You Won");
            startActivity(j);
        }
        if (player == computer) {
            //Toast.makeText(this, "It is a draw", Toast.LENGTH_LONG).show();
            Intent k = new Intent(this, ScoreActivity.class);
            k.putExtra("score", "It's a Draw");
            startActivity(k);
        }
    }

    public void displayFirstCount(int three){
        TextView CountView = /*(TextView)*/ findViewById(R.id.count_value);
        CountView.setText(String.valueOf(three));
    }

    public void displaySecondCount(int two){
        //TextView secondCountView = /*(TextView)*/ findViewById(R.id.first_count);
        TextView CountView = /*(TextView)*/ findViewById(R.id.count_value);
        CountView.setText(String.valueOf(two));
    }

    public void displayThirdCount(int one){
        //TextView secondCountView = /*(TextView)*/ findViewById(R.id.first_count);
        TextView CountView = /*(TextView)*/ findViewById(R.id.count_value);
        CountView.setText(String.valueOf(one));
    }

    public void displayFourthCount(String go){
        //TextView secondCountView = /*(TextView)*/ findViewById(R.id.first_count);
        TextView CountView = /*(TextView)*/ findViewById(R.id.count_value);
        CountView.setText(go);
    }

    public void add_rock(View v) {
        rock_value = rock_value + 1;
    }

    public void add_paper(View v) {
        paper_value = paper_value + 1;
    }

    public void add_scissors(View v) {
        scissors_value = scissors_value + 1;
    }

    int determine_hand(int rock_value, int paper_value, int scissors_value){
        if (rock_value > paper_value){
            if (rock_value > scissors_value){
                return 1;
            }
            if (scissors_value > rock_value){
                return 3;
            }
        }
        if (paper_value > scissors_value){
            if(paper_value > rock_value){
                return 2;
            }
            if (rock_value > paper_value){
                return 1;
            }
        }
        if (scissors_value > rock_value){
            if(scissors_value > paper_value){
                return 3;
            }
            if (paper_value > scissors_value){
                return 2;
            }
        }
        if(scissors_value == rock_value){
            if(scissors_value > paper_value){
                return 1;
            }
        }
        if(scissors_value == paper_value){
            if(scissors_value > rock_value){
                return 3;
            }
        }
        if(paper_value == rock_value){
            if(paper_value > scissors_value){
                return 2;
            }
        }

        Random rand = new Random();
        return rand.nextInt(3) + 1;

    }

    int determine_comp(){
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }

}
