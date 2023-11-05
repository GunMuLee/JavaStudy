package JAVA1031;

public class Solution2 {

	public static void main(String[] args) {

		/*
		 * 정수로 이루어진 문자열 n_str이 주어질 때, n_str의 가장 
		 * 왼쪽에 처음으로 등장하는 0들을 뗀 문자열을 return하도록
		 * solution 함수를 완성해주세요.
		 * 
		 * 예시
		 * n_str	result
			"0010"		"10"
			"854020"	"854020"
		 */
		
		System.out.println(solution("0010"));
		System.out.println(solution2("0010"));

	}
	
	public static String solution(String n_str) {
		
		int i = 0;
		
		while (i < n_str.length() && n_str.charAt(i) == '0') {
			i++;
		}
      
        return n_str.substring(i);
    }
	
	public static String solution2(String n_str) {
		
		return "" + Integer.parseInt(n_str);
	}

}
