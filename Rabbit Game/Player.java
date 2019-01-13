//---------------------------------------------------------------------
//Assignment 4 - Class player
//Date: 23 November 2018
//Written by: Joanna Chin Fong Lau Ah Wing (Student ID:40083829)
//For COMP 248 Section M-X (Nancy Acemian) - Fall 2018
//---------------------------------------------------------------------
import java.util.Random; //random is used to generate a location for the rabbit to eat from
public class Player 
{
Random Rand = new Random();
	private String name;
	private Garden myGarden;
	
	public Player(String theName, int theSize) //constructor
	{
		name = theName;
		myGarden = new Garden(theSize);
	}
	public String getName()
	{
		return name;
	}
	public int howManyFlowersPossible(int theSize)
	{
		return myGarden.countPossibleFlowers(theSize);
	}
	public int howManyTreesPossible(int theSize)
	{
		return myGarden.countPossibleTrees(theSize);
	}
	public char whatIsPlanted(int r, int c)
	{
		return myGarden.getInLocation(r, c);
	}
	public void plantTreeInGarden(int r, int c)
	{
		myGarden.plantTree(r, c);
	}
	public void plantFlowerInGarden(int r, int c)
	{
		myGarden.plantFlower(r, c);
	}
	public void eatHere(int size)
	{
		boolean foundPlant = false; //check if the spot has a plant
		do //loop to ensure that the location has a plant
		{
			int rabbitEatRow = Rand.nextInt(size);
			int rabbitEatCol = Rand.nextInt(size);
			char tempRemove = (myGarden.getInLocation(rabbitEatRow, rabbitEatCol)); 
			if ((tempRemove == 'f') || (tempRemove == 't')) //checking if the spot has a plant to remove
			{
				foundPlant = true;
				myGarden.removeFlower(rabbitEatRow, rabbitEatCol);
				System.out.println("Row and Col removed: " + rabbitEatRow + " " + rabbitEatCol);
			}
		}
		while (foundPlant != true);
	}
	public boolean isGardenFull(int theSize)
	{
		return myGarden.gardenFull(theSize);
	}
	public String showGarden(int theSize)
	{
	return (myGarden.toString(theSize));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
