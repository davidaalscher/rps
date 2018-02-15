package com.example.david.rps;

import android.content.Intent;
import android.view.View;
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
        Toast.makeText(this, score, Toast.LENGTH_LONG).show();
    }

    public void playAgain(View v){
        Intent j = new Intent(this, MainActivity.class);
        startActivity(j);
    }

}
