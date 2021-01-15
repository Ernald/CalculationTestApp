package com.gohool.calculationtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText textBillNumber;
    private SeekBar seekBarPercentage;
    private Button buttonTip;
    private TextView showFinalResult;
    private TextView tipPercentage;
    private int putSeekValue;
    private float enteredBill;
    private TextView totalBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplication(),"Hello",Toast.LENGTH_LONG).show();

        textBillNumber = (EditText) findViewById(R.id.amountCalcId);
        seekBarPercentage = (SeekBar) findViewById(R.id.seekBarId);
        buttonTip = (Button) findViewById(R.id.tipsButtonId);
        showFinalResult = (TextView) findViewById(R.id.resultId);
        tipPercentage = (TextView) findViewById(R.id.tipPercentageId);
        totalBill = (TextView) findViewById(R.id.totalShowResult);

        buttonTip.setOnClickListener(this);

        seekBarPercentage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tipPercentage.setText(String.valueOf(seekBarPercentage.getProgress() + " %"));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                putSeekValue = seekBar.getProgress();
            }
        });

    }

    @Override
    public void onClick(View view) {
        calculate();
    }
    public void calculate(){
        float result = 0.0f;
        if(!textBillNumber.getText().toString().equals("")){
            enteredBill =Float.parseFloat(textBillNumber.getText().toString());
            result = enteredBill * putSeekValue / 100;
            showFinalResult.setText("Your tip will be : $ " + String.valueOf(result));
            totalBill.setText("Total Bill : $" + String.valueOf(enteredBill+result));
        }else{
            Toast.makeText(MainActivity.this,"Please enter a bill amount",Toast.LENGTH_LONG).show();

        }

    }
}