package GUI;

import Control.Calculator;

import javax.swing.*;
import java.awt.*;

public class calculator_gui extends JFrame {
    private JPanel buttons;
    private JPanel panel;
//    private JPanel show_Display;
    public static JTextField display;
//    String s1,s2,s0,s3,s4;
    protected JButton Button0 ;
    protected JButton Button1;
    protected JButton Button2;
    protected JButton Button3;
    protected JButton Button4;
    protected JButton Button5;
    protected JButton Button6;
    protected JButton Button7;
    protected JButton Button8;
    protected JButton Button9;
    protected JButton ButtonSum;
    protected JButton ButtonMinus;
    protected JButton ButtonTime;
    protected JButton ButtonDivide;
    protected JButton ButtonEqual;
    protected JButton ButtonDot;
    protected JButton ButtonSumOrMinus;
    protected JButton ButtonDelete;
    protected JButton ButtonDivideX;
    protected JButton ButtonC;
    protected JButton ButtonCE;
    protected JButton ButtonPercent;
    protected JButton ButtonXX;
    protected JButton ButtonSqrt;
    private Calculator calculate;

    private final int WINDOW_WIDTH = 300;
    private final int WINDOW_HEIGHT = 400;
    public calculator_gui() {
        buttons = new JPanel(new GridLayout(6,4));
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("Control.Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //buttons numbers
        Button0 = new JButton("0");
        Button1 = new JButton("1");
        Button2 = new JButton("2");
        Button3 = new JButton("3");
        Button4 = new JButton("4");
        Button5 = new JButton("5");
        Button6 = new JButton("6");
        Button7 = new JButton("7");
        Button8 = new JButton("8");
        Button9 = new JButton("9");

        //buttons operator
        ButtonSum = new JButton("+");
        ButtonMinus = new JButton("-");
        ButtonTime = new JButton("*");
        ButtonDivide = new JButton("/");
        ButtonEqual = new JButton("=");
        ButtonDot = new JButton(".");
        ButtonSumOrMinus = new JButton("+/-");
        ButtonPercent = new JButton("%");

        //buttons remove
        ButtonC = new JButton("C");
        ButtonCE = new JButton("CE");
        ButtonDelete = new JButton("Delete");


        //remaining buttons
        ButtonDivideX = new JButton("1/x");
        ButtonXX = new JButton("X^2");
        ButtonSqrt = new JButton("sqrt");


        //add buttons into panel
        //row 1
        buttons.add(ButtonPercent);
        buttons.add(ButtonCE);
        buttons.add(ButtonC);
        buttons.add(ButtonDelete);

        //row 2
        buttons.add(ButtonDivideX);
        buttons.add(ButtonXX);
        buttons.add(ButtonSqrt);
        buttons.add(ButtonDivide);

        //row 3
        buttons.add(Button7);
        buttons.add(Button8);
        buttons.add(Button9);
        buttons.add(ButtonTime);

        //row 4
        buttons.add(Button4);
        buttons.add(Button5);
        buttons.add(Button6);
        buttons.add(ButtonMinus);

        //row 5
        buttons.add(Button1);
        buttons.add(Button2);
        buttons.add(Button3);
        buttons.add(ButtonSum);

        //row  6
        buttons.add(ButtonSumOrMinus);
        buttons.add(Button0);
        buttons.add(ButtonDot);
        buttons.add(ButtonEqual);


        // set button into panel type matrix
        panel = new JPanel(new GridLayout(2,1));
        display = new JTextField();
        Font fo = new Font("Serif", Font.BOLD, 30);

        // set the font of the textField
        display.setFont(fo);
        display.setPreferredSize( new Dimension( 400, 100 ) );
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);

        //add textBox to panel
        panel.add(display);

        //add all buttons to panel
        panel.add(buttons);

        //add panel to window
        add(panel);
        calculate = new Calculator();
        //Set ActionListener buttons number
       getButton0().addActionListener(new Calculator.CalcButtonListener());
       getButton1().addActionListener(new Calculator.CalcButtonListener());
       getButton2().addActionListener(new Calculator.CalcButtonListener());
       getButton3().addActionListener(new Calculator.CalcButtonListener());
       getButton4().addActionListener(new Calculator.CalcButtonListener());
       getButton5().addActionListener(new Calculator.CalcButtonListener());
       getButton6().addActionListener(new Calculator.CalcButtonListener());
       getButton7().addActionListener(new Calculator.CalcButtonListener());
       getButton8().addActionListener(new Calculator.CalcButtonListener());
       getButton9().addActionListener(new Calculator.CalcButtonListener());

        //Set ActionListener buttons operator
       getButtonSum().addActionListener(new Calculator.CalcButtonListener());
       getButtonMinus().addActionListener(new Calculator.CalcButtonListener());
       getButtonTime().addActionListener(new Calculator.CalcButtonListener());
       getButtonDivide().addActionListener(new Calculator.CalcButtonListener());
       getButtonEqual().addActionListener(new Calculator.CalcButtonListener());
       getButtonDot().addActionListener(new Calculator.CalcButtonListener());
       getButtonSumOrMinus().addActionListener(new Calculator.CalcButtonListener());
       getButtonPercent().addActionListener(new Calculator.CalcButtonListener());

        //Set ActionListener buttons delete
        getButtonDelete().addActionListener(new Calculator.CalcButtonListener());
        getButtonC().addActionListener(new Calculator.CalcButtonListener());
        getButtonCE().addActionListener(new Calculator.CalcButtonListener());

        //Set ActionListener remaining buttons
        getButtonSqrt().addActionListener(new Calculator.CalcButtonListener());
        getButtonDivideX().addActionListener(new Calculator.CalcButtonListener());
        getButtonXX().addActionListener(new Calculator.CalcButtonListener());


        //important to run an application code java
        setVisible(true);
    }

    public JPanel getButtons() {
        return buttons;
    }

    public JPanel getPanel() {
        return panel;
    }

    public static JTextField getDisplay() {
        return display;
    }

    public JButton getButton0() {
        return Button0;
    }

    public JButton getButton1() {
        return Button1;
    }

    public JButton getButton2() {
        return Button2;
    }

    public JButton getButton3() {
        return Button3;
    }

    public JButton getButton4() {
        return Button4;
    }

    public JButton getButton5() {
        return Button5;
    }

    public JButton getButton6() {
        return Button6;
    }

    public JButton getButton7() {
        return Button7;
    }

    public JButton getButton8() {
        return Button8;
    }

    public JButton getButton9() {
        return Button9;
    }

    public JButton getButtonSum() {
        return ButtonSum;
    }

    public JButton getButtonMinus() {
        return ButtonMinus;
    }

    public JButton getButtonTime() {
        return ButtonTime;
    }

    public JButton getButtonDivide() {
        return ButtonDivide;
    }

    public JButton getButtonEqual() {
        return ButtonEqual;
    }

    public JButton getButtonDot() {
        return ButtonDot;
    }

    public JButton getButtonSumOrMinus() {
        return ButtonSumOrMinus;
    }

    public JButton getButtonDelete() {
        return ButtonDelete;
    }

    public JButton getButtonDivideX() {
        return ButtonDivideX;
    }

    public JButton getButtonC() {
        return ButtonC;
    }

    public JButton getButtonCE() {
        return ButtonCE;
    }

    public JButton getButtonPercent() {
        return ButtonPercent;
    }

    public JButton getButtonXX() {
        return ButtonXX;
    }

    public JButton getButtonSqrt() {
        return ButtonSqrt;
    }
}
