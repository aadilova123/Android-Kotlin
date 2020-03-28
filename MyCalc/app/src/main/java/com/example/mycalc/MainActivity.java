package com.example.mycalc;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.spec.ECField;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView Input;

    private Button buttonNumber1;
    private Button buttonNumber2;
    private Button buttonNumber3;
    private Button buttonNumber4;
    private Button buttonNumber5;
    private Button buttonNumber6;
    private Button buttonNumber7;
    private Button buttonNumber8;
    private Button buttonNumber9;
    private Button buttonNumber0;
    private Button buttonDot;


    private Button buttonPlus;
    private Button buttonEqual;
    private Button buttonMinus;
    private Button buttonMul;
    private Button buttonDiv;
    private Button buttonRoot;
    private Button buttonPOW;
    private Button buttonFACTORIAL;
    private Button buttonPERCENT;
    private Button buttonLog;
    private Button buttonSIN;
    private Button buttonCOS;
    private Button buttonTAN;
    private Button buttonClEAR;
    private Button buttonD;


    long factorial = 1;

    private void calcFactorial() {
        for (int i = 1; i <= number1; i++) {
            factorial = i * factorial;
        }
    }


    private double number1;
    private double number2;

    private double result2;
    private long resultFactorial;
    private String st = "Error";

    private double eq;
    private double dot;
    private double check;
    private boolean bug = false;


    enum Sign {
        PLUS, MINUS, MUL, DIV, POW
    }

    private Sign sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Input = findViewById(R.id.NumberInput);

        buttonNumber1 = findViewById(R.id.button1);
        buttonNumber2 = findViewById(R.id.button2);
        buttonNumber3 = findViewById(R.id.button3);
        buttonNumber4 = findViewById(R.id.button4);
        buttonNumber5 = findViewById(R.id.button5);
        buttonNumber6 = findViewById(R.id.button6);
        buttonNumber7 = findViewById(R.id.button7);
        buttonNumber8 = findViewById(R.id.button8);
        buttonNumber9 = findViewById(R.id.button9);
        buttonNumber0 = findViewById(R.id.button0);
        buttonDot = findViewById(R.id.buttonDot);
        buttonPlus = findViewById(R.id.Plus);
        buttonEqual = findViewById(R.id.Equal);
        buttonMinus = findViewById(R.id.Minus);
        buttonMul = findViewById(R.id.Mul);
        buttonDiv = findViewById(R.id.Div);
        buttonRoot = findViewById(R.id.ROOT);
        buttonPOW = findViewById(R.id.Pow);
        buttonFACTORIAL = findViewById(R.id.Factorial);
        buttonPERCENT = findViewById(R.id.percent);
        buttonLog = findViewById(R.id.log);
        buttonSIN = findViewById(R.id.sin);
        buttonCOS = findViewById(R.id.cos);
        buttonTAN = findViewById(R.id.tan);
        buttonClEAR = findViewById(R.id.Clear);
        buttonD = findViewById(R.id.Delete);
        buttonDot = findViewById(R.id.buttonDot);


        buttonNumber1.setOnClickListener(this);
        buttonNumber2.setOnClickListener(this);
        buttonNumber3.setOnClickListener(this);
        buttonNumber4.setOnClickListener(this);
        buttonNumber5.setOnClickListener(this);
        buttonNumber6.setOnClickListener(this);
        buttonNumber7.setOnClickListener(this);
        buttonNumber8.setOnClickListener(this);
        buttonNumber9.setOnClickListener(this);
        buttonNumber0.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonRoot.setOnClickListener(this);
        buttonPOW.setOnClickListener(this);
        buttonFACTORIAL.setOnClickListener(this);
        buttonPERCENT.setOnClickListener(this);
        buttonLog.setOnClickListener(this);
        buttonSIN.setOnClickListener(this);
        buttonCOS.setOnClickListener(this);
        buttonTAN.setOnClickListener(this);
        buttonClEAR.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        buttonDot.setOnClickListener(this);

        if (savedInstanceState != null) {
            number1 = savedInstanceState.getDouble("number1");
            number2 = savedInstanceState.getDouble("number2");
            result2 = savedInstanceState.getDouble("result2");
            Input.setText(savedInstanceState.getString("Input"));
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onSaveInstanceState(@Nullable Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Input", Input.getText().toString());
        outState.putDouble("number1", number1);
        outState.putDouble("number2", number2);
        outState.putDouble("result2", result2);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.getString("Input");
        savedInstanceState.getString("number1");
        savedInstanceState.getString("number2");
        savedInstanceState.getString("result2");

        Input.setText(String.valueOf(result2));
    }


    public void CheckLength() {
        if (Input.length() > 8) {
            check = 0;
        } else {
            check = 1;
        }
    }


    @Override
    public void onClick(View view) {
        CheckLength();
        switch (view.getId()) {
            case R.id.button1: {
                if (check == 1) {
                    if (Input.getText().toString().equals("Wrong")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("NaN")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("Infinity")) {
                        Input.setText("");
                    }
                    Input.append("1");
                }
                break;
            }
            case R.id.button2: {
                if (check == 1) {
                    if (Input.getText().toString().equals("Wrong")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("NaN")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("Infinity")) {
                        Input.setText("");
                    }
                    Input.append("2");
                }
                break;
            }
            case R.id.button3: {
                if (check == 1) {
                    if (Input.getText().toString().equals("Wrong")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("NaN")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("Infinity")) {
                        Input.setText("");
                    }
                    Input.append("3");
                }

                break;
            }
            case R.id.button4: {
                if (check == 1) {
                    if (Input.getText().toString().equals("Wrong")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("NaN")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("Infinity")) {
                        Input.setText("");
                    }
                    Input.append("4");
                }
                break;
            }
            case R.id.button5: {
                if (check == 1) {
                    if (Input.getText().toString().equals("Wrong")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("NaN")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("Infinity")) {
                        Input.setText("");
                    }
                    Input.append("5");
                }
                break;
            }
            case R.id.button6: {
                if (check == 1) {
                    if (Input.getText().toString().equals("Wrong")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("NaN")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("Infinity")) {
                        Input.setText("");
                    }
                    Input.append("6");
                }
                break;
            }
            case R.id.button7: {
                if (check == 1) {
                    if (Input.getText().toString().equals("Wrong")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("NaN")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("Infinity")) {
                        Input.setText("");
                    }
                    Input.append("7");
                }
                break;
            }
            case R.id.button8: {
                if (check == 1) {
                    if (Input.getText().toString().equals("Wrong")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("NaN")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("Infinity")) {
                        Input.setText("");
                    }
                    Input.append("8");
                }
                break;
            }
            case R.id.button9: {
                if (check == 1) {
                    if (Input.getText().toString().equals("Wrong")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("NaN")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("Infinity")) {
                        Input.setText("");
                    }
                    Input.append("9");
                }
                break;
            }
            case R.id.button0: {
                if (check == 1) {
                    if (Input.getText().toString().equals("Wrong")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("NaN")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("Infinity")) {
                        Input.setText("");
                    }
                    Input.append("0");
                }
                break;
            }

            case R.id.buttonDot: {
                if (dot != 1) {
                    if (Input.getText().toString().equals("Wrong")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("NaN")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("Infinity")) {
                        Input.setText("");
                    }
                    Input.append(".");
                    dot = 1;
                }
                break;
            }
            case R.id.Delete: {
                if (Input.getText().toString().equals("Wrong")) {
                    Input.setText("");
                }
                if (Input.length() < 1 || eq == 1) {
                    break;
                }

                Input.setText(Input.getText().toString().substring(0, Input.getText().toString().length() - 1));
                break;
            }

            case R.id.Clear: {
                Input.setText("");
                break;
            }


            case R.id.Plus: {
                if (Input.getText().toString().equals("Wrong")) {
                    Input.setText("");
                }
                if (Input.length() < 1 || eq == 1) {
                    break;
                }
                if (dot == 1) {
                    Input.append("0");
                }
                dot = 0;
                number1 = Double.parseDouble(Input.getText().toString());
                Input.setText("");
                sign = Sign.PLUS;
                break;
            }
            case R.id.Minus: {
                if (Input.getText().toString().equals("Wrong")) {
                    Input.setText("");
                }
                if (Input.length() < 1 || eq == 1) {
                    break;
                }
                if (dot == 1) {
                    Input.append("0");
                }
                dot = 0;
                number1 = Double.parseDouble(Input.getText().toString());
                Input.setText("");
                sign = Sign.MINUS;
                break;
            }
            case R.id.Mul: {
                if (Input.getText().toString().equals("Wrong")) {
                    Input.setText("");
                }
                if (Input.length() < 1 || eq == 1) {
                    break;
                }
                if (dot == 1) {
                    Input.append("0");
                }
                dot = 0;
                number1 = Double.parseDouble(Input.getText().toString());
                Input.setText("");
                sign = Sign.MUL;
                break;
            }
            case R.id.Div: {
                if (Input.getText().toString().equals("Wrong")) {
                    Input.setText("");
                }
                if (Input.length() < 1 || eq == 1) {
                    break;
                }
                eq = 0;
                if (dot == 1) {
                    Input.append("0");
                }
                dot = 0;
                number1 = Double.parseDouble(Input.getText().toString());
                Input.setText("");
                sign = Sign.DIV;
                break;

            }
            case R.id.ROOT: {
                if (Input.getText().toString().equals("Wrong")) {
                    Input.setText("");
                }
                if (Input.length() < 1 || eq == 1) {
                    break;
                }
                dot = 0;
                number1 = Double.parseDouble(Input.getText().toString());
                if (number1 < 0) {
                    Input.setText("Wrong");
                    break;
                }
                number1 = Math.sqrt(number1);
                if ((number1 == Math.floor(number1)) && !Double.isInfinite(number1)) {
                    Input.setText(String.valueOf((int) (number1)));
                } else {
                    Input.setText(String.valueOf((Math.floor((number1) * 1000000)) / (1000000)));
                }
                break;
            }
            case R.id.Pow: {
                if (Input.getText().toString().equals("Wrong")) {
                    Input.setText("");
                }
                if (Input.length() < 1 || eq == 1) {
                    break;
                }
                dot = 0;
                number1 = Double.parseDouble(Input.getText().toString());
                Input.setText("");
                sign = Sign.POW;
                break;
            }
            case R.id.Factorial: {
                if (Input.getText().toString().equals("Wrong")) {
                    Input.setText("");
                }
                if (Input.length() < 1 || eq == 1) {
                    break;
                }
                dot = 0;
                number1 = Double.parseDouble(Input.getText().toString());
                calcFactorial();
                resultFactorial = factorial;
                Input.setText(String.valueOf(resultFactorial));
                break;
            }
            case R.id.percent: {
                if (Input.getText().toString().equals("Wrong")) {
                    Input.setText("");
                }
                if (Input.length() < 1 || eq == 1) {
                    break;
                }
                dot = 0;
                number1 = Double.parseDouble(Input.getText().toString());
                result2 = number1 / 100;
                Input.setText(String.valueOf(result2));
                break;
            }
            case R.id.log: {
                if (Input.getText().toString().equals("Wrong")) {
                    Input.setText("");
                }
                if (Input.length() < 1 || eq == 1) {
                    break;
                }
                dot = 0;
                number1 = Double.parseDouble(Input.getText().toString());
                result2 = Math.log(number1);
                Input.setText(String.valueOf(result2));
                break;
            }
            case R.id.sin: {
                if (Input.getText().toString().equals("Wrong")) {
                    Input.setText("");
                }
                if (Input.length() < 1 || eq == 1) {
                    break;
                }
                dot = 0;
                number1 = Double.parseDouble(Input.getText().toString());

                result2 = Math.sin(Math.toRadians(number1));
                Input.setText(String.valueOf(result2));
                break;

            }

            case R.id.cos: {
                if (Input.getText().toString().equals("Wrong")) {
                    Input.setText("");
                }
                if (Input.length() < 1 || eq == 1) {
                    break;
                }
                dot = 0;
                number1 = Double.parseDouble(Input.getText().toString());

                result2 = Math.cos(Math.toRadians(number1));
                Input.setText(String.valueOf(result2));
                break;
            }
            case R.id.tan: {
                if (Input.getText().toString().equals("Wrong")) {
                    Input.setText("");
                }
                if (Input.length() < 1 || eq == 1) {
                    break;
                }
                dot = 0;
                number1 = Double.parseDouble(Input.getText().toString());

                result2 = Math.tan(Math.toRadians(number1));
                Input.setText(String.valueOf(result2));
                break;
            }

            case R.id.Equal: {
                if (Input.getText().toString().equals("Wrong")) {
                    Input.setText("");
                    break;
                }
                if (dot == 1) {
                    Input.append("0");
                }
                dot = 0;
                if (Input.length() < 1 || eq == 1) {
                    eq = 0;
                    break;
                }
                eq = 0;
                number2 = Double.parseDouble(Input.getText().toString());


                if (sign == Sign.PLUS) {
                    result2 = number1 + number2;
                } else if (sign == Sign.MINUS) {
                    result2 = number1 - number2;
                } else if (sign == Sign.MUL) {
                    result2 = number1 * number2;
                } else if (sign == Sign.POW) {
                    result2 = Math.pow(number1, number2);
                } else if (sign == Sign.DIV) {
                    result2 = number1 / number2;
                }
                if ((result2 == Math.floor(result2)) && !Double.isInfinite(result2)) {
                    Input.setText(String.valueOf((int) result2));
                    if (Input.getText().toString().equals("NaN")) {
                        Input.setText("");
                    } else if (Input.getText().toString().equals("Infinity")) {
                        Input.setText("");
                    }
                } else {
                    Input.setText(String.valueOf((Math.floor(result2 * 1000000)) / (1000000)));
                }
                break;

            }

        }
    }
}