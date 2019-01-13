//---------------------------------------------------------------------
//Assignment 3 - Q2 - Program about houses that tests my class house
//Date: 6 November 2018
//Written by: Joanna Chin Fong Lau Ah Wing (Student ID:40083829)
//For COMP 248 Section M-X (Nancy Acemian) - Fall 2018
//---------------------------------------------------------------------

public class driverHouse {
	//driver class
	public static void main (String arg[])
	{
		System.out.println("");
		System.out.println("***********************************************************");
		System.out.println("");
		System.out.println("             Welcome to the house class test");
		System.out.println("");
		System.out.println("***********************************************************");
		
		//declares 4 house objects using 4 different constructors 
		house house1 = new house();
		house house2 = new house();
		house house3 = new house();
		house house4 = new house();
		
		//calling constructors to create the objects houses 1 to 4
		house1.noCons();
		house2.oneCons(100000.0);
		house3.twoCons(120000.0, 4);
		house4.threeCons(220000.0, 2, "detached");
		
		//output descriptions of the 4 houses
		System.out.println("");
		System.out.println("House H1: This house is of type " + house1.getType() + ". Its age is " + house1.getAge() + " and costs $" + house1.getCost());
		System.out.println("House H2: This house is of type " + house2.getType() + ". Its age is " + house2.getAge() + " and costs $" + house2.getCost());
		System.out.println("House H3: This house is of type " + house3.getType() + ". Its age is " + house3.getAge() + " and costs $" + house3.getCost());
		System.out.println("House H4: This house is of type " + house4.getType() + ". Its age is " + house4.getAge() + " and costs $" + house4.getCost());
		System.out.println("");
		System.out.println("Accessor Method: The housetype for house H4 is " + house4.getType() + ", its age is " + house4.getAge() + ", and it costs " + house4.getCost());
		System.out.println("");
		System.out.println("The estimated price of house H3 is $" + house3.estimatePrice());
		System.out.println("The estimated price of house H4 is $" + house4.estimatePrice());
		System.out.println("");
		
		//Checking mutator methods
		house3.setAge(5);
		System.out.println("Mutator Method: The new age for house H3 is " + house3.getAge());
		house3.setType("semidetached");
		System.out.println("Mutator Method: The new type for house H3 is " + house3.getType());
		house3.setCost(240000.0);
		System.out.println("Mutator Method: The new cost for house H3 is " + house3.getCost());
		house3.setAgeCost(6, 245000.0);
		System.out.println("Mutator Method: The new age for house H3 is " + house3.getAge() + " and the new cost of house H3 is " + house3.getCost());
		house3.setAll(14, 260000.0, "semidetached");
		System.out.println("Mutator Method: The new type for house H3 is " + house3.getType() + ", its new age is " + house3.getAge() + " and its new cost is " + house3.getCost());
		System.out.println("");
		
		//checking toString method
		System.out.println("toString: " + house3.toString());
		
		//checking equal method
		System.out.println("");
		System.out.println("House H1 and H2 are equal is " + house1.equals(house2));
		System.out.println("House H1 and H4 are equal is " + house1.equals(house4));
		System.out.println("");
		//outputing both for cost and price because question is ambiguous.
		System.out.println("House H4 PRICE is less than H3 is " + house4.isLessThanPri(house3));
		System.out.println("House H1 PRICE is greater than H3 is " + house1.isGreaterThanPri(house3));
		System.out.println("");
		System.out.println("House H4 COST is less than H3 is " + house4.isLessThanCost(house3));
		System.out.println("House H1 COST is greater than H3 is " + house1.isGreaterThanCost(house3));
		System.out.println("");
		System.out.println("***********************************************************");
		System.out.println("");
		System.out.println("Thank you for using the tester program! Have a nice day.");
		System.out.println("");

	}
}
