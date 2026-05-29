// the basic calculator with the basic operations
package calculator.MathOperations;
import calculator.Invalid.invalidoperation;

public class Basic_calculator extends Operation{
    public Basic_calculator () {
        super ("Standard Mode");
    }
    // method overriding: to calculate the basic arthimetic operations (+, -, *, /)
    @Override
    public double calculate (char operator, double num1, double num2) throws invalidoperation {
        totalcalculations ++;
        switch (operator) {
            case '+' -> {
                return num1 + num2;
                }
            case '-' -> {
                return num1 - num2;
                }
            case '*' -> {
                return num1 * num2;
                }
            case '/' -> {
                if (num2 == 0) {
                    throw new invalidoperation ("Error: Division by Zero is Undefined.");
                }
                return num1 /num2;
                }
            default -> throw new invalidoperation("Error: '" + operator + "' is not a Standard Operator.");
        }
    }
    // method overloading: the same method name but accepts 2 parameters instead of 3 
    // to calculate the square or square root of a single number
    public double calculate(char operator, double num1) throws invalidoperation {
        totalcalculations++; //total calculation incremented by 1 for every successful calculation
        
        switch (operator) {
            case 'S', 's' -> {
                return num1 * num1;
            }
            case 'R', 'r' -> {
                return Math.sqrt(num1);
            }
            default -> throw new invalidoperation ("Error: '" + operator + "' is an Invalid Single Number Operator.");
        }
    }
}