package marquez.revature.q18;

public class UppercaseString extends StringCheck 
{

	@Override
	public void checkUppercase(String str)
	{
		boolean isUppercase = false;
		String tempStr = str.toUpperCase();
		if(tempStr.equals(str))
		{
			isUppercase = true;
			System.out.println(isUppercase);
		}
		else
		{
			System.out.println(isUppercase);
		}
	}

	@Override
	public void convertUppercase(String str) 
	{
		System.out.println(str.toUpperCase());
	}

	@Override
	public void convertString(String str) 
	{
		int result = Integer.parseInt(str) + 10;
		System.out.println(result);
	}
	
	
}
	

