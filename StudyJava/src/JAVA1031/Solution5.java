package JAVA1031;

public class Solution5 {

	public static void main(String[] args) {
		/*
		 * 어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다. 
		 * 예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다. 
		 * 문자열 my_string과 is_suffix가 주어질 때, 
		 * is_suffix가 my_string의 접미사라면 1을, 아니면 0을 return 하는 solution 함수를 작성해 주세요.
		 * 
		 * 예시
		 * 
		 * my_string	is_suffix	result
			"banana"	"ana"	1
			"banana"	"nan"	0
			"banana"	"wxyz"	0
			"banana"	"abanana"	0
		 */
		
		System.out.println(solution("banana", "ana"));
		
	}
	
	public static int solution(String my_string, String is_suffix) {
		return is_suffix.equals(my_string.substring(my_string.length()-is_suffix.length())) && my_string.length() >= is_suffix.length() ? 1 : 0;
	}
	
	public static int solution2(String my_string, String is_suffix) {
		if(my_string.endsWith(is_suffix)) {
            return 1;
        } else {
            return 0;
        }
	}

}
