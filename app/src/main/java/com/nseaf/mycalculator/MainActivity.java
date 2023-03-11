package com.nseaf.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvNumber;
    TextView tvDetails;
    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculator = new Calculator();
        tvNumber = findViewById(R.id.tv_number);
        tvDetails = findViewById(R.id.tv_details);
    }

    public void numberClicked(View view) {
        switch (view.getId()){
            case R.id.b_0: calculator.processNumber(0); break;
            case R.id.b_1: calculator.processNumber(1); break;
            case R.id.b_2: calculator.processNumber(2); break;
            case R.id.b_3: calculator.processNumber(3); break;
            case R.id.b_4: calculator.processNumber(4); break;
            case R.id.b_5: calculator.processNumber(5); break;
            case R.id.b_6: calculator.processNumber(6); break;
            case R.id.b_7: calculator.processNumber(7); break;
            case R.id.b_8: calculator.processNumber(8); break;
            case R.id.b_9: calculator.processNumber(9); break;
        }
        updateCalcUI();
    }



    private void updateCalcUI() {
        tvNumber.setText(calculator.numberString);
        tvDetails.setText(calculator.detailsString);
    }

    public void clearClicked(View view) {
        calculator.clearClicked();
        updateCalcUI();
    }

    public void memPlusClicked(View view) {
        calculator.memPlusClicked();
        updateCalcUI();
    }

    public void memMinusClicked(View view) {
        calculator.memMinusClicked();
        updateCalcUI();
    }

    public void memClearClicked(View view) {
        calculator.memClearClicked();
        updateCalcUI();
    }

    public void memRecallClicked(View view) {
        calculator.memRecallClicked();
        updateCalcUI();
    }

    public void plusClicked(View view) {
        calculator.plusClicked();
        updateCalcUI();
    }

    public void minusClicked(View view) {
        calculator.minusClicked();
        updateCalcUI();
    }

    public void divideClicked(View view) {
        calculator.divideClicked();
        updateCalcUI();
    }

    public void multiplyClicked(View view) {
        calculator.multiplyClicked();
        updateCalcUI();
    }

    public void equalClicked(View view) {
        calculator.equalClicked();
        updateCalcUI();
    }

    public void radixClicked(View view) {
        calculator.radixClicked();
        updateCalcUI();
    }

    public void exponentClicked(View view) {
        calculator.exponentClicked();
        updateCalcUI();
    }

    public void mathPiClicked(View view) {
        calculator.mathPiClicked();
        updateCalcUI();
    }
    public void percentageClicked(View view) {
        calculator.percentageClicked();
        updateCalcUI();
    }
}