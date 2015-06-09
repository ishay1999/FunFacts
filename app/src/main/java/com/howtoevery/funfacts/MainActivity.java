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
    // Creating the random
    Random rand = new Random();

    TextView factLabel;
    Button showFactButton;
    ViewGroup backGround;


    @Override
    protected void onCreate(Bundle savedInstanceState) {





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] facts = {
                "Ants stretch when they wake up in the morning.",
                "Ostriches can run faster than horses.",
                "Olympic gold medals are actually made mostly of silver.",
                "You are born with 300 bones; by the time you are an adult you will have 206.",
                "It takes about 8 minutes for light from the Sun to reach Earth.",
                "Some bamboo plants can grow almost a meter in just one day.",
                "The state of Florida is bigger than England.",
                "Some penguins can leap 2-3 meters out of the water.",
                "On average, it takes 66 days to form a new habit.",
                "Mammoths still walked the earth when the Great Pyramid was being built." };

        final int [] colors = {
                R.color.orangish,
                R.color.android_green,
                R.color.ugly_sea,
                R.color.turkiz,
                R.color.shilshul,
                R.color.nice_purple,
                R.color.gray,
                R.color.gay_pink,
                R.color.bordo,
                R.color.red
        };


        factLabel = (TextView) findViewById(R.id.fact);
        backGround = (RelativeLayout) findViewById(R.id.mainBackground);
        showFactButton = (Button) findViewById(R.id.factButton);

        View.OnClickListener myListener = new View.OnClickListener() {

            int currentState = 0;
            int randomNumber;

            @Override
            public void onClick(View view) {

                do {
                    randomNumber = rand.nextInt(facts.length);
                } while (currentState == randomNumber);

                    //    setFact(facts[randomFact], colors[randomColor]);
//                factLabel.setText(facts[randomFact]);
//                backGround.setBackgroundColor(getResources().getColor(colors[randomColor]));
//                showFactButton.setTextColor(colors[randomColor]);

                setFact(facts[randomNumber], colors[randomNumber]);

                currentState = randomNumber;
            }
        };

        showFactButton.setOnClickListener(myListener);
    }
    public void setFact(String factString, int color) {
        factLabel.setText(factString);
        backGround.setBackgroundColor(getResources().getColor(color));
        showFactButton.setTextColor(getResources().getColor(color));
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
