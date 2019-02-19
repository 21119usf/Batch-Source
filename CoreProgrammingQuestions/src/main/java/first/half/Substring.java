package first.half;

public class Substring {
	
	public static String getSubstring(String str, int idx){
		String result = "";
		char[] chars = str.toCharArray();
		for(int i = 0; i < idx; i++) {
			result += chars[i];
		}
		return result;
	}

}
