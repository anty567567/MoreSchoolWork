/* ReviewAssignment.java
Description: A review of various types of programs ranging from basic IPO programs to loops
Name: Anthony De Luca
Date Created: 5th February 2018
Last Modified: 12th February 2018
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class ReviewAssignment {

    public static InputStreamReader inStream = new InputStreamReader(System.in);
    public static BufferedReader sysin = new BufferedReader(inStream);

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.print("Please select the directory you would like to access (0-3):\n0.Exit\n1.Basic IPO\n2.Decision Statements\n3.Loops\nChoice:");
            int choice = Integer.parseInt(sysin.readLine());
            decision(choice);
        }
    }

    public static void decision(int choice) throws IOException {
        boolean properSelection;
        do {
            properSelection = true;
            switch (choice) {
                case 0:
                    System.exit(1);
                case 1:
                    basicIPOSelection();
                    break;
                case 2:
                    decisionStatementSelection();
                    break;
                case 3:
                    loopsSelection();
                    break;
                default:
                    properSelection = false;
                    System.out.print("Please input an acceptable choice (0-3):\n0.Exit\n1.Basic IPO\n2.Decision Statements\n3.Loops\nChoice:");
                    choice = Integer.parseInt(sysin.readLine());
            }
        } while (!properSelection);
    }


    //BASIC INPUT AND OUTPUT PROGRAMS
    public static void basicIPOSelection() throws IOException {
        boolean properSelection;
        System.out.print("Please select the program you would like to run (0-5):\n0.Back\n1.Digits\n2.Sleep\n3.Order\n4.GallonConverter\n5.SimpleInterest\nChoice:");
        do {
            int choice = Integer.parseInt(sysin.readLine());
            properSelection = true;
            switch (choice) {
                case 0:
                    break;
                case 1:
                    digits();
                    break;
                case 2:
                    sleep();
                    break;
                case 3:
                    order();
                    break;
                case 4:
                    gallonConverter();
                    break;
                case 5:
                    simpleInterest();
                    break;
                default:
                    properSelection = false;
                    System.out.print("Please input an acceptable choice (0-5):\n0.Back\n1.Digits\n2.Sleep\n3.Order\n4.GallonConverter\n5.SimpleInterest\nChoice:");
            }
        } while (!properSelection);
    }

    public static void digits() throws IOException {
        int number;
        System.out.print("Welcome to the Digits program, please enter a 3 digit number\nNumber:");
        number = Integer.parseInt(sysin.readLine());
        System.out.println("The hundreds place digit is: " + number / 100 + "\nThe tens place digit is: " + number / 10 % 10 + "\nThe ones place digit is: " + number % 10 + "\n");
    }

    public static void sleep() throws IOException {
        int birthYear, birthMonth, birthDay, currentYear, currentMonth, currentDay, daysAlive;
        System.out.print("Please enter the following\nBirth Year: ");
        birthYear = Integer.parseInt(sysin.readLine());
        System.out.print("Birth Month:");
        birthMonth = Integer.parseInt(sysin.readLine());
        System.out.print("Birth Day:");
        birthDay = Integer.parseInt(sysin.readLine());
        System.out.print("Current Year:");
        currentYear = Integer.parseInt(sysin.readLine());
        System.out.print("Current Month:");
        currentMonth = Integer.parseInt(sysin.readLine());
        System.out.print("Current Day:");
        currentDay = Integer.parseInt(sysin.readLine());

        daysAlive = (currentYear - birthYear) * 365 - (birthMonth - 1) * 30 + (currentMonth - 1) * 30 + currentDay - birthDay;
        System.out.println("You have been alive for " + daysAlive + " days.");
        System.out.println("You have slept " + daysAlive * 8 + " hours.\n");
    }

    public static void order() throws IOException {
        int fries, burgers, sodas;
        double tax, total, subtotal, paid;
        DecimalFormat twoDecimals = new DecimalFormat("#.00");

        System.out.print("Please enter the number of each item you would like to purchase\nBurgers:");
        burgers = Integer.parseInt(sysin.readLine());
        System.out.print("Fries:");
        fries = Integer.parseInt(sysin.readLine());
        System.out.print("Sodas:");
        sodas = Integer.parseInt(sysin.readLine());
        subtotal = fries * 1.09 + burgers * 1.69 + sodas * 0.99;
        System.out.println("Your subtotal is: $" + twoDecimals.format(subtotal));
        tax = subtotal * 0.065;
        total = subtotal + tax;
        System.out.println("Your tax is: $" + twoDecimals.format(tax) + "\nYour total is: $" + twoDecimals.format(total));
        System.out.print("Please pay the amount due\nAmount Tendered: $");
        paid = Double.parseDouble(sysin.readLine());
        System.out.println("Change Due: $" + twoDecimals.format(paid - total) + "\n");

    }

    public static void gallonConverter() throws IOException {
        double gallons;
        System.out.print("Please enter the number of gallons:");
        gallons = Double.parseDouble(sysin.readLine());
        System.out.println("In " + gallons + " gallons there are:\n" + gallons * 4 + " quarts\n" + gallons * 8 + " pints\n" + gallons * 16 + " cups\n" + gallons * 256 + " tablespoons\n");
    }

    public static void simpleInterest() throws IOException {
        double amount, principal, interestRate;
        int years;
        DecimalFormat twoDecimals = new DecimalFormat("#.00");

        System.out.print("Please enter the\nPrincipal:");
        principal = Double.parseDouble(sysin.readLine());
        System.out.print("Years:");
        years = Integer.parseInt(sysin.readLine());
        System.out.print("Interest Rate(Decimal):");
        interestRate = Double.parseDouble(sysin.readLine());
        amount = principal * (1 + years * interestRate);
        System.out.println("The value after the term is: $" + twoDecimals.format(amount));

        System.out.print("\nPlease enter the\nDesired Amount:");
        amount = Double.parseDouble(sysin.readLine());
        System.out.print("Years:");
        years = Integer.parseInt(sysin.readLine());
        System.out.print("Interest Rate(Decimal):");
        interestRate = Double.parseDouble(sysin.readLine());
        principal = amount / (1 + years * interestRate);
        System.out.println("The required principal is: $" + twoDecimals.format(principal) + "\n");
    }


    //DECISION STATEMENT PROGRAMS
    public static void decisionStatementSelection() throws IOException {
        System.out.print("Please select the program you would like to run (0-8):\n0.Back\n1.Eggs\n2.MathTutor\n3.QuadraticEquation\n4.MyPow\n5.CarPayment\n6.BacteriaGrowth\n7.TrigFunctions\n8.InverseTrigFunctions\nChoice:");
        boolean properSelection;
        do {
            int choice = Integer.parseInt(sysin.readLine());
            properSelection = true;
            switch (choice) {
                case 0:
                    break;
                case 1:
                    eggs();
                    break;
                case 2:
                    mathTutor();
                    break;
                case 3:
                    quadraticEquation();
                    break;
                case 4:
                    myPow();
                    break;
                case 5:
                    carPayment();
                    break;
                case 6:
                    bacteriaGrowth();
                    break;
                case 7:
                    trigFunctions();
                    break;
                case 8:
                    inverseTrigFunctions();
                    break;
                default:
                    properSelection = false;
                    System.out.print("Please select the program you would like to run (0-8):\n0.Back\n1.Eggs\n2.MathTutor\n3.QuadraticEquation\n4.MyPow\n5.CarPayment\n6.BacteriaGrowth\n7.TrigFunctions\n8.InverseTrigFunctions\nChoice:");
            }
        } while (!properSelection);
    }

    public static void eggs() throws IOException {
        int eggs;
        double pricePerDozen, total;
        DecimalFormat twoDecimals = new DecimalFormat("#.00");

        System.out.print("Please enter how many eggs you are purchasing:");
        eggs = Integer.parseInt(sysin.readLine());

        if (eggs < 48) {
            pricePerDozen = 0.5;
        } else if (eggs < 72) {
            pricePerDozen = 0.45;
        } else if (eggs < 132) {
            pricePerDozen = 0.4;
        } else {
            pricePerDozen = 0.35;
        }
        total = (eggs / 12) * pricePerDozen + (eggs - eggs / 12) * (pricePerDozen / 12);

        System.out.println("Your total is: $" + twoDecimals.format(total) + "\n");
    }

    public static void mathTutor() throws IOException {
        int operator, firstNumber, secondNumber, answer = 0, response = 0;
        firstNumber = (int) (Math.random() * 10 + 1);
        secondNumber = (int) (Math.random() * 10 + 1);
        operator = (int) (Math.random() * 4 + 1);
        while (response == 0) {
            response = 1;
            switch (operator) {
                case 1:
                    answer = firstNumber + secondNumber;
                    System.out.print("What is " + firstNumber + " + " + secondNumber + "?\nResponse:");
                    break;
                case 2:
                    answer = firstNumber - secondNumber;
                    System.out.print("What is " + firstNumber + " - " + secondNumber + "?\nResponse:");
                    break;
                case 3:
                    answer = firstNumber * secondNumber;
                    System.out.print("What is " + firstNumber + " * " + secondNumber + "?\nResponse:");
                    break;
                case 4:
                    answer = firstNumber / secondNumber;
                    System.out.print("What is " + firstNumber + " / " + secondNumber + "? (truncated division)\nResponse:");
                    break;
                default:
                    response = 0;
            }
        }
        response = Integer.parseInt(sysin.readLine());
        if (response == answer) {
            System.out.println("Correct!\n");
        } else {
            System.out.println("Incorrect, the correct answer was: " + answer + "\n");
        }
    }

    public static void quadraticEquation() throws IOException {
        double a, b, c, rootOne, rootTwo;
        DecimalFormat twoDecimals = new DecimalFormat("#.00");

        System.out.print("Please enter the\na value:");
        a = Double.parseDouble(sysin.readLine());
        System.out.print("b value:");
        b = Double.parseDouble(sysin.readLine());
        System.out.print("c value:");
        c = Double.parseDouble(sysin.readLine());

        if ((Math.pow(b, 2.0) - 4 * a * c) < 0) {
            System.out.println("There are no real roots\n");
        } else if ((Math.pow(b, 2.0) - 4 * a * c) == 0) {
            System.out.println("There is only one root: " + twoDecimals.format(-b / (2 * a)) + "\n");
        } else {
            rootOne = (-b + Math.sqrt(Math.pow(b, 2.0) - 4 * a * c)) / (2 * a);
            rootTwo = (-b - Math.sqrt(Math.pow(b, 2.0) - 4 * a * c)) / (2 * a);
            System.out.println("The roots are: " + twoDecimals.format(rootOne) + " and " + twoDecimals.format(rootTwo) + "\n");
        }
    }

    public static void myPow() throws IOException {
        double x, y, answerOne, answerTwo;
        System.out.print("Please enter a value for\nX:");
        x = Double.parseDouble(sysin.readLine());
        System.out.print("Y:");
        y = Double.parseDouble(sysin.readLine());
        answerOne = Math.exp(y * Math.log(x));
        answerTwo = Math.pow(x, y);
        System.out.println("The answer using the formula is: " + answerOne);
        System.out.println("The answer using Math.pow is: " + answerTwo + "\n");
    }

    public static void carPayment() throws IOException {
        double principal, interestRate, monthlyPayment;
        int months;
        DecimalFormat twoDecimals = new DecimalFormat("#.00");

        System.out.print("Please input the\nPrincipal:");
        principal = Double.parseDouble(sysin.readLine());
        System.out.print("Interest Rate (decimal):");
        interestRate = Double.parseDouble(sysin.readLine());
        System.out.print("Number of Monthly Payments:");
        months = Integer.parseInt(sysin.readLine());

        monthlyPayment = (principal * (interestRate / 12)) / (1 - (Math.pow((1 + interestRate / 12), -months)));
        System.out.println("The monthly payment is: $" + twoDecimals.format(monthlyPayment) + "\n");
    }

    public static void bacteriaGrowth() throws IOException {
        int y, n;
        double k, t;
        System.out.print("Please enter the\nStarting Amount:");
        n = Integer.parseInt(sysin.readLine());
        System.out.print("Constant K:");
        k = Double.parseDouble(sysin.readLine());
        System.out.print("Time:");
        t = Double.parseDouble(sysin.readLine());
        y = (int) (n * Math.exp(k * t));
        System.out.println("The final amount is: " + y + "\n");
    }

    public static void trigFunctions() throws IOException {
        double angle;
        DecimalFormat fourDecimals = new DecimalFormat("#.0000");
        System.out.print("Please input an angle in degrees:");
        angle = Double.parseDouble(sysin.readLine());
        System.out.println("Sine:" + fourDecimals.format(Math.sin(angle)));
        System.out.println("Cosine:" + fourDecimals.format(Math.cos(angle)));
        System.out.println("Tangent:" + fourDecimals.format(Math.tan(angle)) + "\n");
    }

    public static void inverseTrigFunctions() throws IOException {
        double angle;
        DecimalFormat fourDecimals = new DecimalFormat("#.0000");

        System.out.print("Please input an angle in degrees:");
        angle = Double.parseDouble(sysin.readLine());
        System.out.println("Arcsin:" + fourDecimals.format(Math.asin(angle)));
        System.out.println("Arccos:" + fourDecimals.format(Math.acos(angle)));
        System.out.println("ArcTan:" + fourDecimals.format(Math.atan(angle)) + "\n");
    }


    //LOOP PROGRAMS
    public static void loopsSelection() throws IOException {
        boolean properSelection;
        System.out.print("Please select the program you would like to run (0-7):\n0.Back\n1.PrimeNumber\n2.PrimeFactors\n3.PowersTable\n4.GCD\n5.Necklace\n6.Hailstone\n7.RandomWalk\nChoice:");
        do {
            int choice = Integer.parseInt(sysin.readLine());
            properSelection = true;
            switch (choice) {
                case 0:
                    break;
                case 1:
                    primeNumber();
                    break;
                case 2:
                    primeFactors();
                    break;
                case 3:
                    powersTable();
                    break;
                case 4:
                    GCD();
                    break;
                case 5:
                    necklace();
                    break;
                case 6:
                    hailstone();
                    break;
                case 7:
                    randomWalk();
                    break;
                default:
                    properSelection = false;
                    System.out.print("Please input an acceptable choice (0-7):\n0.Back\n1.PrimeNumber\n2.PrimeFactors\n3.PowersTable\n4.GCD\n5.Necklace\n6.Hailstone\n7.RandomWalk\nChoice:");
            }
        } while (!properSelection);
    }

    public static void primeNumber() throws IOException {
        int numberOne, numberTwo;
        boolean prime = true;
        System.out.print("Please enter a number:");
        numberOne = Integer.parseInt(sysin.readLine());
        for (int i = numberOne / 2; i > 1; i--) {
            if ((numberOne % i) == 0) {
                prime = false;
                i = 1;
            } else {
                prime = true;
            }
        }
        if (prime) {
            System.out.println("Number is prime.");
        } else {
            System.out.println("Number is not prime");
        }

        System.out.print("Please enter a second number that is greater than the first number\nFirst Number: " + numberOne + "\nSecond Number:");
        numberTwo = Integer.parseInt(sysin.readLine());
        System.out.println("These numbers in between " + numberOne + " and " + numberTwo + " are prime:");
        for (int i = numberOne + 1; i < numberTwo; i++) {
            prime = true;
            for (int j = i / 2; j > 1; j--) {
                if ((i % j) == 0) {
                    prime = false;
                    j = 1;
                } else {
                    prime = true;
                }
            }
            if (prime) {
                System.out.println(i);
            }
        }
        System.out.print("\n");
    }

    public static void primeFactors() throws IOException {
        int number, checker;
        boolean prime = true;
        ArrayList<Integer> factors = new ArrayList<>();
        ArrayList<Integer> primeFactors = new ArrayList<>();

        System.out.print("Please input a number to find the prime factors:");
        number = Integer.parseInt(sysin.readLine());

        for (int i = number / 2; i > 1; i--) {
            for (int k = number / 2; k > 1; k--) {
                if ((number % k) == 0) {
                    prime = false;
                    k = 1;
                } else {
                    prime = true;
                }
            }
            if ((number % i) == 0 && !prime) {
                factors.add(i);
                number = number / i;
            } else {
                factors.add(number);
                i = 1;
            }
        }

        for (int i = 0; i < factors.size(); ) {
            checker = factors.get(i);
            prime = true;
            for (int k = checker / 2; k > 1; k--) {
                if ((checker % k) == 0) {
                    prime = false;
                    k = 1;
                } else {
                    prime = true;
                }
            }
            if (prime) {
                primeFactors.add(factors.get(i));
            } else {
                for (int k = checker / 2; k > 1; k--) {
                    if ((checker % k) == 0) {
                        factors.add(k);
                        checker = checker / k;
                    }
                }
            }
            factors.remove(i);
        }
        System.out.println("Prime Factors:");
        for (int j : primeFactors) {
            System.out.println(primeFactors.get(j));
        }
        System.out.print("\n");
    }

    public static void powersTable() {
        System.out.println("x^1        x^2        x^3        x^4        x^5");
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 6; j++) {
                System.out.print(Math.pow(i, j) + "        ");
            }
            System.out.println("\n");
        }
    }

    public static void GCD() throws IOException {
        int firstNumber, secondNumber, divisor = 0, swap;
        System.out.print("Please input two non negative integers\nFirst Number:");
        firstNumber = Integer.parseInt(sysin.readLine());
        System.out.print("Second Number:");
        secondNumber = Integer.parseInt(sysin.readLine());
        if (firstNumber > secondNumber) {
            swap = secondNumber;
            secondNumber = firstNumber;
            firstNumber = swap;
        }
        for (int i = firstNumber; i > 0; i--) {
            if (firstNumber % i == 0 && secondNumber % i == 0) {
                divisor = i;
                break;
            }
        }
        System.out.println("The GCD is: " + divisor + "\n");
    }

    public static void necklace() throws IOException {
        ArrayList<Integer> necklace = new ArrayList<>();
        int i = 0, j = 1;

        System.out.print("Please input the first starting number (1 digit):");
        necklace.add(Integer.parseInt(sysin.readLine()));
        System.out.print("Second starting number (1 digit):");
        necklace.add(Integer.parseInt(sysin.readLine()));

        do {
            if ((necklace.get(i) + necklace.get(j)) > 9) {
                necklace.add((necklace.get(i) + necklace.get(j)) % 10);
            } else {
                necklace.add(necklace.get(i) + necklace.get(j));
            }
            i++;
            j++;
        }
        while (!necklace.get(necklace.size() - 1).equals(necklace.get(1)) || !necklace.get(necklace.size() - 2).equals(necklace.get(0)));
        for (int k : necklace) {
            System.out.print(necklace.get(k));
        }
        System.out.println("\nThe number of steps was: " + necklace.size() + "\n");
    }

    public static void hailstone() {
        int greatest = 0, highestStartingNumber = 0, steps, currentNumber;
        for (int i = 1; i <= 200; i++) {
            currentNumber = i;
            steps = 0;
            System.out.println(currentNumber);
            while (currentNumber != 1) {
                steps++;
                if (currentNumber % 2 == 0) {
                    currentNumber /= 2;
                } else {
                    currentNumber = currentNumber * 3 + 1;
                }
                System.out.println(currentNumber);
            }
            if (steps > greatest) {
                highestStartingNumber = i;
                greatest = steps;
            }
        }
        System.out.println("By allowing this text to print, it proves that all numbers from 1-200 end up in the 4,2,1 cycle.");
        System.out.println("The greatest number of iterations is: " + greatest);
        System.out.println("The starting number that produces this is: " + highestStartingNumber + "\n");


    }

    public static void randomWalk() {
        int steps, position, greatest = 0, average = 0;
        for (int i = 1; i <= 50; i++) {
            position = 4;
            steps = 0;
            while (position < 8 && position > 0) {
                steps++;
                if ((int) (Math.random() * 2) == 1) {
                    position++;
                } else {
                    position--;
                }
            }
            if (steps > greatest) {
                greatest = steps;
            }
            average += steps;
        }
        average = average / 50;
        System.out.println("The average number of steps per walk is: " + average);
        System.out.println("The greatest amount of steps taken in a single walk was: " + greatest + "\n");
    }
}