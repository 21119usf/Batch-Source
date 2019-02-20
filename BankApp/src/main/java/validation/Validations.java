package validation;

public class Validations 
{
	// Validate username
	public static boolean validUsername(String un)
	{
		if (un.length() < 3) 
		{
			return false;
		}
		return true;
	}
	// Validate password
	public static boolean validPassword(String pw) 
	{
		if (pw.length() < 6) 
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
		
	// Validate phone number
	public static boolean validPhoneNumber(long pn) 
	{
		if (String.valueOf(pn).length() != 10)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
		
	// Validate social security number
	public static boolean validSsNumber(long ss)
	{
		if (String.valueOf(ss).length() != 9) 
		{
			return false;
		}
		return true;
	}
}
