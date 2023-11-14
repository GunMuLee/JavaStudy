package JAVA1114;

import java.util.ArrayList;

public class Solution4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int[] solution(int n, int[] numlist) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i : numlist) {
        	if(i % n == 0) {
        		list.add(i);
        	}
        }
        int[] answer = new int[list.size()];
		for(int i = 0 ; i < list.size() ; i++) {
			answer[i] = list.get(i);
		}
		return answer;
    }
}
