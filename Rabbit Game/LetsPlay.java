//---------------------------------------------------------------------
//Assignment 4 - Driver class LetsPlay
//Date: 23 November 2018
//Written by: Joanna Chin Fong Lau Ah Wing (Student ID:40083829)
//For COMP 248 Section M-X (Nancy Acemian) - Fall 2018
//---------------------------------------------------------------------
import java.util.Scanner;
public class LetsPlay {	
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		int size = 0; //stores the size of the garden
		int sizeChoice; //menu choice for either basic or custom size
		int noPlayers;; //the number of players
		String maxName = ""; //stores the name of the player with the largest score
		int maxDice = 0; //stores the maximum dice sum that occurred
		Dice myDices = new Dice(); //new dice object
		int [] scores = new int[10]; //array storing the scores of the players to know who goes first.
		int count = 0; //counting the number of times a score occurred. Used to check who plays first
		String plantPositionString; //holds the input of the user for the location to plant in
		int firstPlayerNo = 0; //stores the position of the person who is first in the array
		int rowPos = 0, colPos = 0; //integer version of the plantPosition
		int countRound = 1; //used to display the round currently in
		boolean foundPlace; //checks to see if the space is free
		boolean foundSize = false; //checks if choice of either custom or not is chosen
		String winner = ""; //stores the name of the winner
		boolean winnerFound = false; //used to check if a winner was found
		String needToPlant1; //stores what to plant to prevent repetition in the loop below
		String needToPlant2; //two of them because one can plant a maximum of two plants
		//banner
		System.out.println("------*****------*****------*****------*****------*****------*****------");
		System.out.println("");
		System.out.println("                Welcome to Crazy Nancy's Garden Game!");
		System.out.println("");
		System.out.println("------*****------*****------*****------*****------*****------*****------");
		System.out.println("");
		System.out.println("Here are the rules:");//rules
		System.out.println("");
		System.out.println(" - The aim of the game is to fill your garden first.");
		System.out.println(" - Determine who goes 1st: each player rolls 2 dice. The player with the highest roll goes first.\r\n" + 
				" - How ever if any player rolls the same total, this process starts over again.");
		System.out.println(" - Each player has a turn until there is a winner. During his/her turn a player:\r\n" + 
				"     a. Rolls the 2 dice.\r\n" + 
				"     b. Based on the outcome gets to plant a pre-set number of trees and/or flowers.");
		System.out.println("           Total of roll: [3] : Plant a tree and a flower");
		System.out.println("           Total of roll: [6] : Plant two flowers");
		System.out.println("           Total of roll: [12] : Plant two trees");
		System.out.println("           Total of roll: [5, 10] : The rabbit that lives in your garden will eat something that you planted.");
		System.out.println("           Total of roll: [2, 4, 8] : Plant a tree");
		System.out.println("           Total of roll: [7, 9, 11] : Plant a flower");
		System.out.println(" - If you cannot place the plant then you lose your turn.");
		System.out.println("");
		System.out.println("------*****------*****------*****------*****------*****------*****------");
		System.out.println("");
		//asking for size
		do
		{
			System.out.print("Press 1 for default [3*3] grid or press 2 for custom size: ");
			sizeChoice = keyboard.nextInt();
			if (sizeChoice == 2)
			{
				foundSize = true;
				System.out.print("Please input custom size: ");
				do
				{
					size = keyboard.nextInt();
					if (size < 3)
						System.out.print("Custom size out of range. Input again: ");
				}
				while (size < 3);
			}
			else if (sizeChoice == 1)
			{
				size = 3;
				foundSize = true;
			}
			else
				System.out.println("Error chose 1 or 2 only");
		}
		while (foundSize == false);

