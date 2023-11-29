package JAVA1121;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution("hello", 1, 2));
		
	}
	
	public static String solution(String my_string, int num1, int num2) {
        String answer = "";
        char str1 = my_string.charAt(num1);
        char str2 = my_string.charAt(num2);
        
        char[] strs = my_string.toCharArray();
        
        strs[num1] = str2;
        strs[num2] = str1;
        
        for(char c : strs) {
        	answer += c;
        }
        
        return answer;
    }

}
