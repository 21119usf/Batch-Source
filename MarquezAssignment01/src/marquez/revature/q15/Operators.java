package marquez.revature.q15;

/* Write a program that defines an interface having the following methods: addition,
 * subtraction, multiplication, and division. Create a class that implements this interface
 * and provides appropriate functionality to carry out the required operations. Hard code
 * two operands in a test class having a main method that calls the implementing class.
 */

public interface Operators 
{
	void addOperator(int a, int b);
	void subOperator(int a, int b);
	void multOperator(int a, int b);
	void divOperator(int a, int b);
}
