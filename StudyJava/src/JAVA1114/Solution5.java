package JAVA1114;

public class Solution5 {

	public static void main(String[] args) {
		System.out.println(solution("dfjardstddetckdaccccdegk", 4));

	}
	public static String solution(String cipher, int code) {
        String answer = "";
        char[] strs = cipher.toCharArray();
        for(int i = code; i <= strs.length ; i += code){
        	answer += strs[i-1];
        }
        return answer;
    }
}
