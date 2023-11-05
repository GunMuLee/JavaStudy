package JAVA1104;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution("baabaa"));
		
	}
	
	public static int solution(String s) {
		Stack<Character> stack = new Stack<>(); // 문자 스택을 생성

	    for (char c : s.toCharArray()) {
	        if (!stack.isEmpty() && stack.peek() == c) {
	            // 스택이 비어있지 않고, 스택의 맨 위 문자가 현재 문자와 같다면 짝을 이룸
	            stack.pop(); // 스택에서 짝을 이룬 문자를 제거
	        } else {
	            // 짝을 이루지 않는 경우, 현재 문자를 스택에 추가
	            stack.push(c);
	        }
	    }

	    // 스택이 비어있으면 모든 문자가 짝지어 제거되었음을 의미
	    return stack.isEmpty() ? 1 : 0; // 스택이 비어있으면 1을 반환, 그렇지 않으면 0을 반환
	}
	
}
