//---------------------------------------------------------------------
//Assignment 2 - Program that evaluates the IELTS scores of students
//Date: 10 October 2018
//Written by: Joanna Chin Fong Lau Ah Wing (Student ID:40083829)
//For COMP 248 Section M-X (Nancy Acemian) - Fall 2018
//---------------------------------------------------------------------

import java.util.Scanner;

public class ieltsmain {
	public static void main (String arg[] )
	{
		//roundAvg is the user's overall score rounded DOWN to the integer part only
		int menu, roundAvg = 0;
		//avg is the overall score
		//diffRound is the difference between the exact overall score and the rounded down version
		double write = 0, avg = 0, listen = 0, read = 0, speak = 0, sum = 0, diffRound = 0;
		//conclu is the message to be displayed depending on the scores
		String conclu = "";

		//Welcome message
		System.out.println("***********************************************************************");
		System.out.println("");
		System.out.println("       Welcome to Concordia's Language Proficiency Evaluator!");
		System.out.println("");
		System.out.println("***********************************************************************");
		//declaring new scanner
		Scanner keyboard = new Scanner (System.in);
		//displaying menu for user
		System.out.println("");
		System.out.println("Please select one of the following options.");
		System.out.println("1 - Explain the Language Proficiency Requirements");
		System.out.println("2 - Evaluation of your English Proficiency");
		System.out.println("");
		System.out.print("Please input the number corresponding to your case: ");
		//user inputing choice number that corresponds to his case and the value is input in variable menu
		menu = keyboard.nextInt();
		System.out.println("");

		//if statement to check whether the user wants option 1 or option 2
		if ( menu == 1 )
			System.out.println("The overall score of IELTS exam of applicants needs to be equal or above 6.5 and the scores\r\n" + 
					"for writing and reading skills should not be below 6.0. If your overall score is 6, and your\r\n" + 
					"reading and writing scores are at least 6, you will be eligible for conditional admission. So\r\n" + 
					"you need to take an English course in the first semester. Otherwise you have to retake the IELTS\r\n" + 
					"exam.\r\n" + 
					"Thanks for choosing Concordia!");
		//if menu <> 1 then 
		//based on the assumption that the user will no input something other than 1 or 2
		else
		{
			//user inputs his scores for the different tests
			System.out.println("You will be prompted to input your IELTS scores.");
			System.out.println("Score in Listening: ");
			listen = keyboard.nextDouble();
			System.out.println("Score in Speaking: ");
			speak = keyboard.nextDouble();
			System.out.println("Score in Reading: ");
			read = keyboard.nextDouble();
			System.out.println("Score in Writing: ");
			write = keyboard.nextDouble();

			//finding the average of his tests
			sum = read + write + speak + listen;
			avg = sum/4;
			//rounding down the average and storing it in roundAvg
			roundAvg = ((int)sum)/4;
			//finding the difference between the two aka how much the value has been rounded down
			diffRound = avg - roundAvg;

			//depending on the value in diffRound, the if statements are used to know what is the final rounded value
			if (diffRound < 0.25)
				avg = roundAvg;
			else if (diffRound < 0.75)
				avg = roundAvg + 0.5;
			else 
				avg = roundAvg + 1;

			//depending on the overall score and the reading and writing scores, an appropriate message is chosen
			if (avg >= 6.5 & read >= 6 && write >= 6 )
				conclu = "Congratulations! You satisfy Concordia's language requirements.";
			else if ((avg >= 6.5 && read <= 6 && write >= 6) || (avg >= 6.5 && read >= 6 && write <= 6))
				conclu = "You received conditional admission. You will have to take an english course in the first semester.";
			else if (avg == 6 && read >= 6 && write >= 6)
				conclu = "You received conditional admission. You will have to take an english course in the first semester.";
			else if (avg == 6 && read <= 6 && write <= 6)
				conclu = "You received conditional admission. You will have to take an english course in the first semester.";
			else
				conclu = "You will have to take the exam again.";

			//output the score values of the user and output the relevant message
			System.out.println("");
			System.out.println("Your overall score is: " + avg);
			System.out.println("Your reading score is: " + read);
			System.out.println("Your writing score is: " + write);
			System.out.println("");
			System.out.println(conclu);
		}
		
		//closing the scanner
		keyboard.close();

	}
}
