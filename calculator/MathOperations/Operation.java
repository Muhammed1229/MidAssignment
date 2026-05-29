//the class with the rules the child classes will inherit from
package calculator.MathOperations;
import calculator.Invalid.invalidoperation;

public abstract class Operation {
    private final String type;
    protected static int totalcalculations = 0;
    // 
    public Operation (String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
    //static counter to show how many successful calculations have been completed
    public static void displayCount () {
        IO.println ("Total Number of Successful Calculations Run: " + totalcalculations);
    }
    // method to be inherited and get overriden or overloaded by child classes
    public abstract double calculate (char operator, double num1, double num2) throws invalidoperation;
}