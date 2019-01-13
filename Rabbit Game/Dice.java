//---------------------------------------------------------------------
//Assignment 4 - Class dice 
//Date: 23 November 2018
//Written by: Joanna Chin Fong Lau Ah Wing (Student ID:40083829)
//For COMP 248 Section M-X (Nancy Acemian) - Fall 2018
//---------------------------------------------------------------------

import java.util.Random; //methods are exactly those we were asked to create and they are quite self explanatory
public class Dice {
	private int dice1, dice2,sum;
	Random dice = new Random();
	public Dice()
	{
		dice1 = 0;
		dice2 = 0;
	}
	public int getDice1()
	{
		return dice1;
	}
	public int getDice2()
	{
		return dice2;
	}
	public int rollDice()
	{
		dice1 = dice.nextInt(6) + 1;
		dice2 = dice.nextInt(6) + 1;
		sum = dice1 + dice2;
		return sum;
	}
	public String diceToString()
	{
		return ("The content of dice 1 is " + dice1 + " and the content of dice 2 is " + dice2);
	}
}
