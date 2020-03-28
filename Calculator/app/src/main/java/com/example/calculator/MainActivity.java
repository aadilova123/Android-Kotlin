package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button sub;
    private Button mul;
    private Button add;
    private Button div;
    private Button equal;
    private Button decimal;
    private Button zero;
    private Button clear;
    private Button delete;
    private TextView info;
    private TextView result;
    private Button sqrroot;
    private final char ADDITION = '+';
    private final char SUBSTRACTION = '-';
    private final char MULTIPLICATION ='*';
    private final char DIVISION = '/';
    private final char EQUAL =0;
    private final char SQRROOT = '√';
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;
    private boolean isOppressed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViewes();
        zero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(info.getText().toString() + "9");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADDITION;
                result.setText(String.valueOf(val1) + "+");
                isOppressed = true;
                info.setText(null);

            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLICATION;
                result.setText(String.valueOf(val1) + "*");
                info.setText(null);
                isOppressed = true;

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBSTRACTION;
                result.setText(String.valueOf(val1) + "-");
                info.setText(null);
                isOppressed = true;

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVISION;
                result.setText(String.valueOf(val1) + "/");
                info.setText(null);
                isOppressed = true;

            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = EQUAL;
                result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                info.setText(null);
            }

        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence name = info.getText().toString();
                info.setText(name.subSequence(0, name.length()-1));
            }
        });


        sqrroot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SQRROOT;
                result.setText("√" + String.valueOf(val1));
                info.setText(null);
                isOppressed = true;

            }
        });

    }


    private void setupUIViewes() {
        zero = (Button)findViewById(R.id.zero) ;
        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two) ;
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four) ;
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six) ;
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight) ;
        nine = (Button)findViewById(R.id.nine);
        equal = (Button)findViewById(R.id.equalsign) ;
        decimal = (Button)findViewById(R.id.dec);
        sub = (Button)findViewById(R.id.substract) ;
        mul = (Button)findViewById(R.id.addition);
        div = (Button)findViewById(R.id.division) ;
        add = (Button)findViewById(R.id.multiply);
        info = (TextView) findViewById(R.id.textControl);
        result = (TextView) findViewById(R.id.textResult);
        clear = (Button)findViewById(R.id.clearall);
        delete= (Button) findViewById(R.id.delete);
        sqrroot=(Button) findViewById(R.id.sqrt);
    }

    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(info.getText().toString());
            switch (ACTION){
                case ADDITION:
                    val1 = val1+val2;
                    break;
                case SUBSTRACTION:
                    val1 = val1-val2;
                    break;
                case DIVISION:
                    val1 = val1/val2;
                    if(val2==0){
                        info.setText("We can't divide it!");
                    }
                    else
                    break;
                case MULTIPLICATION:
                    val1 = val1*val2;
                    break;
                case EQUAL:
                    break;
                case SQRROOT:
                    val1 = Math.sqrt(val1);
                    break;
            }
        }
        else {
            val1=Double.parseDouble(info.getText().toString());
        }
    }
}