		System.out.println("");
		System.out.print("Number of players: "); //asking for no of players
		do //validation to have the appropriate number of players
		{
			noPlayers = keyboard.nextInt();
			if ((noPlayers < 2)|| (noPlayers >10))
				System.out.print("Number of players out of range. Input again: ");
		}
		while ((noPlayers < 2)|| (noPlayers >10));
		System.out.println("");
		Player[] arrayPlayer = new Player[(noPlayers + 1)];
		for (int i = 0; i < (noPlayers); i++)
		{
			System.out.print("Player " + i + "'s name: ");
			arrayPlayer[i] = new Player(keyboard.next(), size); //initializing the array player
		}
		System.out.println("");
		System.out.println("------*****------*****------*****------*****------*****------*****------");
		System.out.println("");
		//showing the array player
		for (int i = 0; i < (noPlayers); i++)
		{ 
			System.out.print("Player " + i + "'s name: ");
			System.out.println(arrayPlayer[i].getName());
			System.out.println("Player " + i + "'s garden: ");
			System.out.println(arrayPlayer[i].showGarden(size));
			System.out.println();
		}
		System.out.println("------*****------*****------*****------*****------*****------*****------");
		System.out.println();
		//using dice class to know which of the players goes first
		for (int k = 0; k < 1; k++)
		{
			for (int i = 0; i < (noPlayers); i++) //rolling dices for everyone
			{
				scores[i] = myDices.rollDice();
				System.out.println("The score of " + arrayPlayer[i].getName() + " is: " + scores[i] );
			}
			for (int i = 0; i < (noPlayers); i++) //finding what the maximum score is
			{
				if (scores[i] > maxDice) 
				{
					maxDice = scores[i];
					maxName = arrayPlayer[i].getName();
					firstPlayerNo = i;
				}
			}
			count =0; 
			for (int m = 0; m < (noPlayers); m++) //counts to see if more than one player has the same max score
			{
				if (maxDice == scores[m])
					count++;
			}
			if (count > 1) //if count is greater 1 then start again
			{
				System.out.println("Two or more players have the same highest score of " + maxDice + ". Throwing dices again.");
				System.out.println();
				k = -1;
				maxDice = 0;
			}
		}
		System.out.println();
		System.out.println("Player with the largest score is: " + maxName + " with a score of : " + maxDice);
		System.out.println(maxName + " goes first.");
		System.out.println();
		System.out.println("------*****------*****------*****------*****------*****------*****------");
		System.out.println();
		//the actual game
		System.out.println("        ROUND 1");
		for(int j = 0; j < noPlayers; j++) //rolling dice for the next turns around the table
		{
			scores[j] = myDices.rollDice();
		}
		//the turns
		for(int k = firstPlayerNo; k < noPlayers; k++) //starting the game with the player with the largest score
		{
			System.out.println("");
			System.out.println("");
			needToPlant1 = "";
			needToPlant2 = "";
			System.out.println(arrayPlayer[k].getName() + " you rolled  " + scores[k] + " (Die 1: " + myDices.getDice1() + "  Die 2: " + myDices.getDice2() + ")");
			if (scores[k] == 3) //an if statement for each of the different possible scores one could get, setting the variables holding what to plant later
			{
				System.out.println("You must plant a tree (2x2) and a flower (1x1)");
				System.out.println("");
				needToPlant1 = "tree";
				needToPlant2 = "flower";
			}
			else if (scores[k] == 6)
			{
				System.out.println("You must plant two flowers 2 * (1x1)");
				System.out.println("");
				needToPlant1 = "flower";
				needToPlant2 = "flower";
			}
			else if (scores[k] == 12)
			{
				System.out.println("You must plant two trees 2 * (2x2)");
				System.out.println("");
				needToPlant1 = "tree";
				needToPlant2 = "tree";
			}
			else if (scores[k] == 5 || scores[k] == 10)
			{
				System.out.println("The rabbit that lives in your garden will eat something that you planted (1x1). It will be determined randomly.");
				if (arrayPlayer[k].howManyFlowersPossible(size) != (size * size))
				{
					System.out.println(arrayPlayer[k].showGarden(size));	
					arrayPlayer[k].eatHere(size);
					System.out.println("Eaten up garden:");
					System.out.println();
				}
				else
				{
					System.out.println("Sorry rabbit, nothing to eat!");
				}
			}
			else if ((scores[k] == 2) || (scores[k] == 4) || (scores[k] == 8))
			{
				System.out.println("You must plant a tree (2x2)");
				System.out.println("");
				needToPlant1 = "tree";
			}
			else if ((scores[k] == 7) || (scores[k] == 9) || (scores[k] == 11))
			{
				System.out.println("You must plant a flower (1x1)");
				System.out.println("");
				needToPlant1 = "flower";
			}

			//code that plant
			System.out.println(arrayPlayer[k].showGarden(size));
			System.out.println();
			//code to check what to plant and thus what actions to do and what to output
			if ((needToPlant1.length() == 4) && (winnerFound == false)) //four is the length of "tree". this one is for the first plant
			{
				System.out.println("and you have " + arrayPlayer[k].howManyTreesPossible(size) + " possible places where you can put your first tree");
				if (arrayPlayer[k].howManyTreesPossible(size) == 0) //checking to see if the player can plant
				{
					System.out.println("*Sorry no room left to plant a tree - You misss a turn");
				}

				else
				{
					foundPlace = false; //reset variable foundPlace as it will be used in several turns
					do //loop to ensure that the space the user chose is free
					{
						System.out.print("Enter coordinated as row column: ");
						plantPositionString = keyboard.next(); //user is to input in "2 2" format
						plantPositionString = plantPositionString + " ";
						plantPositionString = plantPositionString + keyboard.next();
						rowPos = Integer.parseInt(plantPositionString.substring(0,1));
						colPos = Integer.parseInt(plantPositionString.substring(2,3));
						if ((rowPos < (size -1)) && (colPos < (size -1)))
						{
							if ((arrayPlayer[k].whatIsPlanted(rowPos,colPos) == '-') && (arrayPlayer[k].whatIsPlanted(rowPos,colPos + 1) == '-') && (arrayPlayer[k].whatIsPlanted(rowPos + 1,colPos) == '-') && (arrayPlayer[k].whatIsPlanted(rowPos + 1,colPos + 1) == '-'))
							{ //checked if all the four places are free
								arrayPlayer[k].plantTreeInGarden(rowPos,colPos);
								System.out.println(arrayPlayer[k].showGarden(size));
								System.out.println("");
								foundPlace = true;
							}
							else
								System.out.println("Space is already occupied");
						}
						else
							System.out.println("Space is outside of the garden");
						if (arrayPlayer[k].isGardenFull(size) == true)
						{
							winner = arrayPlayer[k].getName();
							winnerFound = true;
							k = 999;
						}
					}
					while (foundPlace != true);
				}
			}
			if ((needToPlant2.length() == 4) && (winnerFound == false))//this one is to check if the second plant variable is a tree
			{
				System.out.println("and you have " + arrayPlayer[k].howManyTreesPossible(size) + " possible places where you can put your second tree");
				if (arrayPlayer[k].howManyTreesPossible(size) == 0) //checking to see if the player can plant
				{
					System.out.println("*Sorry no room left to plant a tree - You misss a turn");
				}

				else
				{
					foundPlace = false;
					do
					{
						System.out.print("Enter coordinates as row column: ");
						plantPositionString = keyboard.next(); //user is to input in "2 2" format
						plantPositionString = plantPositionString + " ";
						plantPositionString = plantPositionString + keyboard.next();
						rowPos = Integer.parseInt(plantPositionString.substring(0,1));
						colPos = Integer.parseInt(plantPositionString.substring(2,3));
						if ((rowPos < (size)) && (colPos < (size))) //checking if inside of grid
						{
							if ((arrayPlayer[k].whatIsPlanted(rowPos,colPos) == '-') && (arrayPlayer[k].whatIsPlanted(rowPos,colPos + 1) == '-') && (arrayPlayer[k].whatIsPlanted(rowPos + 1,colPos) == '-') && (arrayPlayer[k].whatIsPlanted(rowPos + 1,colPos + 1) == '-'))
							{//checking if occupied
								arrayPlayer[k].plantTreeInGarden(rowPos,colPos);
								System.out.println(arrayPlayer[k].showGarden(size));
								System.out.println("");
								foundPlace = true;
							}
							else
								System.out.println("Space is already occupied");
						}
						else
							System.out.println("Space is outside of the garden");
						if (arrayPlayer[k].isGardenFull(size) == true)
						{
							winner = arrayPlayer[k].getName();
							winnerFound = true;
							k = 999;
						}
					}
					while (foundPlace != true);
				}
			}
			if ((needToPlant1.length() == 6) && (winnerFound == false)) //six is the length of "flower"
			{
				System.out.println("and you have " + arrayPlayer[k].howManyFlowersPossible(size) + " possible places where you can put your first flower");
				if (arrayPlayer[k].howManyFlowersPossible(size) == 0) //checking to see if the player can plant
				{
					System.out.println("*Sorry no room left to plant a flower - You misss a turn");
				}

				else
				{
					foundPlace = false;
					do
					{
						System.out.print("Enter coordinated as row column: ");
						plantPositionString = keyboard.next(); //user is to input in "2 2" format
						plantPositionString = plantPositionString + " ";
						plantPositionString = plantPositionString + keyboard.next();
						rowPos = Integer.parseInt(plantPositionString.substring(0,1));
						colPos = Integer.parseInt(plantPositionString.substring(2,3));
						if ((rowPos < (size)) && (colPos < (size)))
						{
							if (arrayPlayer[k].whatIsPlanted(rowPos,colPos) == '-') 
							{
								arrayPlayer[k].plantFlowerInGarden(rowPos,colPos);
								System.out.println(arrayPlayer[k].showGarden(size));
								System.out.println("");
								foundPlace = true;
							}
							else
								System.out.println("Space is already occupied");
						}
						else
							System.out.println("Space is outside of the garden");
						if (arrayPlayer[k].isGardenFull(size) == true)
						{
							winner = arrayPlayer[k].getName();
							winnerFound = true;
							k = 999;
						}
					}
					while (foundPlace != true);
				}
			}
			if ((needToPlant2.length() == 6) && (winnerFound == false))
			{
				System.out.println("and you have " + arrayPlayer[k].howManyFlowersPossible(size) + " possible places where you can put your second flower");
				if (arrayPlayer[k].howManyFlowersPossible(size) == 0) //checking to see if the player can plant
				{
					System.out.println("*Sorry no room left to plant a flower - You misss a turn");
				}

				else
				{
					foundPlace = false;
					do
					{
						System.out.print("Enter coordinated as row column: ");
						plantPositionString = keyboard.next(); //user is to input in "2 2" format
						plantPositionString = plantPositionString + " ";
						plantPositionString = plantPositionString + keyboard.next();
						rowPos = Integer.parseInt(plantPositionString.substring(0,1));
						colPos = Integer.parseInt(plantPositionString.substring(2,3));
						if ((rowPos < (size)) && (colPos < (size)))
						{
							if ((arrayPlayer[k].whatIsPlanted(rowPos,colPos) == '-'))
							{
								arrayPlayer[k].plantFlowerInGarden(rowPos,colPos);
								System.out.println(arrayPlayer[k].showGarden(size));
								System.out.println("");
								foundPlace = true;
							}
							else
								System.out.println("Space is already occupied");
						}
						else
							System.out.println("Space is outside of the garden");if (arrayPlayer[k].isGardenFull(size) == true)
						{
							winner = arrayPlayer[k].getName();
							winnerFound = true;
							k = 999;
						}
					}
					while (foundPlace != true);
				}
			}
			if (k == (firstPlayerNo -1)) //used to display what round is currently played.
			{
				countRound++;
				System.out.println("");
				System.out.println("");
				System.out.println("        ROUND " + countRound);
			}
			//end of code to plant
			if (k == (noPlayers -1)) //to start the loop back at zero and go to the first player in the array
			{
				k = -1;
				for(int j = 0; j < noPlayers; j++) //rolling dice for the next turns around the table
				{
					scores[j] = myDices.rollDice(); 
				}
			}
		}
		System.out.println("");
		System.out.println("FINAL RESULTS");
		System.out.println("-------------");
		System.out.println("Here are the gardens after " + countRound + " rounds");
		System.out.println("");
		for (int i = 0; i < noPlayers; i++)
		{
			System.out.println(arrayPlayer[i].getName() + "'s garden: ");
			System.out.println(arrayPlayer[i].showGarden(size));
			System.out.println("");
		}
		System.out.println("");
		System.out.println("And the winner is...." + winner + "!");
		System.out.println("What a beautiful garden!");
		System.out.println("");
		System.out.println("Hope you had fun! :D");

		keyboard.close();
	}

}

