package calculator.MathOperations;
import calculator.Invalid.invalidoperation;

public class Scientific_calculator extends Operation {
    public Scientific_calculator () {
        super ("Advanced Mode");
    }
    // method overriding: to calculate the sqaure and root of two numbers as well as to calculate the modulo
    // where the first number is the base and the second number is the exponent/index respectively
    @Override
    public double calculate(char operator, double num1, double num2) throws invalidoperation { 
    totalcalculations++; //total calculation incremented by 1 for every successful calculation
        
        
        switch (operator) {
            case '^' -> {
                return Math.pow(num1, num2);
            }
            case '%' -> {
                return num1 % num2;
            }
            case 'v' -> {
                return Math.pow(num1, 1.0/num2);
            }
            default -> throw new invalidoperation ("Error: '" + operator + "' is not an Advanced/Scientific Operator.");
        }
    }
}

