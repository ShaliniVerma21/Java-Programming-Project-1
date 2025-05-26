package Scientific_Calculator;

import java.util.Scanner;

public class ScientificCalculator {

    private Scanner scanner;

    // Constructor: Initializes the scanner and welcomes the user
    public ScientificCalculator() {
        scanner = new Scanner(System.in);
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("\t\t\t Scientific Calculator");
        System.out.println("----------------------------------------------------------------\n");
    }

    // Method: Displays menu options for the user
    public void displayMenu() {
        System.out.println("\nPlease select an operation:");
        System.out.println("----------------------------------------------------------------");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Square Root (√)");
        System.out.println("6. Power (x^y)");
        System.out.println("7. Sine (sin)");
        System.out.println("8. Cosine (cos)");
        System.out.println("9. Tangent (tan)");
        System.out.println("10. Logarithm (log base 10)");
        System.out.println("11. Natural Logarithm (ln)");
        System.out.println("12. Factorial (!)");
        System.out.println("13. Exponential (e^x)");
        System.out.println("14. Absolute Value (|x|)");
        System.out.println("15. Exit");
        System.out.println("----------------------------------------------------------------");
    }

    // Method to get a double input value from the user
    public double getDoubleInput(String prompt) {
        return getInput(prompt, true);
    }

    // Method to get an integer input value from the user
    public int getIntInput(String prompt) {
        return (int) getInput(prompt, false);
    }

    // Generic method to get input from the user
    private double getInput(String prompt, boolean isDouble) {
        double num;
        while (true) {
            System.out.print(prompt);
            if (isDouble ? scanner.hasNextDouble() : scanner.hasNextInt()) {
                num = isDouble ? scanner.nextDouble() : scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid " + (isDouble ? "number" : "integer") + ".\n");
                scanner.nextLine(); // Clear invalid input
            }
        }
        return num;
    }

    // Arithmetic operation methods
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is undefined.");
            return Double.NaN;
        }
        return a / b;
    }

    // Scientific operations
    public double sqrt(double a) {
        if (a < 0) {
            System.out.println("Error: Cannot compute square root of a negative number.");
            return Double.NaN;
        }
        return Math.sqrt(a);
    }

    public double power(double a, double b) {
        return Math.pow(a, b);
    }

    public double sine(double degrees) {
        return Math.sin(Math.toRadians(degrees));
    }

    public double cosine(double degrees) {
        return Math.cos(Math.toRadians(degrees));
    }

    public double tangent(double degrees) {
        return Math.tan(Math.toRadians(degrees));
    }

    public double logarithm(double a) {
        if (a <= 0) {
            System.out.println("Error: Logarithm undefined for zero or negative values.");
            return Double.NaN;
        }
        return Math.log10(a);
    }

    public double naturalLog(double a) {
        if (a <= 0) {
            System.out.println("Error: Natural logarithm undefined for zero or negative values.");
            return Double.NaN;
        }
        return Math.log(a);
    }

    // New methods for additional functionalities
    public double factorial(int n) {
        if (n < 0) {
            System.out.println("Error: Factorial is not defined for negative numbers.");
            return Double.NaN;
        }
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public double exponential(double x) {
        return Math.exp(x);
    }

    public double absoluteValue(double x) {
        return Math.abs(x);
    }

    // Main loop to run the calculator
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice (1-15): ");

            double num1, num2, result;
            switch (choice) {
                case 1: // Addition
                    num1 = getDoubleInput("Enter first number: ");
                    num2 = getDoubleInput("Enter second number: ");
                    result = add(num1, num2);
                    displayResult(num1, num2, result, "+");
                    break;
                case 2: // Subtraction
                    num1 = getDoubleInput("Enter first number: ");
                    num2 = getDoubleInput("Enter second number: ");
                    result = subtract(num1, num2);
                    displayResult(num1, num2, result, "-");
                    break;
                case 3: // Multiplication
                    num1 = getDoubleInput("Enter first number: ");
                    num2 = getDoubleInput("Enter second number: ");
                    result = multiply(num1, num2);
                    displayResult(num1, num2, result, "*");
                    break;
                case 4: // Division
                    num1 = getDoubleInput("Enter numerator: ");
                    num2 = getDoubleInput("Enter denominator: ");
                    result = divide(num1, num2);
                    if (!Double.isNaN(result)) {
                        displayResult(num1, num2, result, "/");
                    }
                    break;
                case 5: // Square root
                    num1 = getDoubleInput("Enter a number: ");
                    result = sqrt(num1);
                    if (!Double.isNaN(result)) {
                        System.out.printf("√%f = %f\n\n", num1, result);
                    }
                    break;
                case 6: // Power
                    num1 = getDoubleInput("Enter the base number: ");
                    num2 = getDoubleInput("Enter the exponent: ");
                    result = power(num1, num2);
                    System.out.printf("%f ^ %f = %f\n\n", num1, num2, result);
                    break;
                case 7: // Sine
                    num1 = getDoubleInput("Enter angle in degrees: ");
                    result = sine(num1);
                    System.out.printf("sin(%f°) = %f\n\n", num1, result);
                    break;
                case 8: // Cosine
                    num1 = getDoubleInput("Enter angle in degrees: ");
                    result = cosine(num1);
                    System.out.printf("cos(%f°) = %f\n\n", num1, result);
                    break;
                case 9: // Tangent
                    num1 = getDoubleInput("Enter angle in degrees: ");
                    result = tangent(num1);
                    System.out.printf("tan(%f°) = %f\n\n", num1, result);
                    break;
                case 10: // Logarithm base 10
                    num1 = getDoubleInput("Enter a number: ");
                    result = logarithm(num1);
                    if (!Double.isNaN(result)) {
                        System.out.printf("log10(%f) = %f\n\n", num1, result);
                    }
                    break;
                case 11: // Natural Logarithm
                    num1 = getDoubleInput("Enter a number: ");
                    result = naturalLog(num1);
                    if (!Double.isNaN(result)) {
                        System.out.printf("ln(%f) = %f\n\n", num1, result);
                    }
                    break;
                case 12: // Factorial
                    int n = getIntInput("Enter a non-negative integer: ");
                    result = factorial(n);
                    if (!Double.isNaN(result)) {
                        System.out.printf("%d! = %f\n\n", n, result);
                    }
                    break;
                case 13: // Exponential
                    num1 = getDoubleInput("Enter the exponent: ");
                    result = exponential(num1);
                    System.out.printf("e^%f = %f\n\n", num1, result);
                    break;
                case 14: // Absolute Value
                    num1 = getDoubleInput("Enter a number: ");
                    result = absoluteValue(num1);
                    System.out.printf("|%f| = %f\n\n", num1, result);
                    break;
                case 15: // Exit
                    System.out.println("\nThank you for using the Scientific Calculator. Goodbye!\n");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 15.\n");
            }

            // Ask if the user wants to perform another operation
            if (choice != 15) {
                String continueChoice = getContinueChoice();
                if (continueChoice.equalsIgnoreCase("N")) {
                    System.out.println("\nThank you for using the Scientific Calculator. Goodbye!\n");
                    running = false;
                }
            }
        }
        scanner.close();
    }

    // Method to display results in a formatted way
    private void displayResult(double num1, double num2, double result, String operator) {
        System.out.printf("%f %s %f = %f\n\n", num1, operator, num2, result);
    }

    // Method to ask the user if they want to perform another operation
    private String getContinueChoice() {
        System.out.print("Do you want to perform another operation? (Y/N): ");
        return scanner.nextLine();
    }

    // Main method to start the program
    public static void main(String[] args) {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.run();
    }
}
