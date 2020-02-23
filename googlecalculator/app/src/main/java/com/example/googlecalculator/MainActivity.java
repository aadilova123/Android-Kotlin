package com.example.googlecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textContent;

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;

    private Button clear;
    private Button delete;
    private Button root;
    private Button square;
    private Button divide;
    private Button add;
    private Button minus;
    private Button multiply;
    private Button percent;
    private Button equal;;
    private Button sin;
    private Button cos;
    private Button tan;
    private Button ln;
    private Button log;
    private Button nroot;
    private Button buttonFactorial;
    private Button powerN;
    private Button dott;
    private Button pi;



    private double dotCount = 0;
    private double number1;
    private double number2;
    private double result;
    private long resultFactorial;
    private int value = 0;



    enum Sign {
        PLUS, MINUS, MUL, DIV, NPOW, NROOT
    }

    private Sign sign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle", "onCreate");

        setupUIViews();

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        delete.setOnClickListener(this);
        add.setOnClickListener(this);
        divide.setOnClickListener(this);
        root.setOnClickListener(this);
        square.setOnClickListener(this);
        multiply.setOnClickListener(this);
        dott.setOnClickListener(this);
        percent.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        ln.setOnClickListener(this);
        log.setOnClickListener(this);
        nroot.setOnClickListener(this);
        buttonFactorial.setOnClickListener(this);
        powerN.setOnClickListener(this);
        equal.setOnClickListener(this);
        clear.setOnClickListener(this);
        minus.setOnClickListener(this);
        pi.setOnClickListener(this);

        if (savedInstanceState != null && savedInstanceState.containsKey("NumberInput"))
            textContent.setText(savedInstanceState.getString("NumberInput"));

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "onStart");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putString("NumberInput", textContent.getText().toString());
        saveInstanceState.putDouble("number1", number1);
        saveInstanceState.putDouble("number2", number2);
        saveInstanceState.putDouble("result2", result);
        saveInstanceState.putSerializable("enum", sign);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        number1 = savedInstanceState.getDouble("number1");
        number2 = savedInstanceState.getDouble("number2");
        result = savedInstanceState.getDouble("result2");
        sign = (Sign)savedInstanceState.getSerializable("enum");

    }

    private void setupUIViews() {
        one = findViewById(R.id.btn1);
        two = findViewById(R.id.btn2);
        three = findViewById(R.id.btn3);
        four = findViewById(R.id.btn4);
        five = findViewById(R.id.btn5);
        six = findViewById(R.id.btn6);
        seven = findViewById(R.id.btn7);
        eight = findViewById(R.id.btn8);
        nine = findViewById(R.id.btn9);
        zero = findViewById(R.id.btn0);
        clear = findViewById(R.id.btn_c);
        delete = findViewById(R.id.btn_del);
        root = findViewById(R.id.btn_root);
        square = findViewById(R.id.btn_square);
        divide = findViewById(R.id.btn_divide);
        add = findViewById(R.id.btn_plus);
        minus = findViewById(R.id.btn_minus);
        multiply = findViewById(R.id.btn_multiply);
        equal = findViewById(R.id.btn_equal);
        dott = findViewById(R.id.btn_dot);
        textContent = findViewById(R.id.calcText);
        percent = findViewById(R.id.btn_percent);
        sin = findViewById(R.id.btn_sin);
        cos = findViewById(R.id.btn_cos);
        tan = findViewById(R.id.btn_tan);
        ln = findViewById(R.id.btn_ln);
        log = findViewById(R.id.btn_log);
        nroot = findViewById(R.id.btn_nroot);
        buttonFactorial = findViewById(R.id.btn_factorial);
        powerN = findViewById(R.id.btn_powern);
        pi = findViewById(R.id.btn_pi);

    }

    long factorial = 1;
    private void calcFactorial(){
        for(int i = 1; i<=number1; i++){
            factorial = i * factorial;
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1: {
                if (textContent.getText().toString().equals("Error"))
                    textContent.setText(null);
                if (textContent.getText().toString().length() == 1 && textContent.getText().toString().contains("0")) {
                    textContent.setText(null);
                }
                textContent.append("1");
                break;
            }


            case R.id.btn2: {
                if (textContent.getText().toString().equals("Error"))
                    textContent.setText(null);

                if (textContent.getText().toString().length() == 1 && textContent.getText().toString().contains("0")) {
                    textContent.setText(null);
                }
                textContent.append("2");
                break;
            }


            case R.id.btn3: {
                if (textContent.getText().toString().equals("Error"))
                    textContent.setText(null);

                if (textContent.getText().toString().length() == 1 && textContent.getText().toString().contains("0")) {
                    textContent.setText(null);
                }
                textContent.append("3");
                break;
            }

            case R.id.btn4: {
                if (textContent.getText().toString().equals("Error"))
                    textContent.setText(null);

                if (textContent.getText().toString().length() == 1 && textContent.getText().toString().contains("0")) {
                    textContent.setText(null);
                }
                textContent.append("q");
                break;
            }

            case R.id.btn5: {
                if (textContent.getText().toString().equals("Error"))
                    textContent.setText(null);
                if (textContent.getText().toString().length() == 1 && textContent.getText().toString().contains("0")) {
                    textContent.setText(null);
                }
                textContent.append("5");
                break;
            }


            case R.id.btn6: {
                if (textContent.getText().toString().equals("Error"))
                    textContent.setText(null);
                if (textContent.getText().toString().length() == 1 && textContent.getText().toString().contains("0")) {
                    textContent.setText(null);
                }
                textContent.append("6");

                break;
            }

            case R.id.btn7: {
                if (textContent.getText().toString().equals("Error"))
                    textContent.setText(null);
                if (textContent.getText().toString().length() == 1 && textContent.getText().toString().contains("0")) {
                    textContent.setText(null);
                }
                textContent.append("7");
                break;
            }
            case R.id.btn8: {
                if (textContent.getText().toString().equals("Error"))
                    textContent.setText(null);
                if (textContent.getText().toString().length() == 1 && textContent.getText().toString().contains("0")) {
                    textContent.setText(null);
                }
                textContent.append("8");
                break;
            }

            case R.id.btn9: {
                if (textContent.getText().toString().equals("Error"))
                    textContent.setText(null);
                if (textContent.getText().toString().length() == 1 && textContent.getText().toString().contains("0")) {
                    textContent.setText(null);
                }
                textContent.append("9");
                break;
            }
            case R.id.btn0: {
                if (textContent.getText().toString().equals("Error"))
                    textContent.setText(null);
                if (textContent.getText().toString().length() == 0 && dotCount != 1)
                    textContent.setText("");
                if (textContent.getText().toString().length() == 1 && textContent.getText().toString().contains("0")) {
                    textContent.setText("");
                }
                textContent.append("0");
                break;
            }


            case R.id.btn_dot: {
                if (textContent.getText().toString().equals("Error"))
                    textContent.setText(null);
                if (textContent.getText().toString().length() == 0) {
                    textContent.setText("0.");
                }
                if (textContent.getText().toString().contains("."))
                    dotCount = 1;
                else
                    textContent.append(".");
                dotCount = 1;
                break;
            }

            case R.id.btn_del: {
                if (textContent.getText().toString().equals("Error")) {
                    textContent.setText("");
                }
                if (textContent.length() == 0) {
                    textContent.setText(" ");
                }

                textContent.setText(textContent.getText().toString().substring(0, textContent.getText().toString().length() - 1));
                break;
            }

            case R.id.btn_c: {
                textContent.setText(null);
                break;
            }


            case R.id.btn_plus: {
                if (textContent.getText().toString().equals("Error")) {
                    textContent.setText("");
                }
                try {

                    number1 = Double.parseDouble(textContent.getText().toString());

                } catch (NumberFormatException e) {
                    textContent.setText("Error");
                }
                dotCount = 0;
                textContent.setText("");
                sign = Sign.PLUS;
                break;
            }


            case R.id.btn_minus: {
                if (textContent.getText().toString().equals("Error")) {
                    textContent.setText("");
                }
                try {

                    number1 = Double.parseDouble(textContent.getText().toString());

                } catch (NumberFormatException e) {
                    textContent.setText("Error");
                }
                dotCount = 0;
                textContent.setText("");
                sign = Sign.MINUS;
                break;
            }


            case R.id.btn_multiply: {
                if (textContent.getText().toString().equals("Error")) {
                    textContent.setText("");
                }
                try {
                    number1 = Double.parseDouble(textContent.getText().toString());
                } catch (NumberFormatException e) {
                    textContent.setText("Error");
                }
                value = 3;
                dotCount = 0;
                textContent.setText(null);
                sign = Sign.MUL;
                break;
            }

            case R.id.btn_divide: {
                if (textContent.getText().toString().equals("Error")) {
                    textContent.setText("");
                }
                try {

                    number1 = Double.parseDouble(textContent.getText().toString());

                } catch (NumberFormatException e) {
                    textContent.setText("Error");

                }
                value = 4;
                dotCount = 0;
                textContent.setText("");
                sign = Sign.DIV;
                break;
            }

            case R.id.btn_root: {
                if (textContent.getText().toString().equals("Error")) {
                    textContent.setText("");
                }
                if (textContent.getText().toString().length() < 1)
                    break;
                try {
                    number1 = Double.parseDouble(textContent.getText().toString());

                } catch (NumberFormatException e) {
                    textContent.setText("Error");
                }
                number1 = Math.sqrt(number1);

                textContent.setText(String.valueOf((number1)));
                break;

            }

            case R.id.btn_sin: {
                if (textContent.getText().toString().equals("Error")) {
                    textContent.setText("");
                }
                if (textContent.getText().toString().length() < 1) {
                    break;
                }
                try {
                    number1 = Double.parseDouble(textContent.getText().toString());

                } catch (NumberFormatException e) {
                    textContent.setText("Error");
                }
                dotCount = 0;
                result = Math.sin(Math.toRadians(number1));
                textContent.setText(String.valueOf(result));
                break;
            }

            case R.id.btn_cos: {
                if (textContent.getText().toString().equals("Error")) {
                    textContent.setText("");
                }
                if (textContent.getText().toString().length() < 1) {
                    break;
                }
                try {

                    number1 = Double.parseDouble(textContent.getText().toString());

                } catch (NumberFormatException e) {
                    textContent.setText("Error");
                }
                dotCount = 0;
                result = Math.cos(Math.toRadians(number1));
                textContent.setText(String.valueOf(result));
                break;
            }

            case R.id.btn_tan: {
                if (textContent.getText().toString().equals("Error")) {
                    textContent.setText("");
                }
                if (textContent.getText().toString().length() < 1) {
                    break;
                }
                try {
                    number1 = Double.parseDouble(textContent.getText().toString());

                } catch (NumberFormatException e) {
                    textContent.setText("Error");
                }
                dotCount = 0;
                result = Math.tan(Math.toRadians(number1));
                textContent.setText(String.valueOf(result));
                break;
            }

            case R.id.btn_ln: {
                if (textContent.getText().toString().equals("Error")) {
                    textContent.setText("");
                }
                if (textContent.getText().toString().length() < 1) {
                    break;
                }
                if (textContent.getText().toString().contains("0") && textContent.getText().toString().length() == 1) {
                    textContent.setText("Error");
                    break;
                }
                try {
                    number1 = Double.parseDouble(textContent.getText().toString());

                } catch (NumberFormatException e) {
                    textContent.setText("Error");
                }
                dotCount = 0;
                result = Math.log(number1);
                textContent.setText(String.valueOf(result));
                break;
            }

            case R.id.btn_log: {
                if (textContent.getText().toString().equals("Error")) {
                    textContent.setText("");
                }
                if (textContent.getText().toString().contains("0") && textContent.getText().toString().length() == 1) {
                    textContent.setText("Error");
                    break;
                }
                if (textContent.getText().toString().length() < 1) {
                    break;
                }
                try {
                    number1 = Double.parseDouble(textContent.getText().toString());

                } catch (NumberFormatException e) {
                    textContent.setText("Error");
                }
                dotCount = 0;
                result = Math.log10(number1);
                textContent.setText(String.valueOf(result));
                break;
            }

            case R.id.btn_nroot: {
                if (textContent.getText().toString().equals("Error")) {
                    textContent.setText("");
                }
                if (textContent.getText().toString().length() < 1) {
                    break;
                }
                try {

                    number1 = Double.parseDouble(textContent.getText().toString());

                } catch (NumberFormatException e) {
                    textContent.setText("Error");
                }
                dotCount = 0;
                textContent.setText("");
                sign = Sign.NROOT;
                break;
            }

            case R.id.btn_powern: {
                if (textContent.getText().toString().equals("Error")) {
                    textContent.setText("");
                }
                if (textContent.getText().toString().length() < 1) {
                    break;
                }
                try {

                    number1 = Double.parseDouble(textContent.getText().toString());

                } catch (NumberFormatException e) {
                    textContent.setText("Error");
                }
                dotCount = 0;
                textContent.setText("");
                sign = Sign.NPOW;
                break;
            }

            case R.id.btn_factorial: {
                if (textContent.getText().toString().equals("Error")) {
                    textContent.setText("");
                }
                if (textContent.getText().toString().length() < 1) {
                    break;
                }
                try {

                    number1 = Double.parseDouble(textContent.getText().toString());

                } catch (NumberFormatException e) {
                    textContent.setText("Error");
                }
                dotCount = 0;
                calcFactorial();
                resultFactorial = factorial;
                textContent.setText(String.valueOf(resultFactorial));
                break;
            }


            case R.id.btn_square: {
                if (textContent.getText().toString().equals("Error")) {
                    textContent.setText("");
                }
                if (textContent.getText().toString().length() == 0) {
                    textContent.setText("");
                }
                try {

                    number1 = Double.parseDouble(textContent.getText().toString());

                } catch (NumberFormatException e) {
                    textContent.setText("Error");
                }
                dotCount = 0;
                result = Math.pow(number1, 2);
                textContent.setText(String.valueOf(Math.pow(number1, 2)));
                break;
            }
            case R.id.btn_pi: {
                if (textContent.getText().toString().equals("Error"))
                    textContent.setText(null);
                if (textContent.getText().toString().length() == 1 && textContent.getText().toString().contains("0")) {
                    textContent.setText(null);
                }
                result = Math.PI;
                textContent.append(String.valueOf(result));
                break;
            }
            case R.id.btn_percent: {
                if (textContent.getText().toString().equals("Error")) {
                    textContent.setText("");
                    break;
                }
                if (textContent.getText().toString().length() < 1) {
                    break;
                }
                try {
                    number1 = Double.parseDouble(textContent.getText().toString());

                } catch (NumberFormatException e) {
                    textContent.setText("Error");
                }
                dotCount = 0;
                textContent.setText(String.valueOf(number1 / 100));
                break;
            }

            case R.id.btn_equal: {
                if(textContent.getText().toString().equals("Error")){
                    break;
                }
                if(textContent.getText().toString().length() == 0){
                    break;
                }
                number2 = Double.parseDouble(textContent.getText().toString());

                if (sign == sign.PLUS) {
                    result = number1 + number2;
                    textContent.setText(String.valueOf(result));
                }
                if (sign == sign.MINUS) {
                    result = number1 - number2;
                    textContent.setText(String.valueOf(result));
                }
                if (sign == sign.MUL) {
                    result = number1 * number2;
                    textContent.setText(String.valueOf(result));
                }
                if (sign == sign.DIV) {
                    if (number2 == 0) {
                        textContent.setText(String.valueOf("Error"));
                        number1 = 0;
                    } else {
                        result = number1 / number2;
                        textContent.setText(String.valueOf(result));
                    }
                }
                if (sign == Sign.NROOT) {
                    result = Math.pow(number1, 1 / number2);
                    textContent.setText(String.valueOf(result));
                } else if (sign == Sign.NPOW) {
                    result = Math.pow(number1, number2);
                    textContent.setText(String.valueOf(result));
                }
            }
        }
    }
}
