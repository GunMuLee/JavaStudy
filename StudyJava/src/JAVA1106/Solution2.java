package JAVA1106;

import java.util.ArrayList;

public class Solution2 {

	public static void main(String[] args) {
		
		solution(12345);
		

	}
	
	public static int[] solution(long n) {
        String[] num = Long.toString(n).split("");
        int[] answer = new int[num.length];
        for(int i = 0 ; i < num.length ; i++) {
        	System.out.println(num[i]);        	
        	answer[i] = Integer.parseInt(num[num.length-i-1]);
        }
        return answer;
    }
	
}
