package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.londonappbrewery.destini.R.string.END;
import static com.londonappbrewery.destini.R.string.T1_Ans1;
import static com.londonappbrewery.destini.R.string.T1_Ans2;
import static com.londonappbrewery.destini.R.string.T1_Story;
import static com.londonappbrewery.destini.R.string.T2_Ans1;
import static com.londonappbrewery.destini.R.string.T2_Ans2;
import static com.londonappbrewery.destini.R.string.T2_Story;
import static com.londonappbrewery.destini.R.string.T3_Ans1;
import static com.londonappbrewery.destini.R.string.T3_Ans2;
import static com.londonappbrewery.destini.R.string.T3_Story;
import static com.londonappbrewery.destini.R.string.T4_End;
import static com.londonappbrewery.destini.R.string.T5_End;
import static com.londonappbrewery.destini.R.string.T6_End;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mTextView;
    Button mButtonTop;
    Button mButtonBottom;
    int i = 0;
    int [] tab ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab = new int[3];

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);
        mTextView = (TextView) findViewById(R.id.storyTextView);

        mButtonTop.setText(T1_Ans1);
        mButtonBottom.setText(T1_Ans2);
        mTextView.setText(T1_Story);
       tab[0]=0;
       tab[1]=0;
       tab[2] =0;


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if (i<3)  {  tab[i]=1;
              update();
                }
              else stop();i++;
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i<3){  tab[i]=2;
               update();
                }
                else stop();i++;}
        });

    }

    public void update()
    {
    if (tab[0]==1 && tab[1]==0)
        {mTextView.setText(T3_Story);
        mButtonBottom.setText(T3_Ans2);
        mButtonTop.setText(T3_Ans1);}
        else if (tab[0]==1 && tab[1]==1)
        {mTextView.setText(T6_End);
        mButtonTop.setText(END);
        mButtonBottom.setText(END);}
        else if (tab[0]==1 && tab[1]==2)
        {mTextView.setText(T5_End);
        mButtonTop.setText(END);
        mButtonBottom.setText(END);}
        else if (tab[0]==2 && tab[1]==0 && tab[2]==0)
        {mTextView.setText(T2_Story);
        mButtonTop.setText(T2_Ans1);
        mButtonBottom.setText(T2_Ans2);}
        else if (tab[0]==2 && tab[1]==2 && tab[2]==0)
        {mTextView.setText(T4_End);
        mButtonTop.setText(END);
        mButtonBottom.setText(END);}
        else if (tab[0]==2 && tab[1]==1 && tab[2]==0)
        {mTextView.setText(T3_Story);
        mButtonTop.setText(T3_Ans1);
        mButtonBottom.setText(T3_Ans2);}
        else if (tab[0]==2 && tab[1]==1 && tab[2]==1)
        {mTextView.setText(T6_End);
        mButtonTop.setText(END);
        mButtonBottom.setText(END);}
        else if (tab[0]==2 && tab[1]==1 && tab[2]==2)
        {mTextView.setText(T5_End);
        mButtonTop.setText(END);
        mButtonBottom.setText(END);}
    }
public  void stop ()
{
    AlertDialog.Builder alert = new AlertDialog.Builder(this);
    alert.setTitle("Game Over");
    alert.setCancelable(false);
    alert.setMessage("I hope you enjoyed the game!");
    alert.setPositiveButton("Close App", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            finish();
        }
    });

    alert.show();
}
}
