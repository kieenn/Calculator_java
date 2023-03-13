package Control;

import GUI.calculator_gui;

import Console.Console_Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculator {

    static String s1;
    static String s2;
    static String s0;
    static String s3;
    String s4;



    public Calculator() {

        s1 = s2 = s0 = s3 = s4 = "";

    }


    //add ActionListener to buttons
    public static class CalcButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();

            //Check value of button, if value form 0 to 9 or Dot(.) return true
            if (s.charAt(0) >= '0' && s.charAt(0) <= '9' && s != "1/x" || s.charAt(0) == '.') {
                if (!s1.equals("")) {
                    s2 += s;
                } else {
                    s0 += s;
                }
                s3 = s0 + s1 + s2;
                calculator_gui.getDisplay().setText(s3);
            }
            //check value of buttons, if value type of delete return true
            else if (s.charAt(0) == 'C' || s == "CE" || s == "Delete") {
                if (s.charAt(0) == 'C' && s != "CE") {
                    s0 = s1 = s2 = s3 = "";
                    calculator_gui.getDisplay().setText(s3);

                }
                if (s == "Delete") {
                    int length = s3.length();
                    int equal = 0;
                    int operators = 0;
                    int index = 0;
                    for (int i = 0; i < length; i++) {
                        if (s3.charAt(i) == '=') {
                            equal++;
                            index = i;
                        }
//                        if (s3.charAt(i) == '+' || s3.charAt(i) == '-' || s3.charAt(i) == '*' || s3.charAt(i) == '/') {
//                            operators++;
//                        }
                    }
                    if (equal > 0) {
                        s3 = s3.substring(index + 1, s3.length());
                        s2 = "";
                        s1 = "";
                    } else if (!s2.equals("")) {
                        s3 = "";
                        if (s2.length() > 0) {
                            s2 = s2.substring(0, s2.length() - 1);
                        }
                        s3 = s0 + s1 + s2;
                    } else if (s1.equals("") && s2.equals("")) {
                        if (s0.length() > 0) {
                            s0 = s0.substring(0, s0.length() - 1);
                        }
                        s3 = s0 + s1 + s2;
                    }
                    calculator_gui.getDisplay().setText(s3);

                }
                if (s == "CE") {
                    //int length = s3.length();
                    int equal = OperatorEqual(s3);

//                    for (int i = 0; i < length; i++) {
//                        if (s3.charAt(i) == '=') {
//                            equal++;
//                        }
//                    }
                    if (!s2.equals("") && equal < 1) {
                        s2 = "";
                        s3 = s0 + s1 + s2;
                    } else if (s1.equals("") && s2.equals("")) {
                        s0 = "";
                        s3 = s0 + s1 + s2;
                    } else if (equal > 0) {
                        s0 = s1 = s2 = s3 = "";
                    }
                    s3 = s0 + s1 + s2;
                    calculator_gui.getDisplay().setText(s3);

                }
            }
            //check value of buttons, if value == '=' return true
            else if (s.charAt(0) == '=') {

                double result = check();

                s3 = s0 + s1 + s2 + "=" + result;
                calculator_gui.getDisplay().setText(s3);
                s0 = Double.toString(result);

            }
            //check value of buttons, if value == '%' return true
            else if (s.charAt(0) == '%') {

                Percent();

            }
            //check value of buttons, if value == "1/x" return true
            else if (s == "1/x") {
                DivideX();
            }
            //check value of buttons, if value == "X^2" return true
            else if (s == "X^2") {
                XX();
            }
            //check value of buttons, if value == "sqrt" return true
            else if (s == "sqrt") {
                Sqrt();

            }
            //check value of buttons, if value == "+/- return true
            else if (s == "+/-") {
                SumOrMinus();
            }
            //check value of buttons, if value == '+' or '-' or '*' or '/' return true
            else {
                if (s1.equals("") && s2.equals("")) {
                    if (s0.equals("")) {
                        s0 += s;
                    } else s1 = s;

                } else {
                    int equal = 0;
                    int length = s3.length();
                    for (int i = 0; i < length; i++) {
                        if (s3.charAt(i) == '=') {
                            equal++;
                        }
                    }
                    if (equal <= 0) {
                        double result;

                        result = check();

                        s0 = Double.toString(result);
                    }
                    s1 = s;
                    s2 = "";

                }
                s3 = s0 + s1 + s2;
                calculator_gui.getDisplay().setText(s3);
            }
        }

        //count how many equal operator in String

        private double check() {
            if (s0.equals("")) {
                s0 = "0";
            }
            if (s2.equals("")) {
                s2 = "0";
            }
            double result;
            if (s1.equals("+")) {
                result = Console_Calculator.Sum(s0,s2);
            } else if (s1.equals("-")) {
                result = Console_Calculator.Minus(s0,s2);
            } else if (s1.equals("*")) {
                result = Console_Calculator.Time(s0,s2);
            } else if (s1.equals("/")) {
                result = Console_Calculator.Divide(s0,s2);
            } else {
                result = Console_Calculator.Sum(s0,s2);
            }
            if (s0.equals("0")) {
                s0 = "";
            }
            if (s2.equals("0")) {
                s2 = "";
            }
            return result;
        }
    }

    private static void Percent() {
        int equal1 = OperatorEqual(s3);
        if (s1.equals("") && s2.equals("")) {
            double percent = Console_Calculator.percent(s0);

            s3 = s0 + s1 + s2 + '%' + '=' + percent;
            calculator_gui.getDisplay().setText(s3);
            s0 = Double.toString(percent);
        } else if (equal1 > 0) {
            double percent = Console_Calculator.percent(s0);

            s1 = s2 = "";
            s3 = s0 + s1 + s2 + '%' + '=' + percent;
            calculator_gui.getDisplay().setText(s3);
            s0 = Double.toString(percent);
        }
        if (!s1.equals("") && !s2.equals("")) {
            double percent = Console_Calculator.percent(s2);

            s3 = s0 + s1 + s2 + '%';
            s2 = Double.toString(percent);
            calculator_gui.getDisplay().setText(s3);

        }
    }

    private static void XX() {
        int equal1 = OperatorEqual(s3);


        if (s1.equals("") && s2.equals("")) {
            double result = Console_Calculator.XX(s0);

            s3 = s0 + s1 + s2 + "^2" + '=' + result;
            calculator_gui.getDisplay().setText(s3);
            s0 = Double.toString(result);
        } else if (equal1 > 0) {
            double result = Console_Calculator.XX(s0);

            s1 = s2 = "";
            s3 = s0 + s1 + s2 + "^2" + '=' + result;
            calculator_gui.getDisplay().setText(s3);
            s0 = Double.toString(result);
        }
        if (!s1.equals("") && !s2.equals("")) {
            double result = Console_Calculator.XX(s2);

            s3 = s0 + s1 + "(" + s2 + "^2)";
            s2 = Double.toString(result);
            calculator_gui.getDisplay().setText(s3);

        }
    }

    private static void Sqrt() {
        int equal1 = OperatorEqual(s3);

        if (s1.equals("") && s2.equals("")) {
            double result = Console_Calculator.sqrt(s0);

            s3 = "sqrt(" + s0 + s1 + s2 + ")=" + result;
            calculator_gui.getDisplay().setText(s3);
            s0 = Double.toString(result);
        } else if (equal1 > 0) {
            double result = Console_Calculator.sqrt(s0);

            s1 = s2 = "";
            s3 = "sqrt(" + s0 + s1 + s2 + ")=" + result;
            calculator_gui.getDisplay().setText(s3);
            s0 = Double.toString(result);
        }
        if (!s1.equals("") && !s2.equals("")) {
            double result = Console_Calculator.sqrt(s2);

            s3 = s0 + s1 + "sqrt(" + s2 + ")";
            s2 = Double.toString(result);
            calculator_gui.getDisplay().setText(s3);

        }
    }

    private static void DivideX() {
        //                int length1 = s3.length();
        int equal1 = OperatorEqual(s3);


        if (s1.equals("") && s2.equals("")) {
            double result = Console_Calculator.DivideX(s0);

            s3 = 1 + "/" + s0 + s1 + s2 + '=' + result;
            calculator_gui.getDisplay().setText(s3);
            s0 = Double.toString(result);
        } else if (equal1 > 0) {
            double result = Console_Calculator.DivideX(s0);

            s1 = s2 = "";
            s3 = 1 + "/" + s0 + s1 + s2 + '=' + result;
            calculator_gui.getDisplay().setText(s3);
            s0 = Double.toString(result);
        }
        if (!s1.equals("") && !s2.equals("")) {
            double result = Console_Calculator.DivideX(s2);

            s3 = s0 + s1 + "(1/" + s2 + ")";
            s2 = Double.toString(result);
            calculator_gui.getDisplay().setText(s3);

        }
    }

    private static void SumOrMinus() {
        int equal1 = OperatorEqual(s3);


        if (s1.equals("") && s2.equals("")) {
            double result = Console_Calculator.PlusOrMinus(s0);



            s3 = result + "";
            calculator_gui.getDisplay().setText(s3);
            s0 = Double.toString(result);
        } else if (equal1 > 0) {
            double result = Console_Calculator.DivideX(s0);

            s1 = s2 = "";
            s3 = result + "";
            calculator_gui.getDisplay().setText(s3);
            s0 = Double.toString(result);
        }
        if (!s1.equals("") && !s2.equals("")) {
            double result = Console_Calculator.DivideX(s2);

            s3 = s0 + s1 + result;
            s2 = Double.toString(result);
            calculator_gui.getDisplay().setText(s3);

        }
    }

    private static int OperatorEqual(String s) {
        int length = s.length();
        int equals = 0;

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '=') {
                equals++;
            }
        }
        return equals;
    }


}