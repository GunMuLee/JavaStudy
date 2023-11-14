package JAVA1114;

public class Solution {
	
	public static void main(String[] args) {
		
	}
	
	public static String solution (String myString) {
        String answer = "";
        char[] strs = myString.toCharArray();
        for(char i : strs) {
        	if('i' > i) {
        		i = 'i';
        	}
        	answer += i;
        }
        return answer;
    }
	
}
