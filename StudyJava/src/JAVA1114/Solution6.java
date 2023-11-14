package JAVA1114;

public class Solution6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static String solution(String rsp) {
        String answer = "";
        char[] strs = rsp.toCharArray();
        for(char i : strs) {
        	if(i == '0') {
        		answer += '5';
        	} else if(i == '5') {
        		answer += '2';
        	} else {
        		answer += '0';
        	}
        }
        return answer;
    }
}
