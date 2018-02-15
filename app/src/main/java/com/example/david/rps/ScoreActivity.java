package com.example.david.rps;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
//import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        call_score();
    }

    public void call_score() {
        Intent i = getIntent();
        String score = i.getStringExtra("score");
        //Toast.makeText(this, score, Toast.LENGTH_LONG).show();
        displayScore(score);
        displayTotalCoin();
    }

    public void playAgain(View v){
        Intent j = new Intent(this, MainActivity.class);
        j.putExtra("NewCoin", call_total());
        startActivity(j);
    }

    public void displayScore(String score){
        TextView scoreView = /*(TextView)*/ findViewById(R.id.score_value);
        scoreView.setText(score);
    }

    public void displayTotalCoin(){
        TextView totalCoinView = /*(TextView)*/ findViewById(R.id.new_coin_value);
        totalCoinView.setText(String.valueOf(call_total()));
    }

    public int call_total() {
        Intent m = getIntent();
        return m.getIntExtra("new_coin", 0);
    }

}
