package com.howtoevery.funfacts;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
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

    String[] facts = {
            "Ants stretch when they wake up in the morning.",
            "Ostriches can run faster than horses.",
            "Olympic gold medals are actually made mostly of silver.",
            "You are born with 300 bones; by the time you are an adult you will have 206.",
            "It takes about 8 minutes for light from the Sun to reach Earth.",
            "Some bamboo plants can grow almost a meter in just one day.",
            "The state of Florida is bigger than England.",
            "Some penguins can leap 2-3 meters out of the water.",
            "On average, it takes 66 days to form a new habit.",
            "Mammoths still walked the earth when the Great Pyramid was being built."};

    int[] colors = {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

        Log.i("FunFactsActivity", "A log output to the information level, woohoo!");

//        String message = "Yay! bla bla";
//        Toast welcomeToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
//        welcomeToast.show();

        // or in a shorter way:
     //   Toast.makeText(this, "Yay! bla bla", Toast.LENGTH_SHORT).show();
        // we don't need this toast anymore so it's commented out.

    }

    public void setFact(String factString, int color) {
        factLabel.setText(factString);
        backGround.setBackgroundColor(getResources().getColor(color));
        showFactButton.setTextColor(getResources().getColor(color));
    }

}


