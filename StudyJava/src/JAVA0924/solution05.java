package JAVA0924;

public class solution05 {
	
	public static void main(String[] args) {
		
		/*
		 * 문자 "A"와 "B"로 이루어진 문자열 myString과 pat가 주어집니다. 
		 * myString의 "A"를 "B"로, "B"를 "A"로 바꾼 문자열의 연속하는 부분 문자열 중 pat이 있으면 1을 아니면 
		 * 0을 return 하는 solution 함수를 완성하세요.
		 */
		
		System.out.println(solution("ABBAA", "AABB"));
		
	}
	
	static int solution(String myString, String pat) {
        return myString.replace("A", "b").replace("B", "a").toUpperCase().indexOf(pat) > 0 ? 1 : 0;
    }
	
	static int solution2(String myString, String pat) {
		myString = myString.replace("A", "a").replace("B", "A").replace("a", "B");
        return myString.contains(pat) ? 1 : 0;
	}
	
}
