package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declare variables
    TextView resultText;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnClear, btnPlusMinus, btnPercent, btnDivide;
    Button btnMultiply, btnMinus, btnPlus, btnEqual, btnDot;

    // Scientific calculator buttons
    Button btnPower, btnSquare, btnCube, btnLog, btnFactorial;
    Button btnSqrt, btnCubeRoot, btnOpenBracket, btnCloseBracket;
    Button btnSin, btnCos, btnTan, btnE, btnPi, btnRad;

    // For calculations
    double firstNum = 0;
    double secondNum = 0;
    String operation = "";
    boolean isNewOperation = true;
    boolean isRadMode = true; // Default to radian mode

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect variables to UI elements
        resultText = findViewById(R.id.resultText);

        // Basic calculator buttons
        btn0 = findViewById(R.id.zero);
        btn1 = findViewById(R.id.one);
        btn2 = findViewById(R.id.two);
        btn3 = findViewById(R.id.three);
        btn4 = findViewById(R.id.four);
        btn5 = findViewById(R.id.five);
        btn6 = findViewById(R.id.six);
        btn7 = findViewById(R.id.seven);
        btn8 = findViewById(R.id.eight);
        btn9 = findViewById(R.id.nine);

        btnDot = findViewById(R.id.dot);
        btnClear = findViewById(R.id.clear);
        btnPlusMinus = findViewById(R.id.Pm);
        btnPercent = findViewById(R.id.per);

        btnDivide = findViewById(R.id.div);
        btnMultiply = findViewById(R.id.multiply);
        btnMinus = findViewById(R.id.min);
        btnPlus = findViewById(R.id.plus);
        btnEqual = findViewById(R.id.equal);

        // Set up number button click listeners
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("9");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = resultText.getText().toString();
                // Only add decimal if there isn't one already
                if (!currentText.contains(".")) {
                    numberClick(".");
                }
            }
        });

        // Set up operation button click listeners
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationClick("+");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationClick("-");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationClick("×");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operationClick("÷");
            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double number = Double.parseDouble(resultText.getText().toString());
                    double result = number / 100;
                    resultText.setText(formatResult(result));
                    isNewOperation = true;
                } catch (Exception e) {
                    resultText.setText("Error");
                }
            }
        });

        btnPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double number = Double.parseDouble(resultText.getText().toString());
                    number = number * -1;
                    resultText.setText(formatResult(number));
                } catch (Exception e) {
                    resultText.setText("Error");
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText("0");
                firstNum = 0;
                secondNum = 0;
                operation = "";
                isNewOperation = true;
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });

        // Try to set up scientific calculator functions (wrapped in try-catch to handle layout differences)
        try {
            // Power, square, cube
            btnPower = findViewById(R.id.power);
            btnSquare = findViewById(R.id.sqr);
            btnCube = findViewById(R.id.qube);

            // Log, factorial, sqrt
            btnLog = findViewById(R.id.log);
            btnFactorial = findViewById(R.id.fect);
            btnSqrt = findViewById(R.id.sqrt);

            // Cube root, brackets
            btnCubeRoot = findViewById(R.id.qubert);
            btnOpenBracket = findViewById(R.id.bo);
            btnCloseBracket = findViewById(R.id.bc);

            // Trig functions
            btnSin = findViewById(R.id.sin);
            btnCos = findViewById(R.id.cos);
            btnTan = findViewById(R.id.tan);

            // Constants and mode
            btnE = findViewById(R.id.e);
            btnPi = findViewById(R.id.pi);
            btnRad = findViewById(R.id.rad);

            // Set up scientific button click listeners
            if (btnPower != null) {
                btnPower.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        operationClick("^");
                    }
                });
            }

            if (btnSquare != null) {
                btnSquare.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            double number = Double.parseDouble(resultText.getText().toString());
                            double result = number * number;
                            resultText.setText(formatResult(result));
                            isNewOperation = true;
                        } catch (Exception e) {
                            resultText.setText("Error");
                        }
                    }
                });
            }

            if (btnCube != null) {
                btnCube.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            double number = Double.parseDouble(resultText.getText().toString());
                            double result = number * number * number;
                            resultText.setText(formatResult(result));
                            isNewOperation = true;
                        } catch (Exception e) {
                            resultText.setText("Error");
                        }
                    }
                });
            }

            if (btnLog != null) {
                btnLog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            double number = Double.parseDouble(resultText.getText().toString());
                            if (number <= 0) {
                                resultText.setText("Error");
                                return;
                            }
                            double result = Math.log10(number);
                            resultText.setText(formatResult(result));
                            isNewOperation = true;
                        } catch (Exception e) {
                            resultText.setText("Error");
                        }
                    }
                });
            }

            if (btnFactorial != null) {
                btnFactorial.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            double number = Double.parseDouble(resultText.getText().toString());
                            int n = (int) number;
                            if (n != number || n < 0) {
                                resultText.setText("Error");
                                return;
                            }
                            long factorial = 1;
                            for (int i = 1; i <= n; i++) {
                                factorial *= i;
                                if (factorial < 0) { // Overflow check
                                    resultText.setText("Error");
                                    return;
                                }
                            }
                            resultText.setText(formatResult((double) factorial));
                            isNewOperation = true;
                        } catch (Exception e) {
                            resultText.setText("Error");
                        }
                    }
                });
            }

            if (btnSqrt != null) {
                btnSqrt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            double number = Double.parseDouble(resultText.getText().toString());
                            if (number < 0) {
                                resultText.setText("Error");
                                return;
                            }
                            double result = Math.sqrt(number);
                            resultText.setText(formatResult(result));
                            isNewOperation = true;
                        } catch (Exception e) {
                            resultText.setText("Error");
                        }
                    }
                });
            }

            if (btnCubeRoot != null) {
                btnCubeRoot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            double number = Double.parseDouble(resultText.getText().toString());
                            double result = Math.cbrt(number);
                            resultText.setText(formatResult(result));
                            isNewOperation = true;
                        } catch (Exception e) {
                            resultText.setText("Error");
                        }
                    }
                });
            }

            if (btnOpenBracket != null) {
                btnOpenBracket.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // For a real calculator app, we'd need to implement expression parsing
                        // This is a simplified version
                        resultText.setText("(");
                        isNewOperation = false;
                    }
                });
            }

            if (btnCloseBracket != null) {
                btnCloseBracket.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // For a real calculator app, we'd need to implement expression parsing
                        // This is a simplified version
                        String currentText = resultText.getText().toString();
                        if (!currentText.equals("0") && !currentText.equals("(")) {
                            resultText.setText(currentText + ")");
                        }
                    }
                });
            }

            if (btnSin != null) {
                btnSin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            double number = Double.parseDouble(resultText.getText().toString());
                            double result;
                            if (isRadMode) {
                                result = Math.sin(number);
                            } else {
                                result = Math.sin(Math.toRadians(number));
                            }
                            resultText.setText(formatResult(result));
                            isNewOperation = true;
                        } catch (Exception e) {
                            resultText.setText("Error");
                        }
                    }
                });
            }

            if (btnCos != null) {
                btnCos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            double number = Double.parseDouble(resultText.getText().toString());
                            double result;
                            if (isRadMode) {
                                result = Math.cos(number);
                            } else {
                                result = Math.cos(Math.toRadians(number));
                            }
                            resultText.setText(formatResult(result));
                            isNewOperation = true;
                        } catch (Exception e) {
                            resultText.setText("Error");
                        }
                    }
                });
            }

            if (btnTan != null) {
                btnTan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            double number = Double.parseDouble(resultText.getText().toString());
                            double result;
                            if (isRadMode) {
                                result = Math.tan(number);
                            } else {
                                result = Math.tan(Math.toRadians(number));
                            }
                            resultText.setText(formatResult(result));
                            isNewOperation = true;
                        } catch (Exception e) {
                            resultText.setText("Error");
                        }
                    }
                });
            }

            if (btnE != null) {
                btnE.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resultText.setText(formatResult(Math.E));
                        isNewOperation = true;
                    }
                });
            }

            if (btnPi != null) {
                btnPi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resultText.setText(formatResult(Math.PI));
                        isNewOperation = true;
                    }
                });
            }

            if (btnRad != null) {
                btnRad.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        isRadMode = !isRadMode;
                        if (isRadMode) {
                            btnRad.setText("Rad");
                        } else {
                            btnRad.setText("Deg");
                        }
                    }
                });
            }

        } catch (Exception e) {
            // If any button is not found (i.e., using the basic layout), this catch block will prevent a crash
        }
    }

    // Method to handle number button clicks
    private void numberClick(String digit) {
        String currentText = resultText.getText().toString();

        if (isNewOperation) {
            resultText.setText(digit);
            isNewOperation = false;
        } else {
            // Check if current display is just "0" and the new digit isn't a decimal
            if (currentText.equals("0") && !digit.equals(".")) {
                resultText.setText(digit);
            } else {
                resultText.setText(currentText + digit);
            }
        }
    }

    // Method to handle operation button clicks
    private void operationClick(String op) {
        try {
            firstNum = Double.parseDouble(resultText.getText().toString());
            operation = op;
            isNewOperation = true;
        } catch (Exception e) {
            resultText.setText("Error");
        }
    }

    // Method to perform calculation
    private void calculateResult() {
        try {
            secondNum = Double.parseDouble(resultText.getText().toString());
            double result = 0;

            switch (operation) {
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                case "×":
                    result = firstNum * secondNum;
                    break;
                case "÷":
                    // Check for division by zero
                    if (secondNum == 0) {
                        resultText.setText("Error");
                        return;
                    }
                    result = firstNum / secondNum;
                    break;
                case "^":
                    result = Math.pow(firstNum, secondNum);
                    break;
                default:
                    // If no operation selected, just keep the current number
                    result = secondNum;
                    break;
            }

            resultText.setText(formatResult(result));
            firstNum = result;
            isNewOperation = true;

        } catch (Exception e) {
            resultText.setText("Error");
        }
    }

    // Helper method to format results nicely
    private String formatResult(double result) {
        // If result is a whole number, don't show decimal part
        if (result == (int) result) {
            return String.valueOf((int) result);
        } else {
            // For very small numbers close to zero that result from floating point errors
            if (Math.abs(result) < 1e-10) {
                return "0";
            }
            return String.valueOf(result);
        }
    }
}