//---------------------------------------------------------------------
//Assignment 2 - Program that calculates the sum of the digits of a number and the divisors of the sum
//Date: 10 October 2018
//Written by: Joanna Chin Fong Lau Ah Wing (Student ID:40083829)
//For COMP 248 Section M-X (Nancy Acemian) - Fall 2018
//---------------------------------------------------------------------

import java.util.Scanner;

public class calculation 
{
	public static void main (String[] arg)
	{
		//number is the value input by the user
		//digitSum is the value left after the last digit has been subtracted
		//sum is the total of the digit
		//modValue is the current digit being extracted
		//modMult is the value by which the digitSum left is being mod with
		int number, digitSum, sum = 0 , modValue = 0, modMult = 10;
		//count the number of times it does the loop to output the divisors
		int count;
		//another stores the value yes or no to check whether the user wants to input another number
		String another;
		//declare scanner
		Scanner keyboard = new Scanner(System.in);
		//welcome message
		System.out.println("**************************************");
		System.out.println("");
		System.out.println(" Welcome to our Calculation Program!");
		System.out.println("");
		System.out.println("**************************************");	
		//prompt user to input number and store it in number

		//initializing another as yes for the loop to run at least once
		another = ("yes");
		while (another.compareTo("yes") == 0)
		{
			System.out.print("Enter a number with at most 7 digits: ");
			number = keyboard.nextInt();
			System.out.println("");
			//copy the value of number in digitSum as we will reduce it to zero and we value in variable number to display the digits
			digitSum = number;
			//changing another to something else than yes so that it does not loop again if the user does not change variable another to "yes" again
			another = ("no");
			modValue = 0;
			sum = 0;
			modMult = 10;
			
			//nested repeat until loop
			do 
			{
				//extract the last digit
				modValue = (digitSum % modMult)/(modMult/10);
				//remove the digit unit from digitSum
				digitSum = digitSum - (modValue * modMult/10);
				//add last digit to variable sum
				sum = sum + modValue;
				//increase modMult so that it extracts a digit before the last one
				modMult = modMult * 10;
			}
			//when all digits have been extracted, digit sum should equal 0
			while (digitSum > 0);
			
			//output the sum of the digits
			System.out.print("The sum of the digits is: " + sum);
			System.out.println("");
			System.out.print("The divisors of " + sum + " are as follow: ");
			//reset digit sum to number (initially 0 after last loop)
			digitSum = number;
			//reset modMult to 10
			modMult = 10;
			//loop to display the digits, same logic as above except instead of adding to sum, we output the digit
			count = 1;

			do
			{
				//comparing the remainder of all numbers from one to sum to zero to see of it is divisible exactly
				if (sum % count == 0)
					System.out.print(count + " ");
				count = count + 1;
			}
			while (count < sum + 1);
			
			System.out.println("");
			//while  (digitSum > 0);	
			System.out.println("");
			System.out.println("**************************************");		
			//prompting the user asking if he wants to add another number, if he does, another becomes "yes"
			System.out.println("Do you want to try another number?" );
			System.out.print("Input 'yes' to continue and 'no' to end: ");
			another = keyboard.next();
			System.out.println("");
			System.out.println("**************************************");
		}
		//Thank you message
		System.out.println("");
		System.out.println("Thank you for using our calculator. Have a great day!");
		//close scanner
		keyboard.close();
	}


}
