
//---------------------------------------------------------------------
//Assignment 1 - Program that prints my name in big.
//Date: 25 September 2018
//Written by: Joanna Chin Fong Lau Ah Wing (Student ID:40083829)
//For COMP 248 Section M-X (Nancy Acemian) - Fall 2018
//---------------------------------------------------------------------

import java.util.Scanner; //import class necessary to be able to use scanner 

public class calcBMI 
//algorithm calculates the bmi according to values user input
{
	public static void main(String arg [] )
		{
		Scanner keyboard = new Scanner(System.in); //declaring out scanner as keyboars
		double weight; //declare variable weight
		double height; //declare variable height
		double bmi; //declare variable bmi
		System.out.println("Hello");
		System.out.print("Enter your weight in kilogram: ");
		weight = keyboard.nextDouble(); //next thing user inputs until enter is pressed will be assigned to weight
		System.out.print("Enter your height in meter: ");
		height = keyboard.nextDouble();
		bmi = weight / height / height ; //calculating bmi using values input by user and assigning it to variable bmi
		System.out.println(); //leaving empty space for clarity
		System.out.println("Your weight is " + weight + "kg"); //display values input by user
		System.out.println("Your height is " + height + "m");
		System.out.println();
		System.out.println("Your BMI is " + bmi); //output bmi for user to see
		System.out.println();
		System.out.println("Thank you for using our BMI calculator.");
		System.out.println();
		
		keyboard.close(); //closing Scanner keyboard
		} //end of main
} //end of class calcBMI

