package com.hacktiv8.assigment2_fitria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

   TextView scoreTv;
    Button button_count;
    EditText namaEt;
    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTv = findViewById(R.id.scoreTv);
        button_count = findViewById(R.id.button_count);
        namaEt = findViewById(R.id.namaEt);

        button_count.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String currentScore = scoreTv.getText().toString();
        int currentScoreInt = Integer.valueOf(currentScore);

        score = currentScoreInt +1;
        scoreTv.setText(String.valueOf(score));

    }

    @Override
    protected void onSaveInstanceState( Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("count",String.valueOf(scoreTv.getText()));

    }

    @Override
    protected void onRestoreInstanceState(Bundle mySavedState) {
        super.onRestoreInstanceState(mySavedState);
        if(mySavedState != null){
            String count = mySavedState.getString("count");
            if (count != null) scoreTv.setText(count);
        }
    }
}