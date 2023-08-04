package xyz.woxysdev.simplecalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculatorGUI extends JFrame implements ActionListener {
    private JTextField display;
    private String currentNumber;
    private CalculatorLogic calculatorLogic;

    public SimpleCalculatorGUI() {
        currentNumber = "";
        calculatorLogic = new CalculatorLogic();

        setTitle("Calculadora Simples");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(this);
            buttonsPanel.add(button);
        }

        add(buttonsPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("=")) {
            calculatorLogic.performOperation(command, currentNumber);
            display.setText(String.valueOf(calculatorLogic.getResult()));
            currentNumber = "";
        } else if (command.matches("[0-9.]")) {
            currentNumber += command;
            display.setText(currentNumber);
        } else if (command.matches("[+\\-*/]")) {
            calculatorLogic.performOperation(command, currentNumber);
            currentNumber = "";
        }
    }
}

