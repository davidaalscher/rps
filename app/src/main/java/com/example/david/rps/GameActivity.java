package com.example.david.rps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    int rock_value = 0;
    int paper_value = 0;
    int scissors_value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
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
        int  n = rand.nextInt(3) + 1;
        return n;

    }

    int determine_comp(){
        Random rand = new Random();
        int  m = rand.nextInt(3) + 1;
        return m;
    }

}
