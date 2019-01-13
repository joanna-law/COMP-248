//---------------------------------------------------------------------
//Assignment 3 - Q2 - Class house that is tested in driver "driverHouse"
//Date: 6 November 2018
//Written by: Joanna Chin Fong Lau Ah Wing (Student ID:40083829)
//For COMP 248 Section M-X (Nancy Acemian) - Fall 2018
//---------------------------------------------------------------------

import java.util.Scanner;
public class house {
	//class house that is used in driver "driverHouse"
	Scanner keyboard = new Scanner(System.in);
	//three variables that can be accessed only using the methods, to protect data
	private int age; //stores age of house
	private String type; //stores type of house
	private double cost; //stores cost of house

	//four constructors
	public void noCons()
	{
		age = 50;
		type = "attached";
		cost = 100000;
	}

	public void oneCons(double theCost)
	{
		age = 50;
		type = "attached";
		cost = theCost;
	}

	public void twoCons(double theCost, int theAge)
	{
		age = theAge;
		type = "attached";
		cost = theCost;
	}

	public void threeCons(double theCost, int theAge, String theType)
	{
		age = theAge;
		type = theType;
		cost = theCost;
	}

	//three accessor methods
	public int getAge()
	{
		return age;
	}

	public String getType()
	{
		return type;
	}

	public double getCost()
	{
		return cost;
	}
	//five mutator
	public void setAge(int age)
	{
		this.age = age;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public void setCost(double cost)
	{
		this.cost = cost;
	}

	public void setAll(int age, double cost, String type)
	{
		this.cost = cost;
		this.type = type;
		this.age = age;
	}

	public void setAgeCost(int age, double cost)
	{
		this.age = age;
		this.cost = cost;
	}

	//estimate price method
	public double estimatePrice()
	{
		double price = 0;
		int copyAge;
		copyAge = age;
		if (type.compareTo("attached") == 0)
		{
			price = 100000.0;
			while (copyAge != 0)
			{
				if (copyAge < 6)
					price = (price * 1.01);
				else
					price = (price * 1.02);
				copyAge--;
			}
		}
		else if (type.compareTo("semidetached") == 0)
		{
			
			price = 150000.0;
			while (copyAge != 0)
			{
				if (copyAge < 6)
					price = (price * 1.02);
				else
					price = (price * 1.03);
				copyAge--;
			}
		}
		else if (type.compareTo("detached") == 0)
		{
			price = 200000.0;
			while (copyAge != 0)
			{
				if (copyAge < 6)
					price = (price * 1.02);

				copyAge--;
			}
		}
		return (Math.round(price));

	}
	//method to return type, age and cost of the house
	public String toString()
	{
		return "The housetype is " + type + ", its age is " + age + " and its cost is $"+ cost+ ".";
	}
	//methods to compare between the prices of two objects of class House based on type and age
	public boolean equals(house secondObj)
	{
		if ((getType().equals(secondObj.getType())) && (getAge() == secondObj.getAge()))
			return true;
		else 
			return false;
	}

	//methods to check which estimated price is larger, returns true or false to the statement 
	//did methods to compare both COST and PRICE after x years. The question was a little bit confusing

	public boolean isLessThanPri(house secondObj) 
	{
		return (this.estimatePrice() < (secondObj.estimatePrice()));
		
	}
	public boolean isGreaterThanPri(house second)
	{
		
		return (this.estimatePrice()>(second.estimatePrice()));	
	}
	public boolean isLessThanCost(house secondObj) 
	{
		return (this.cost < (secondObj.cost));
		
	}
	public boolean isGreaterThanCost(house second)
	{
		
		return (this.cost>(second.cost));	
	}

}

