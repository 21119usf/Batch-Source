package come.revature.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {
	/*Reflection
	 * a way for Java to inspect itself at runtime
	 * break encapsulation!
	 * Contains methods for runtime inspection of objects
	 *  - Class of object
	 *  - Fields
	 *  - Methods
	 *  - Constructors
	 *  - This includes private members
	 * Can modify or instantiate things, invoke, etc.
	 * java.lang.reflect
	 */
	
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("java.awt.Dimension");
			System.out.print("Constructors: ");
			Constructor<?> con [] = c.getConstructors();
			for (int i = 0; i < con.length; i++) {
				System.out.println(" " + con[i]);
			}
			System.out.print("\nFields: ");
			Field f[] = c.getFields();
			for (int i = 0; i < f.length; i++) {
				System.out.println(" " + f[i]);
			}
			System.out.print("\nMethods: ");
			Method m[] = c.getMethods();
			for (int i = 0; i < m.length; i++) {
				System.out.println(" " + m[i]);
			}
		}
		catch (Exception e) {
			
		}
	}
}
