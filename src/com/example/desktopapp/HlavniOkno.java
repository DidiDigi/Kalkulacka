
package com.example.desktopapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

public class HlavniOkno extends JFrame {

    private Double clen1 = 0.0;
    private Double clen2 = 0.0;
    private Double result = 0.0;
    private int operace = 0;
    private boolean bylVypocitanVysledek = true;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JMenuBar menuBar;
    JMenu menuEdit;
    JMenu menuView;
    JMenu menuHelp;
    JTextField editResult;
    JTextField editEmpty;
    JButton btnBackspace;
    JButton btnCE;
    JButton btnC;
    JButton btnMC;
    JButton btn7;
    JButton btn8;
    JButton btn9;
    JButton btnDivide;
    JButton btnSqrt;
    JButton btnMR;
    JButton btn4;
    JButton btn5;
    JButton btn6;
    JButton btnMulti;
    JButton btnPercentage;
    JButton btnMS;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btnMinus;
    JButton btnInverse;
    JButton btnMPlus;
    JButton btn0;
    JButton btnPlusMinus;
    JButton btnComma;
    JButton btnPlus;
    JButton btnEqual;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;

    public HlavniOkno() {
        initComponents();
    }

    private void priStiskuBtn0(ActionEvent e) {
        zapisZnak("0");
    }

    private void priStiskuBtn1(ActionEvent e) {
        zapisZnak("1");
    }

    private void priStiskuBtn2(ActionEvent e) {
        zapisZnak("2");
    }

    private void priStiskuBtn3(ActionEvent e) {
        zapisZnak("3");
    }

    private void priStiskuBtn4(ActionEvent e) {
        zapisZnak("4");
    }

    private void priStiskuBtn5(ActionEvent e) {
        zapisZnak("5");
    }

    private void priStiskuBtn6(ActionEvent e) {
        zapisZnak("6");
    }

    private void priStiskuBtn7(ActionEvent e) {
        zapisZnak("7");
    }

    private void priStiskuBtn8(ActionEvent e) {
        zapisZnak("8");
    }

    private void priStiskuBtn9(ActionEvent e) {
        zapisZnak("9");
    }

    private void priStiskuBtnComma(ActionEvent e) {
        zapisZnak(".");
    }

    private void zapisZnak(String znak) {
        String result = editResult.getText();

        if (bylVypocitanVysledek) {
            result = "0";
            bylVypocitanVysledek = false;
        }

        //když už řetězec obsahuje desetinnou čárku, tak nemůžu přidat další
        if (znak.equals(".") && result.contains(".")) {
           return;
        }

        //když jako první znak zapisuju desetinnou čárku, tak nechci mazat první nulu
        if (result.equals("0") && znak.equals(".")) {
            editResult.setText(result + znak);
            return;
        }

        // když zapisuju první číslici, tak chci smazat první nulu
        if (result.equals("0")) {
            editResult.setText(znak);
        }
        else {
            editResult.setText(result + znak);
        }
    }

    private void priStiskuBtnCE(ActionEvent e) {
        deleteResult();
        clen1 = 0.0;
        clen2 = 0.0;
        result = 0.0;
        operace = 0;
    }

    private void deleteResult () {
        editResult.setText("0");
    }

    private void priStiskuBtnPlus(ActionEvent e) {
        zapisOperaci(1);
        zapisClen();
    }

    private void priStiskuBtnMinus(ActionEvent e) {
        zapisOperaci(2);
        zapisClen();
    }

    private void priStiskuBtnDivide(ActionEvent e) {
        zapisOperaci(4);
        zapisClen();
    }
    private void priStiskuBtnMulti(ActionEvent e) {
        zapisOperaci(3);
        zapisClen();
    }

    private void zapisClen() {
       if (clen1 == 0.0) {
           clen1 = Double.parseDouble(editResult.getText());
       }
       else {
           clen2 = Double.parseDouble(editResult.getText());
       }

       deleteResult();
    }

    private void zapisOperaci(int operace){
        //když se zadá 1+1 a namísto = se opět zadá +, musím provést předchozí operaci
        if (clen1 != 0.0 && clen2 != 0.0) {
            spocitejVysledek();
            editResult.setText(result.toString());
            clen1 = result;
            clen2 = 0.0;
            this.operace = 0;
        }
        this.operace = operace;
    }

