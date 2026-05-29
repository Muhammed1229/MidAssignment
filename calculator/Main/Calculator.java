//the main class that will get the Calculator running
package calculator.Main;
import calculator.Invalid.invalidoperation;
import calculator.MathOperations.Basic_calculator;
import calculator.MathOperations.Operation;
import calculator.MathOperations.Scientific_calculator;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    public static void main () {
        // scanner object to accept input
        Scanner scanner = new Scanner (System.in);
        boolean wantstocontinue = true;
        
        // an arraylist to store engines
        ArrayList<Operation> engines = new ArrayList<>();
        engines.add(new Basic_calculator());       
        engines.add(new Scientific_calculator());

        // just a for loop to print 50 empty spaces so the console looks clean at the start
        for (int i = 1; i <= 50; i++) {
            IO.println(""); 
        }

        IO.println("=== Welcome to the Multi-Engine Calculator ===");
        // a loop to keep the calculator running as long as the user wants wrapped around an Exception handling for smooth flow
        while (wantstocontinue) {
        // prompt to choose calculator engine
        try {
        IO.println("\nAvailable Calculator Engines: [0] Basic Mode  |  [1] Scientific Mode");
        IO.print("Select Operational Engine: ");

        int choice =scanner.nextInt ();
        // shows an error message if engine chosen is less than 0 or greater than or equal to the number of items in the arraylist
        // adapts if number of engines is increased later on 
        if (choice < 0 || choice >= engines.size()) {
            IO.println("\nInvalid Engine Selected. Please Select from the Available Engines");
            continue;
        }
        // if correct engine is chosen, shows which mode it is in and the list of operators available in that mode
        Operation activeEngine = engines.get(choice);
        IO.println("\nActive Engine: " + activeEngine.getType());

        if (activeEngine instanceof Scientific_calculator) {
            IO.println ("\n==Advanced Operations Enabled==");
            IO.println ("\n==List of Operators==");
            IO.println ("'^' To Calculate Power (First Number = Base, Second Number = Exponent)");
            IO.println ("'%' for Modulo");
            IO.println ("'v' To Calculate the Radical Root (First Number = Base, Second Number = Index)");
        }
        if (activeEngine instanceof Basic_calculator) {
            IO.println("\n==Basic Operations Enabled==");
            IO.println ("\n==List of Operators==");
            IO.println ("'+' for Addition");
            IO.println ("'-' for Subtraction");
            IO.println ("'*' for Multiplication");
            IO.println ("'/' for Division");
            IO.println ("'S' or 's' for Squaring ONE Number");
            IO.println ("'R' or 'r' to Find the Square Root of ONE Number");
        }
        //prompt to insert numeric values and operator of choice
            IO.print("\nEnter First Numeric Value: ");
            double n1 = scanner.nextDouble();
            IO.print("Enter Operator Symbol: ");
            char op = scanner.next().charAt(0);
            // if else block to check if a 2 parameter method is used to give the output before asking for a 3rd parameter
            if ((op == 'S' || op == 's') && activeEngine instanceof Basic_calculator) {
                Basic_calculator standardEngine = (Basic_calculator) activeEngine;
                double squareOutput = standardEngine.calculate(op, n1);
                IO.println("The Square of the Number is = " + squareOutput);
            }
            else if (op == 'R' || op == 'r' && activeEngine instanceof Basic_calculator) {
                Basic_calculator standardEngine = (Basic_calculator) activeEngine;
                double rootOutput = standardEngine.calculate(op, n1);
                IO.println("The Square Root of the Number is = " + rootOutput);
            }
            // if the operator isn't an R or and S it prompts to ask the user for a 3rd operator
            else {
                IO.print("Enter Second Numeric Value: ");
                double n2 = scanner.nextDouble();

                double calculationOutput = activeEngine.calculate(op, n1, n2);
                IO.println("Calculation Output = " + calculationOutput);
            }
        } 
        // error handling for different types of errors
        catch (invalidoperation e) {
            IO.println("\nProcessing Failure: " + e.getMessage());
        } 
        catch (Exception generalException) {
            IO.println("\nInput Failure: Invalid Input Entered.");
        } 
        // will always print when operations are done or when the calculator stops when an error is detected
        finally {
            scanner.nextLine();
            IO.println("\n------------------------------------------------");
            IO.println("Calculation Completed.");
        }   
        // prompt asking the user if they want to restart the calculator or stop it
            IO.print ("\nDo you want to Restart the Calculator (Y/N): ");
            String response = scanner.nextLine().toUpperCase().trim();
            if (response.isEmpty() || response.charAt (0) != 'Y') {
                wantstocontinue = false;
                IO.println ("Closing Calculator");
                Operation.displayCount();
                scanner.close();
            } 
            else {
                wantstocontinue = true;
            }
        }
    }
}