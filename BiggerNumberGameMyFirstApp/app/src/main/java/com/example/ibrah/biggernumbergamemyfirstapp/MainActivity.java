package com.example.ibrah.biggernumbergamemyfirstapp;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.widget.Toast.*;

public class MainActivity extends Activity {

    Random random;
    Toast toast;
    private TextView score;
    private Button[] buttons;
    private int index_bigger,question_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = findViewById(R.id.textview);
        buttons = new Button[]{findViewById(R.id.button), findViewById(R.id.button2)};
        random = new Random(System.currentTimeMillis());
        toast = Toast.makeText(this,"",Toast.LENGTH_SHORT);
        ready();
    }

    private void ready() {

        do {

            buttons[0].setText(String.valueOf(random.nextInt(100)));
            buttons[1].setText(String.valueOf(random.nextInt(100)));

        }while(buttons[0].getText() == buttons[1].getText());


        if(Integer.valueOf((String) buttons[0].getText()) > Integer.valueOf((String) buttons[1].getText()))
            index_bigger = 0;
        else
            index_bigger = 1;

    }

    public void button_click(View view) {

        if(view == buttons[index_bigger])
                score.setText(String.valueOf(Integer.valueOf((String) score.getText()) + 100));
        else
                score.setText(String.valueOf(Integer.valueOf((String) score.getText()) - 50));

        if(Integer.valueOf((String) score.getText()) == -300)
            game_end(false);
        else
            game_end(true);
    }

    private void game_end(boolean end_type){

        if(end_type == true)
            if(question_count != 30)
                ready();
            else{
                try {
                    toast.cancel();
                    toast = Toast.makeText(this,"",Toast.LENGTH_SHORT);
                }catch (Exception E){}

                toast.setText("Congralations You Won!!");
                toast.show();
            }
        else{

            try {
                toast.cancel();
                toast = Toast.makeText(this,"",Toast.LENGTH_SHORT);
            }catch (Exception E){}

            toast.setText("You Lost!!!");
            toast.show();
        }

    }


}