package second.half;

public class MathImplementation implements MathInterface {
	
private static MathImplementation instance;
	
	private MathImplementation() {
		
	}
	
	public static synchronized MathImplementation getIntance() {
		
		if(instance == null) {
			instance = new MathImplementation();
		}
		return instance;
		
	}

	@Override
	public double add(double... x) {
		
		double result = 0;
		
		for(double i : x)
			result += i;
		
		return result;
		
	}

	@Override
	public double subtract(double x, double y) {
		return x - y;
		
	}

	@Override
	public double divide(double x, double y) {
		return  x / y;
		
	}

	@Override
	public double multiply(double... x) {
		double result = 1;
		
		for(double i : x)
			result = result * i;
		
		return result;
		
	}

}
