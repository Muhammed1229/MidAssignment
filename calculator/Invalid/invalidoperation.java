// custom exception message to be inherited by child classes
package calculator.Invalid;

public class invalidoperation extends Exception {
    public invalidoperation (String message) {
        super (message);
    }
}