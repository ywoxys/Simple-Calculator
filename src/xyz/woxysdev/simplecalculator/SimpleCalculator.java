package xyz.woxysdev.simplecalculator;

import javax.swing.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleCalculatorGUI();
            }
        });
    }
}

