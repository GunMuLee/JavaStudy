package JAVA1117;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		System.out.println(solution("oxooxoxxox"));
		

	}
	public static int[] solution(String myString) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int count = 0;
		for(char c : myString.toCharArray()) {
			if(c == 'x') {
				list.add(count);
				count = 0;
			} else {
				count ++;
			}
		}
		
        int[] answer = new int[list.size()];
        
        for(int i = 0 ; i < list.size() ; i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }

}
