package JAVA1120;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) {
		/*
		 * 문자열 my_string이 매개변수로 주어질 때,
		 * my_string 안에 있는 숫자만 골라 오름차순 정렬한 리스트를 
		 * return 하도록 solution 함수를 작성해보세요.
		 */
		System.out.println(solution("hi12392"));
	}
	
	public static int[] solution(String my_string) {
        String NumberPattern = "^[\\d]*$";
        ArrayList<Integer> Numbers = new ArrayList<Integer>();
        
        for(String s : my_string.split("")) {
        	if(Pattern.matches(NumberPattern, s)) {
        		Numbers.add(Integer.parseInt(s));
        	}
        }
        Numbers.sort((a,b) -> a-b);
        int[] answer = new int[Numbers.size()];
        
        for(int i = 0 ; i < answer.length ; i++) {
        	answer[i] = Numbers.get(i);
        }
        
        return answer;
    }

}
