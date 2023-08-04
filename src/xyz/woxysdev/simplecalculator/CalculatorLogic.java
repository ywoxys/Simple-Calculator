package xyz.woxysdev.simplecalculator;

public class CalculatorLogic {
    private double result;
    private String operator;

    public CalculatorLogic() {
        result = 0;
        operator = "";
    }

    public void performOperation(String command, String currentNumber) {
        if (command.equals("=")) {
            double num2 = Double.parseDouble(currentNumber);
            switch (operator) {
                case "+":
                    result += num2;
                    break;
                case "-":
                    result -= num2;
                    break;
                case "*":
                    result *= num2;
                    break;
                case "/":
                    result /= num2;
                    break;
            }
        } else if (command.matches("[+\\-*/]")) {
            if (!currentNumber.isEmpty()) {
                result = Double.parseDouble(currentNumber);
            }
            operator = command;
        }
    }

    public double getResult() {
        return result;
    }
}

