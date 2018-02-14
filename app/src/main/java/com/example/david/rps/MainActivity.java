package com.example.david.rps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int bet = 1;
    int total_coin = 49;
    int updated_coin = 49;
/*
    TextView coinValue = (TextView) findViewById(R.id.coin_value);
    coinValue.setText(getString(R.string.total_coins,total_coin));
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startGame(View v){
        Intent i = new Intent(this, GameActivity.class);
        startActivity(i);
    }

    /*
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimpSlifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/

    public void displayForBet(int bet){
        TextView betView = (TextView) findViewById(R.id.bet_value);
        betView.setText(String.valueOf(bet));
    }

    public void displayForCoins(int total_coin){
        TextView coinView = (TextView) findViewById(R.id.coin_value);
        coinView.setText(String.valueOf(total_coin));
    }
/*
    public void initialize(View v){
        displayForCoins(total_coin);
    }
*/
    public void add_bet(View v) {
        if (bet < updated_coin) {
            bet = bet + 1;
            total_coin = total_coin - 1;
            displayForBet(bet);
            displayForCoins(total_coin);
        }
    }


    public void sub_bet(View v) {
        if (bet > 1) {
            bet = bet - 1;
            total_coin = total_coin + 1;
            displayForBet(bet);
            displayForCoins(total_coin);
        }
    }

}