    private void spocitejVysledek () {
        switch (operace) {
            case 1: result = clen1+clen2;
                break;
            case 2:  result = clen1-clen2;
                break;
            case 3:  result = clen1*clen2;
                break;
            case 4:  result = clen1/clen2;
                break;
            default:
                break;
        }
        
    }

    private void priStiskuBtnEqual(ActionEvent e) {
        zapisClen();
        if (operace == 0) {

        }
        else {
            spocitejVysledek();
            editResult.setText(result.toString());
            bylVypocitanVysledek = true;
            clen1 = 0.0;
            clen2 = 0.0;
            operace = 0;
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        menuBar = new JMenuBar();
        menuEdit = new JMenu();
        menuView = new JMenu();
        menuHelp = new JMenu();
        editResult = new JTextField();
        editEmpty = new JTextField();
        btnBackspace = new JButton();
        btnCE = new JButton();
        btnC = new JButton();
        btnMC = new JButton();
        btn7 = new JButton();
        btn8 = new JButton();
        btn9 = new JButton();
        btnDivide = new JButton();
        btnSqrt = new JButton();
        btnMR = new JButton();
        btn4 = new JButton();
        btn5 = new JButton();
        btn6 = new JButton();
        btnMulti = new JButton();
        btnPercentage = new JButton();
        btnMS = new JButton();
        btn1 = new JButton();
        btn2 = new JButton();
        btn3 = new JButton();
        btnMinus = new JButton();
        btnInverse = new JButton();
        btnMPlus = new JButton();
        btn0 = new JButton();
        btnPlusMinus = new JButton();
        btnComma = new JButton();
        btnPlus = new JButton();
        btnEqual = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kalkulacka");
        setMinimumSize(null);
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets panel,hidemode 3,gap 2 2",
            // columns
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]",
            // rows
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]" +
            "[grow,sizegroup 1,fill]0"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());

        //======== menuBar ========
        {

            //======== menuEdit ========
            {
                menuEdit.setText("Edit");
            }
            menuBar.add(menuEdit);

            //======== menuView ========
            {
                menuView.setText("View");
            }
            menuBar.add(menuView);

            //======== menuHelp ========
            {
                menuHelp.setText("Help");
            }
            menuBar.add(menuHelp);
        }
        setJMenuBar(menuBar);

        //---- editResult ----
        editResult.setFont(editResult.getFont().deriveFont(editResult.getFont().getSize() + 15f));
        editResult.setText("0");
        editResult.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(editResult, "cell 0 0 18 1");

        //---- editEmpty ----
        editEmpty.setEditable(false);
        contentPane.add(editEmpty, "cell 0 1 3 1");

        //---- btnBackspace ----
        btnBackspace.setText("<--");
        btnBackspace.setForeground(Color.red);
        contentPane.add(btnBackspace, "cell 3 1 5 1");

        //---- btnCE ----
        btnCE.setText("CE");
        btnCE.setForeground(Color.red);
        btnCE.addActionListener(e -> priStiskuBtnCE(e));
        contentPane.add(btnCE, "cell 8 1 5 1");

        //---- btnC ----
        btnC.setText("C");
        btnC.setForeground(Color.red);
        contentPane.add(btnC, "cell 13 1 5 1");

        //---- btnMC ----
        btnMC.setText("MC");
        btnMC.setForeground(Color.red);
        contentPane.add(btnMC, "cell 0 2 3 1");

        //---- btn7 ----
        btn7.setText("7");
        btn7.setForeground(Color.blue);
        btn7.addActionListener(e -> priStiskuBtn7(e));
        contentPane.add(btn7, "cell 3 2 3 1");

        //---- btn8 ----
        btn8.setText("8");
        btn8.setForeground(Color.blue);
        btn8.addActionListener(e -> priStiskuBtn8(e));
        contentPane.add(btn8, "cell 6 2 3 1");

        //---- btn9 ----
        btn9.setText("9");
        btn9.setForeground(Color.blue);
        btn9.addActionListener(e -> priStiskuBtn9(e));
        contentPane.add(btn9, "cell 9 2 3 1");

        //---- btnDivide ----
        btnDivide.setText("/");
        btnDivide.setForeground(Color.red);
        btnDivide.addActionListener(e -> priStiskuBtnDivide(e));
        contentPane.add(btnDivide, "cell 12 2 3 1");

        //---- btnSqrt ----
        btnSqrt.setText("sqrt");
        btnSqrt.setForeground(Color.blue);
        contentPane.add(btnSqrt, "cell 15 2 3 1");

        //---- btnMR ----
        btnMR.setText("MR");
        btnMR.setForeground(Color.red);
        contentPane.add(btnMR, "cell 0 3 3 1");

        //---- btn4 ----
        btn4.setText("4");
        btn4.setForeground(Color.blue);
        btn4.addActionListener(e -> priStiskuBtn4(e));
        contentPane.add(btn4, "cell 3 3 3 1");

        //---- btn5 ----
        btn5.setText("5");
        btn5.setForeground(Color.blue);
        btn5.addActionListener(e -> priStiskuBtn5(e));
        contentPane.add(btn5, "cell 6 3 3 1");

        //---- btn6 ----
        btn6.setText("6");
        btn6.setForeground(Color.blue);
        btn6.addActionListener(e -> priStiskuBtn6(e));
        contentPane.add(btn6, "cell 9 3 3 1");

        //---- btnMulti ----
        btnMulti.setText("*");
        btnMulti.setForeground(Color.red);
        btnMulti.addActionListener(e -> priStiskuBtnMulti(e));
        contentPane.add(btnMulti, "cell 12 3 3 1");

        //---- btnPercentage ----
        btnPercentage.setText("%");
        btnPercentage.setForeground(Color.blue);
        contentPane.add(btnPercentage, "cell 15 3 3 1");

        //---- btnMS ----
        btnMS.setText("MS");
        btnMS.setForeground(Color.red);
        contentPane.add(btnMS, "cell 0 4 3 1");

        //---- btn1 ----
        btn1.setText("1");
        btn1.setForeground(Color.blue);
        btn1.addActionListener(e -> priStiskuBtn1(e));
        contentPane.add(btn1, "cell 3 4 3 1");

        //---- btn2 ----
        btn2.setText("2");
        btn2.setForeground(Color.blue);
        btn2.addActionListener(e -> priStiskuBtn2(e));
        contentPane.add(btn2, "cell 6 4 3 1");

        //---- btn3 ----
        btn3.setText("3");
        btn3.setForeground(Color.blue);
        btn3.addActionListener(e -> priStiskuBtn3(e));
        contentPane.add(btn3, "cell 9 4 3 1");

        //---- btnMinus ----
        btnMinus.setText("-");
        btnMinus.setForeground(Color.red);
        btnMinus.addActionListener(e -> priStiskuBtnMinus(e));
        contentPane.add(btnMinus, "cell 12 4 3 1");

        //---- btnInverse ----
        btnInverse.setText("1/x");
        btnInverse.setForeground(Color.blue);
        contentPane.add(btnInverse, "cell 15 4 3 1");

        //---- btnMPlus ----
        btnMPlus.setText("M+");
        btnMPlus.setForeground(Color.red);
        contentPane.add(btnMPlus, "cell 0 5 3 1");

        //---- btn0 ----
        btn0.setText("0");
        btn0.setForeground(Color.blue);
        btn0.addActionListener(e -> priStiskuBtn0(e));
        contentPane.add(btn0, "cell 3 5 3 1");

        //---- btnPlusMinus ----
        btnPlusMinus.setText("+/-");
        btnPlusMinus.setForeground(Color.blue);
        contentPane.add(btnPlusMinus, "cell 6 5 3 1");

        //---- btnComma ----
        btnComma.setText(",");
        btnComma.setForeground(Color.blue);
        btnComma.addActionListener(e -> priStiskuBtnComma(e));
        contentPane.add(btnComma, "cell 9 5 3 1");

        //---- btnPlus ----
        btnPlus.setText("+");
        btnPlus.setForeground(Color.red);
        btnPlus.addActionListener(e -> priStiskuBtnPlus(e));
        contentPane.add(btnPlus, "cell 12 5 3 1");

        //---- btnEqual ----
        btnEqual.setText("=");
        btnEqual.setForeground(Color.red);
        btnEqual.addActionListener(e -> priStiskuBtnEqual(e));
        contentPane.add(btnEqual, "cell 15 5 3 1");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
