package com.revature.other;

public class SubClass extends ToImplement {
	
	private String str;

    public SubClass(String str){
        this.str = str;
    }

    public boolean isUppercase(){
        for(char c : this.str.toCharArray()){
            if(Character.isUpperCase(c)) return true;
        }
        return false;
    }

    public String toUpper(String in_str){
        return in_str.toUpperCase();
    }

    public double convertAddTen(String num) throws NumberFormatException, NullPointerException{
        return Double.parseDouble(num);
    }
}
