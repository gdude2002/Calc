package me.gserv.Calc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends Activity {

    long lastLong = 0;

    boolean toClear = true;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void numberPressed(int num) {
        EditText resultLabel = (EditText) findViewById(R.id.result);

        if (! this.toClear) {
            if (resultLabel.getText().length() < 10) {
                resultLabel.setText(resultLabel.getText() + String.valueOf(num));
            }
        } else {
            resultLabel.setText(String.valueOf(num));
            this.toClear = false;
        }
    }

    public void setOperation(String operation) {
        EditText resultLabel = (EditText) findViewById(R.id.result);
        TextView operationLabel = (TextView) findViewById(R.id.operation);

        operationLabel.setText(operation);
        this.toClear = true;

        try {
            lastLong = Long.parseLong(resultLabel.getText().toString());
        } catch (NumberFormatException e) {
            operationLabel.setText("Error");
        }
    }

    public void doOperation() {
        EditText resultLabel = (EditText) findViewById(R.id.result);
        TextView operationLabel = (TextView) findViewById(R.id.operation);

        long resultLong;
        this.toClear = true;

        try {
            resultLong = Long.parseLong(resultLabel.getText().toString());
        } catch (NumberFormatException e) {
            resultLabel.setText("Error");
            return;
        }
        long complete;

        switch (Operations.getFromString(operationLabel.getText().toString())) {
            case PLUS:
                complete = lastLong + resultLong;
                break;
            case MINUS:
                complete = lastLong - resultLong;
                break;
            case EQUALS:
                complete = resultLong;
                break;
            case MULTIPLY:
                complete = lastLong * resultLong;
                break;
            case DIVIDE:
                complete = lastLong / resultLong;
                break;
            case POWER:
                complete = (long) Math.floor(Math.pow(lastLong, resultLong));
                break;
            default:
                complete = resultLong;
                break;
        }

        lastLong = complete;
        resultLabel.setText(String.valueOf(lastLong));
        this.setOperation("=");
    }

    public void onButton1(View view) {
        this.numberPressed(1);
    }

    public void onButton2(View view) {
        this.numberPressed(2);
    }

    public void onButton3(View view) {
        this.numberPressed(3);
    }

    public void onButton4(View view) {
        this.numberPressed(4);
    }

    public void onButton5(View view) {
        this.numberPressed(5);
    }

    public void onButton6(View view) {
        this.numberPressed(6);
    }

    public void onButton7(View view) {
        this.numberPressed(7);
    }

    public void onButton8(View view) {
        this.numberPressed(8);
    }

    public void onButton9(View view) {
        this.numberPressed(9);
    }

    public void onButton0(View view) {
        this.numberPressed(0);
    }

    public void onButtonPlu(View view) {
        this.setOperation("+");
    }

    public void onButtonSub(View view) {
        this.setOperation("-");
    }

    public void onButtonEqu(View view) {
        this.doOperation();
    }

    public void onButtonMul(View view) {
        this.setOperation("*");
    }

    public void onButtonDiv(View view) {
        this.setOperation("/");
    }

    public void onButtonPow(View view) {
        this.setOperation("^");
    }
}
