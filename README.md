# A multi-engine Calculator for two variables

It's a console app that lets you pick between a standard basic calculator and a scientific one with error handling so the app doesn't simple crash when a wrong input is inserted.

## What it does:
* **Basic Mode:** Add, subtract, multiply, divide, and square numbers.
* **Scientific Mode:** Powers, modulo (remainder), and roots.
* **Continuous Loop:** It asks if you want to do another calculation at the end so you don't have to restart the whole program every single time.
* **Counter:** Keeps track of how many successful calculations you did in one session.

## OOP Concepts Used:
* **Encapsulation (OOP V1.0 & V2.0):** Used the `private` access modifier for the `type` variable inside `Operation.java`, meaning it can only be safely accessed using the `getType()` getter method.
* **Inheritance (OOP V3.0):** Created an `abstract` parent class called `Operation`. The two specialized calculators (`Basic_calculator` and `Scientific_calculator`) inherit from it using the `extends` keyword.
* **The `final` Keyword (OOP V3.0 / V4.0):** Declared the `type` variable in the parent class as `final` (`private final String type;`) to lock its value, ensuring the engine's identity cannot be accidentally altered after instantiation.
* **Polymorphism (OOP V4.0):** * *Method Overriding:* Both child classes provide their own custom logic for the `.calculate(operator, num1, num2)` method.
  * *Method Overloading:* `Basic_calculator.java` has a second version of `.calculate()` that only takes two parameters, specifically used for single-number math (like squaring or square roots).
  * *Upcasting:* Stored the calculators in an `ArrayList<Operation>`, allowing the main program to treat both child engines as general `Operation` objects.
* **instanceof (OOP V4.0):** Used the `instanceof` operator in the main execution loop to safely verify the active object type at runtime.
* **Exception Handling (OOP V5.0):** * Created a custom checked exception called `invalidoperation` to stop impossible math (like dividing by zero).
  * Wrapped the main scanner loop in `Calculator.java` with a `try-catch-finally` block to catch bad inputs and gracefully reset without crashing the terminal.

## How to run it:
1. Clone or download the files.
2. Open the project in your IDE.
3. Find the `Calculator.java` file inside the `Main` package and run it.
4. Just follow the text prompts in the terminal!
