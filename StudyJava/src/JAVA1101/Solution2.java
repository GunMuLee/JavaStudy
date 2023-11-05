package JAVA1101;

public class Solution2 {

	public static void main(String[] args) {
		/*
		 * JadenCase란 모든 단어의 첫 문자가 대문자이고,
		 * 그 외의 알파벳은 소문자인 문자열입니다.
		 * 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다.
		 * (첫 번째 입출력 예 참고)문자열 s가 주어졌을 때,
		 * s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
		 * 예시
		 * s							return
			"3people unFollowed me"		"3people Unfollowed Me"
			"for the last week"			"For The Last Week"
		 */
		
		System.out.println(solution(" for   the last week"));
//		System.out.println(solution3(" for   the last week    "));

	}
	
    public static String solution(String s) {
    	String[] strs = s.split("");
    	String result = "";
    	boolean isEmpty = true;
    	
    	for(String i : strs) {
    		
    		result += isEmpty ? i.toUpperCase() : i.toLowerCase();
    		
    		isEmpty = i.equals(" ") ? true : false;
    		
    	}
    	
    	return result;
    }
    
    public static String solution2(String s) {
        // 1. 입력 문자열이 null이거나 빈 문자열인 경우, 원래 문자열을 그대로 반환합니다.
        if (s == null || s.isEmpty()) {
            return s;
        }

        // 2. 결과 문자열을 저장할 StringBuilder를 생성합니다.
        StringBuilder result = new StringBuilder();
        // 3. 다음 단어의 첫 글자를 대문자로 변환해야 함을 나타내는 플래그를 초기화합니다.
        boolean capitalizeNext = true;

        // 4. 입력 문자열을 문자 단위로 순회하기 위한 루프를 시작합니다.
        for (char c : s.toCharArray()) {
            // 5. 현재 문자 c가 알파벳인지 확인합니다.
            if (Character.isLetter(c)) {
                // 6. 다음 단어의 첫 글자를 대문자로 변환해야 하는지 확인합니다.
                if (capitalizeNext) {
                    // 7. 대문자로 변환한 현재 문자 c를 결과 문자열에 추가합니다.
                    result.append(Character.toUpperCase(c));
                    // 8. 다음 단어의 첫 글자를 대문자로 변환할 필요가 없도록 플래그를 변경합니다.
                    capitalizeNext = false;
                } else {
                    // 9. 소문자로 변환한 현재 문자 c를 결과 문자열에 추가합니다.
                    result.append(Character.toLowerCase(c));
                }
            } else {
                // 10. 현재 문자가 알파벳이 아닌 경우(공백 또는 특수 문자 등), 해당 문자를 그대로 결과 문자열에 추가합니다.
                result.append(c);
                // 11. 현재 문자가 공백인 경우, 다음 단어의 첫 글자를 대문자로 변환해야 함을 나타내는 플래그를 설정합니다.
                if (c == ' ') {
                    capitalizeNext = true;
                } else {
                    capitalizeNext = false;
                }
            }
        }

        // 12. 최종 결과 문자열을 문자열로 변환하여 반환합니다.
        return result.toString();

    }
    
    public static String solution3(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
  }

}
