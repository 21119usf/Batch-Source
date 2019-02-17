package com.revature.homework;
import java.util.ArrayList;
public class Q8 {
    
    ArrayList<String> x;
    ArrayList<String> y;
    
    Q8(ArrayList<String> x, ArrayList<String> y){ 
        this.x = x; 
        this.y = y; 
    }
    public ArrayList<String> storage(String[] str) {
        this.x = new ArrayList<String>(); 
        for(String c : str) {
            this.x.add(c);
        }
    return this.x; 
    }
    
    public boolean palin(String s) {
        int begin = 0;
        int finish = s.length() - 1;
            while(begin < finish) {
                if(s.charAt(begin) != s.charAt(finish))
                    break;
                begin++;
                finish--;
            }
            
            if(begin >= finish)
                return true; 
            else
                return false; 
    }
    
    public ArrayList<String> contain(String[] str) {
        this.y = new ArrayList<String>();
        for(String i : str) {
            if(palin(i)) {
                this.y.add(i);
            }
        }
    return this.y; 
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] s1 = {"karen", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"};
        
        ArrayList<String> storage = new ArrayList<String>(); 
        ArrayList<String> contain = new ArrayList<String>(); 
        
        Q8 x = new Q8(storage, contain);
    
        for(String l : x.storage(s1)) {
            System.out.print(l + " ");
        }
        
        System.out.println();
        
        for(String l1 : x.contain(s1))
            System.out.print(l1 + " ");   
    }
}
