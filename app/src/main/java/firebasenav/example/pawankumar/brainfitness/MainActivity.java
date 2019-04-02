package firebasenav.example.pawankumar.brainfitness;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.Button;
//import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
   // ImageView imageView;
    TextView pointTextView;
    TextView resultTextView;
    Button startButton;
    Button playAgain;
    GridLayout gridLayout;
    int a,b;
    int score;
    TextView sumTextView;
    ArrayList<Integer> ans= new ArrayList<>();
    int locationOfCorrectAnswer;
    int incorrectAnswer;
    int numberOfQus;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView timerView;
    RelativeLayout gameRelativeLayout;

     public void playButton(View view)
     {
         score=0;
         numberOfQus=0;
         timerView.setText("30s");
         pointTextView.setText("0/0");
         resultTextView.setText("");
         playAgain.setVisibility(View.INVISIBLE);
         gridLayout.setVisibility(View.VISIBLE);
         generateQue();

         new CountDownTimer(30100,1000){


             @Override
             public void onTick(long l) {
                 timerView.setText(String.valueOf(l/1000)+"s");

             }

             @Override
             public void onFinish() {
                 playAgain.setVisibility(View.VISIBLE);
                 timerView.setText("0s");
                 resultTextView.setText("Your Score :"+Integer.toString(score)+"/"+Integer.toString(numberOfQus));
                 gridLayout.setVisibility(View.GONE);

             }
         }.start();




     }

    public void generateQue()
    {
        Random random=new Random();
        a=random.nextInt(100);
        b=random.nextInt(100);
        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));
        locationOfCorrectAnswer=random.nextInt(4);
        ans.clear();
        for (int j=0;j<4;j++)
        {
            if(j==locationOfCorrectAnswer)
            {
                ans.add(a+b);

            }
            else
            {
                incorrectAnswer=random.nextInt(160);
                while(incorrectAnswer==a+b)
                {
                    incorrectAnswer=random.nextInt(160);

                }
                ans.add(incorrectAnswer);
            }
        }
        button0.setText(Integer.toString(ans.get(0)));
        button1.setText(Integer.toString(ans.get(1)));
        button2.setText(Integer.toString(ans.get(2)));
        button3.setText(Integer.toString(ans.get(3)));


    }

    public void  chooseAns(View view)
    {
        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer)))
        {
          score++;
          resultTextView.setText("Correct!");
        }
        else {
            resultTextView.setText("Wrong!");
        }

        numberOfQus++;
        pointTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQus));
        generateQue();


    }

    public void start(View view)

     {   gameRelativeLayout.setVisibility(View.VISIBLE);
         startButton.setVisibility(View.INVISIBLE);
        // imageView.setVisibility(View.INVISIBLE);
         playButton(findViewById(R.id.playAgainButton));
     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton =findViewById(R.id.button);
       // imageView=findViewById(R.id.imageView);
        sumTextView=findViewById(R.id.textView5);
        timerView=findViewById(R.id.textView);
        playAgain=findViewById(R.id.playAgainButton);
        button0=(Button)findViewById(R.id.button3);
        button1=(Button)findViewById(R.id.button4);
        button2=(Button)findViewById(R.id.button5);
        button3=(Button)findViewById(R.id.button6);
        resultTextView=(TextView)findViewById(R.id.textView6);
        gameRelativeLayout=(RelativeLayout)findViewById(R.id.gameRelativeLayout);
        pointTextView=(TextView)findViewById(R.id.textView3);
        gridLayout=findViewById(R.id.gridLayout);


        startButton.setBackgroundColor(Color.TRANSPARENT);




    }




}
