/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Douglas Glover
 */
package base;
import java.util.Scanner;
/*
Sometimes you have to perform a more complex calculation based on some provided inputs and then use that result to make a determination.

Create a program that prompts for your weight, gender, total alcohol consumed (in ounces), and the amount of time since your last drink.
Calculate your blood alcohol content (BAC) using this formula

BAC = (A × 5.14 / W × r) − .015 × H
where

A is total alcohol consumed, in ounces (oz).
W is body weight in pounds.
r is the alcohol distribution ratio:
0.73 for men
0.66 for women
H is number of hours since the last drink.
Display whether or not it’s legal to drive by comparing the blood alcohol content to 0.08.

Example Output

Enter a 1 is you are male or a 2 if you are female: 1
How many ounces of alcohol did you have? 3
What is your weight, in pounds? 175
How many hours has it been since your last drink? 1

Your BAC is 0.049323
It is legal for you to drive.


Enter a 1 is you are male or a 2 if you are female: 1
How many ounces of alcohol did you have? 5
What is your weight, in pounds? 175
How many hours has it been since your last drink? 1

Your BAC is 0.092206
It is not legal for you to drive.

Constraint

Prevent the user from entering non-numeric values.

Challenges

Handle metric units.
Look up the legal BAC limit by state and prompt for the state. Display a message that states whether or not it’s legal to drive based on the computed BAC.
Develop this as a mobile application that makes it easy to record each drink, updating the BAC each time a drink is entered.
 */
public class App {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        App myApp = new App();

        System.out.print("Enter a 1 is you are male or a 2 if you are female: ");
        int sex = myApp.getInt();

        System.out.print("How many ounces of alcohol did you have? ");
        int oz = myApp.getInt();

        System.out.print("What is your weight, in pounds? ");
        int weight = myApp.getInt();

        System.out.print("How many hours has it been since your last drink? ");
        int hours = myApp.getInt();

        myApp.findBAC(sex, oz, weight, hours);
    }
    int getInt()
    {
        while(true) {
            if (!in.hasNextInt())
            {
                in.next();
                continue;
            }
            return in.nextInt();
        }
    }
    void findBAC(int sex, int oz, int weight, int hours)
    {
        double ratio = sex == 1 ? 0.73 : 0.66;
        double BAC = (oz * 5.14 / weight * ratio) - .015 * hours;
        String legality = BAC > 0.08 ? "not legal" : "legal";

        System.out.printf("""
        Your BAC is %.6f
        It is %s for you to drive.
        """, BAC, legality);
    }
}
