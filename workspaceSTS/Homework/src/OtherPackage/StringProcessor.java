package OtherPackage;

public class StringProcessor extends processString {

	@Override
	public boolean anyUpperCase(String str) {
		String lowercase = str.toLowerCase();
		return !(lowercase.equals(str));
	}

	@Override
	public String convertToUpperCase(String str) {
		return str.toUpperCase();
	}

	@Override
	public int add10(String str) {
		return Integer.parseInt(str) + 10;
	}
}
