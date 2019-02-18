package com.revature.exceptions;

import java.util.Scanner;

class MainClass
{
	public static void main(String[] args) 
	{
		HatPerson bob = new HatPerson();
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) 
		{
			System.out.println("Would you like to put on or take off your hat? ");
			switch (scanner.nextLine())
			{
			case "put on" :
				bob.putOnHat();
				break;
			
			case "take off" :
				bob.takeOffHat();
				break;
				
			default :
				System.out.println("That is not an option.");
			}
		}
	}
}

class HatPerson
{
	boolean isWearingHat;
	
	public HatPerson()
	{
		isWearingHat = false;
	}
	
	public void putOnHat()
	{
		if(isWearingHat != true)
		{
			isWearingHat = true;
		}
		else
		{
			throw new ToManyHatsException();
		}
	}
	
	public void takeOffHat()
	{
		if(isWearingHat != false)
		{
			isWearingHat = false;
		}
		else
		{
			throw new NotWearingAHatException();
		}
	}
}

