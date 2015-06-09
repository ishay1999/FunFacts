package com.howtoevery.funfacts;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Creating the random
        final Random rand = new Random();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView factLabel;
        final Button showFactButton;

        factLabel = (TextView) findViewById(R.id.fact);
        final ViewGroup backGround = (RelativeLayout) findViewById(R.id.mainBackground);
        showFactButton = (Button) findViewById(R.id.factButton);

        View.OnClickListener myListener = new View.OnClickListener() {

            int randomNumber;
            int currentState = 0;

            @Override
            public void onClick(View view) {

                do {
                    randomNumber = rand.nextInt(2); // randomNumber will be 0 or 1
                }   while (currentState == randomNumber);

                currentState = randomNumber;

                switch (randomNumber) {
                    case 0: { // in case it is 0, show fact number 1 with green color
                        factLabel.setText(R.string.fact1);
                        backGround.setBackgroundColor(getResources().getColor(R.color.android_green));
                        showFactButton.setTextColor(getResources().getColor(R.color.android_green));
                    } break;

                    case 1: { // in case it is 1, show fact number 2 with orange color
                        factLabel.setText(R.string.fact2);
                        backGround.setBackgroundColor(getResources().getColor(R.color.orangish));
                        showFactButton.setTextColor(getResources().getColor(R.color.orangish));
                    } break;
                }

          //      factLabel.setText(String.valueOf(randomNumber)); // show the number generated with randomNumber, ONLY FOR DEBUG PURPOSES

            }
        };

        showFactButton.setOnClickListener(myListener);
    }

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
