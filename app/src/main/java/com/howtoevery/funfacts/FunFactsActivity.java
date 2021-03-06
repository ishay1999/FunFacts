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


public class FunFactsActivity extends ActionBarActivity {

    final int testInt = 3;
    public static final String TAG = FunFactsActivity.class.getSimpleName();

    // Creating the random
    Random rand = new Random();

    TextView factLabel;
    Button showFactButton;
    ViewGroup backGround;

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

    int [] stringsResource = {
            R.string.fact1,
            R.string.fact2,
            R.string.fact3,
            R.string.fact4,
            R.string.fact5,
            R.string.fact6,
            R.string.fact7,
            R.string.fact8,
            R.string.fact9,
            R.string.fact10
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
                    randomNumber = rand.nextInt(colors.length);
                } while (currentState == randomNumber);

                //    setFact(facts[randomFact], colors[randomColor]);
//                factLabel.setText(facts[randomFact]);
//                backGround.setBackgroundColor(getResources().getColor(colors[randomColor]));
//                showFactButton.setTextColor(colors[randomColor]);

                setFact(stringsResource[randomNumber], colors[randomNumber]);

                currentState = randomNumber;
            }
        };

        showFactButton.setOnClickListener(myListener);

        Log.i(TAG, "A log output to the information level, woohoo!");
        Log.i(TAG, String.valueOf(testInt)); // output the int, good for checking for loops and something like this
        // we can see this message from the log level of info and above
        // we can also search in the logCat for "woohoo" or "FunFactsActivity".

//        String message = "Yay! bla bla";
//        Toast welcomeToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
//        welcomeToast.show();

        // or in a shorter way:
     //   Toast.makeText(this, "Yay! bla bla", Toast.LENGTH_SHORT).show();
        // we don't need this toast anymore so it's commented out.

    }

    public void setFact(int factString, int color) {
        factLabel.setText(factString);
        backGround.setBackgroundColor(getResources().getColor(color));
        showFactButton.setTextColor(getResources().getColor(color));
    }

}


