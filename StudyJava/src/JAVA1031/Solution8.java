package JAVA1031;

import java.util.ArrayList;

public class Solution8 {
	public static void main (String[] args) {
		
		/*
		 * 단어가 공백 한 개 이상으로 구분되어 있는 문자열 my_string이 매개변수로 주어질 때, 
		 * my_string에 나온 단어를 앞에서부터 
		 * 순서대로 담은 문자열 배열을 return 하는 solution 함수를 작성해 주세요.
		 * 
		 * my_string			result
			" i    love  you"	["i", "love", "you"]
			"    programmers  "	["programmers"]
		 */
		
		for(String i : solution("i    love  you")) {
			
			System.out.println(i.length());
			System.out.println(i);
		}
		
	}
	
    public static String[] solution(String my_string) {
    	String[] words = my_string.split("\\s+");

        // 빈 문자열 제거
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                result.add(word);
            }
        }

        // ArrayList를 배열로 변환
        return result.toArray(new String[0]);
    }
    
    public static String[] solution2(String my_string) {
    	return my_string.trim().split("[ ]+");
    }
    
    
}
