package JAVA0920;

public class solution2 {
	
	/*
	 * 영소문자로 이루어진 문자열 my_string과 영소문자 1글자로 이루어진 문자열 alp가 매개변수로 주어질 때, 
	 * my_string에서 alp에 해당하는 모든 글자를 
	 * 대문자로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.
	 */
	
	
	public static void main(String[] args) {
		
		System.out.println(solution("programmers","p"));
		System.out.println(solution2("programmers","p"));
		
	}
	
	static String solution(String my_string, String alp) {
		
		char charAlp = alp.charAt(0);
		
		String solution = "";
		
		for(char a : my_string.toCharArray()) {
			if(a == charAlp) {
				a -= 32;
			}
			solution += a;
		}
		
        return solution;
    }
	
	static String solution2(String my_string, String alp) {
		String a = alp.toUpperCase();
		return my_string.replaceAll(alp, a);
	}
	
}
