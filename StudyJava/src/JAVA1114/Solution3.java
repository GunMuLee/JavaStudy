package JAVA1114;

public class Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution("cccCCC"));
		
	}
	public static String solution(String my_string) {
        String answer = "";
        char[] strs = my_string.toCharArray();
        
        for(char i : strs) {
        	if(i < 'a') {
        		i = (char) (i + 32);
        	} else {
        		i = (char) (i - 32);
        	}
        	answer += i;
        }
        
        return answer;
    }
}
