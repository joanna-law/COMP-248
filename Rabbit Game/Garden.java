//---------------------------------------------------------------------
//Assignment 4 - Class Garden 
//Date: 23 November 2018
//Written by: Joanna Chin Fong Lau Ah Wing (Student ID:40083829)
//For COMP 248 Section M-X (Nancy Acemian) - Fall 2018
//---------------------------------------------------------------------
public class Garden {
	private char [][] myGarden;
	public Garden()
	{
		myGarden = new char[3][3];
		initializeGarden(3);
	}
	
	public Garden(int theSize)
	{
		myGarden = new char[theSize][theSize];
		initializeGarden(theSize);
	}
	private void initializeGarden(int theSize)
	{
		for (int i= 0; i < theSize;i++)
		{
			for (int j= 0; j < theSize;j++)
			{
				myGarden[i][j] = '-';
			}
		}	
	}
	public char getInLocation(int r, int c)
	{
		return myGarden[r][c];
	}
	public void plantFlower(int r, int c)
	{
		myGarden[r][c] = 'f';
	}
	public void plantTree(int r, int c) //changing four spots to t
	{
		myGarden[r][c] = 't';
		myGarden[r+1][c] = 't';
		myGarden[r][c+1] = 't';
		myGarden[r+1][c+1] = 't';
	}
	public void removeFlower(int r, int c)
	{
		myGarden[r][c] = '-';
	}
	public int countPossibleTrees(int theSize)
	{
		char test = '-';
		int posTree = 0;
		for (int i = 0; i < theSize - 1; i++) //compared the location just to the right, just below and diagonaly below and to the right to see if all 4 locations are free for a 2x2 tree
		{
			for (int j = 0; j < theSize -1; j++) //not checking the last row and column to prevent overflow
			{
				if ((myGarden[i][j] == test) && (myGarden[i][j+1] == test) && (myGarden[i+1][j] == test) &&(myGarden[i+1][j+1] == test))
				{
					posTree++;
				}

			}
		}
		return posTree;
	}
	public int countPossibleFlowers(int theSize) //checking all the spots one by one and comparing it to '-' to see if it is empty
	{
		char test = '-';
		int posFlower = 0;
		for (int i = 0; i < theSize; i++)
		{
			for (int j = 0; j < theSize; j++)
			{
				if ((myGarden[i][j] == test))
				{
					posFlower++;
				}

			}
		}
		return posFlower;
	}
	public boolean gardenFull(int theSize) //counts the number of empty spaces and compares it to the total number of spaces available
	{
		char test = '-';
		int totCount = 0;
		for (int i = 0; i < theSize; i++)
		{
			for (int j = 0; j < theSize; j++)
			{
				if ((myGarden[i][j] != test))
				{
					totCount++;
				}

			}
		}
		if (totCount == (theSize*theSize))
			return true;
		else
			return false;

	}
	public String toString(int theSize) //outputs the garden in form of a string by concatenating each part to a variable tot which it later returns
	{
		String tot = "";
		System.out.print("    |   ");
		for (int k = 0; k < theSize; k++)
		{
			tot = tot + k + "   ";
		}
		for (int i = 0; i < theSize; i++)
		{
			tot = tot + '\n';
			tot = tot + '\n';
			tot = tot + (i + "   |   ");
			for (int j = 0; j < theSize; j++)
			{
				tot = tot + (myGarden[i][j] + "   ");
			}
		
		}
		return (tot);
	}
}















