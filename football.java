//---------------------------------------------------------------------
//Assignment 3 - Program that founds the number of times a tournament 
//               has to be done for a team win.
//Date: 25 October 2018
//Written by: Joanna Chin Fong Lau Ah Wing (Student ID:40083829)
//For COMP 248 Section M-X (Nancy Acemian) - Fall 2018
//---------------------------------------------------------------------


import java.util.Scanner;
import java.util.Random;
public class football {
	public static void main(String[] args)
	{
		//used in case a tie happens,to count the number of times the tournament has been been done already,to keep track of which space in array score to fill, no of matches with total goals above average
		int tie,fillArray = 0,count = 0, aboveAvg = 0;
		//2D array that contains the total number of goals in all of the tournaments
		//a row is for the number of goals in a tournament. 15 columns because  there are 15 matches played.
		int [][] allGoals = new int [20][15];
		//score is used to input the random values generated
		int [] score = new int[16];
		//teams in quarter final
		String [] quarter = new String[8];
		String [] semi = new String[8];
		String[] finalX = new String[4];
		String []winner = new String [2];
		//random generator
		Random rand = new Random();
		//user's favorite team and team that won
		String fav,win = "";
		double sum = 0;
		//average of a tournament and average of all tournaments
		double avg = 0, avgAvg = 0;

		Scanner keyboard = new Scanner(System.in);

		String [] teams = {"Uruguay", "Portugal", "France", "Argentina", "Brazil", "Mexico", "Belgium", "Japan", "Spain", "Russia", "Croatia", "Denmark", "Sweden", "Switzerland", "Colombia", "England"};
		//prompting user for favorite team
		System.out.print("What is your favourite team: ");
		fav = keyboard.next();
		System.out.println("\n");
		for (int i=0; i<16; i++)
		{
			//changing user input and team names to upper case to have the comparison ignore case
			if (fav.toUpperCase().replaceAll("\\s", "").compareTo(teams[i].toUpperCase()) == 0)
			{
				do
				{
					System.out.println("********************  Tournament " + (count + 1) + "  ****************************");
					System.out.println("\n");
					fillArray = 0;

					//generating random goal amount for the first round of matches, store in array score
					for (int a = 0; a<16; a++)
						score[a] = rand.nextInt(5);
					//comparing the scores of the 1st and 2nd, 3rd and 4th, etc and copying the winner's name in another array quarter to be used in the next round of matches.
					for (int j = 0; j <15; j= (j + 2))
					{
						int opponent = j + 1;
						if (score[j] > score[opponent])
							quarter[fillArray] = teams[j];
						else if (score[j] == score[opponent])
						{
							//if the match is a tie, a new goal number is generated and used to define which team won
							tie = rand.nextInt(2);
							if (tie == 1)
							{
								quarter[fillArray] = teams[j];
								score[j]++;
							}
							else
							{
								quarter[fillArray] = teams[opponent];
								score[opponent]++;
							}
						}
						else
							quarter[fillArray] = teams[opponent];
						fillArray++;
					}
					//output the results for the first round of 16
					System.out.print("ROUND OF 16: ");
					for (int k =0;k<15; k= k + 2)
					{
						System.out.print("[" + teams[k] + " " + score[k] + ":"+ score[k+1] + " " + teams[k+1] + "] " );
					}
					i = 16;
					//put total no of goals in 2D array
					int o = 0;
					for (int m=0; m<15; m+=2) {
						allGoals[count][o] = score[m] + score[m+1];
						o++;
					}
					//******************************************************************************************
					//for quarter finals
					for (int a = 0; a<8; a++)
						score[a] = rand.nextInt(5);
					//		****
					fillArray = 0;
					for (int j = 0; j <7; j= (j + 2))
					{

						int opponent = j + 1;
						if (score[j] > score[opponent])
							semi[fillArray] = quarter[j];
						else if (score[j] == score[opponent])
						{
							tie = rand.nextInt(2);
							if (tie == 1)
							{
								semi[fillArray] = quarter[j];
								score[j]++;
							}
							else
							{
								semi[fillArray] = quarter[opponent];
								score[opponent]++;
							}
						}
						else
							semi[fillArray] = quarter[opponent];
						fillArray++;
					}
					System.out.println("");
					System.out.print("QUARTER FINALS: ");
					for (int k =0;k<7; k= k + 2)
					{

						System.out.print("[" + quarter[k] + " " + score[k] + ":"+ score[k+1] + " " + quarter[k+1] + "] " );
					}

					int z = 8;
					for (int m=0; m<8; m+=2) {
						allGoals[count][z] = (score[m] + score[m+1]);
						z = z + 1;
					}
					//goal statistics 




					//****************************************************************************************


					//for semi finals
					for (int a = 0; a<4; a++)
						score[a] = rand.nextInt(5);
					//		****
					fillArray = 0;
					for (int j = 0; j <4; j= (j + 2))
					{

						int opponent = j + 1;
						if (score[j] > score[opponent])
							finalX[fillArray] = semi[j];
						else if (score[j] == score[opponent])
						{
							tie = rand.nextInt(2);
							if (tie == 1)
							{
								finalX[fillArray] = semi[j];
								score[j]++;
							}
							else
							{
								finalX[fillArray] = semi[opponent];
								score[opponent]++;
							}
						}
						else
							finalX[fillArray] = semi[opponent];
						fillArray++;
					}
					System.out.println("");
					System.out.print("SEMI FINALS: ");
					for (int k =0;k<4; k= k + 2)
					{

						System.out.print("[" +semi[k] + " " + score[k] + ":"+ score[k+1] + " " + semi[k+1] + "] " );
					}

					int q = 12;
					for (int m=0; m<4; m+=2) {
						allGoals[count][q] = (score[m] + score[m+1]);
						q++;
					}
					//****************************************************************************************
					//for finals
					for (int a = 0; a<2; a++)
						score[a] = rand.nextInt(5);
					//		****
					fillArray = 0;
					for (int j = 0; j <2; j= (j + 2))
					{

						int opponent = j + 1;
						if (score[j] > score[opponent])
							winner[fillArray] = finalX[j];
						else if (score[j] == score[opponent])
						{
							tie = rand.nextInt(2);
							if (tie == 1)
							{
								winner[fillArray] = finalX[j];
								score[j]++;
							}
							else
							{
								winner[fillArray] = finalX[opponent];
								score[opponent]++;
							}
						}
						else
							winner[fillArray] = finalX[opponent];
						fillArray++;
					}
					if (score[0]> score[1])
						win = finalX[0];
					else
						win = finalX[1];
					System.out.println("");
					System.out.print("FINAL: ");
					for (int k =0;k<2; k= k + 2)
					{
						System.out.print("[" +finalX[k] + " " + score[k] + ":"+ score[k+1] + " " + finalX[k+1]  + "] ");
					}

					int r = 14;
					for (int m=0; m<2; m+=2) {
						allGoals[count][r] = (score[m] + score[m+1]);
						r++;
					}
					System.out.println("\n");
					//****************************************************************************************
					System.out.println("                *****  " + win + " won!  *****         ");
					System.out.println("\n");
					count++;
				}
				while ((count < 20) && (win.toUpperCase().compareTo(fav.toUpperCase()) != 0));

			}	
			else if (i == 15)
				System.out.print("Your team is not in the round of 16");
		}
		System.out.println("\n");

		//***********************************************
		//to display the right message concerning the favorite team
		if (count == 20)
			System.out.println("Sorry, your team didn't win in 20 tournament :(");
		else if (win.toUpperCase().compareTo(fav.toUpperCase()) == 0)
			System.out.println("It took " + fav + " " + (count) + " tournament(s) to win!");
		//************************************************
		//to display the total number of goals during each tournament
		System.out.println("\n");
		System.out.println("Statistics: ");
		for (int d=0; d<count; d++) 
		{
			sum = 0;
			System.out.println();
			//displaying the total number of goals in all of the tournaments played
			System.out.print("#Tournament " + (d  + 1)+"# [Total number of goals] ");
			for (int e=0; e<15; e++)
			{
				//adding the sum of all goals in variable sum to use to find the average 
				System.out.print(allGoals[d][e] + " ");
				sum = sum + allGoals[d][e];
			}
			System.out.println("");
			//finding the average of one tournament 
			avg = sum / 15;		
			//rounding the average to one decimal place
			avgAvg += Math.round(avg * 10.0)/ 10.0;
			System.out.println("[Average] " + Math.round(avg * 10.0)/ 10.0);
		}
		//Finding the average number of goals in the tournament 
		avgAvg = avgAvg / count;
		//loop to find the number of matches with had an above average number of goals.
		for (int f=0; f<count; f++) 
		{
			for (int e=0; e<15; e++)
			{
				if (allGoals[f][e] > avgAvg)
					aboveAvg++;
			}	

		}
		System.out.println("");
		System.out.println("The average total number of goals in a tournament is " + Math.round(avgAvg*10.0)/ 10.0);
		System.out.println("");
		System.out.println("The number of matches with a total goal number of over the average is: " + aboveAvg);
		keyboard.close();
	}
}


