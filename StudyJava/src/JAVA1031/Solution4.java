package JAVA1031;

import java.util.ArrayList;

import JAVA0924.solution05;

public class Solution4 {
	
	public static void main(String[] args) {
		
		/*
		 * 아무 원소도 들어있지 않은 빈 배열 X가 있습니다. 
		 * 양의 정수 배열 arr가 매개변수로 주어질 때, 
		 * arr의 앞에서부터 차례대로 원소를 보면서 원소가 a라면 X의 맨 뒤에 
		 * a를 a번 추가하는 일을 반복한 뒤의 배열 X를 return 하는 solution 함수를 작성해 주세요.
		 * 
		 * 예시
		 * arr	result
			[5, 1, 4]	[5, 5, 5, 5, 5, 1, 4, 4, 4, 4]
			[6, 6]	[6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6]
			[1]	[1]
		 */
		
		int[] array = {5,1,4};
		
		System.out.println(solution(array));
		
	}
	
	public static int[] solution(int[] arr) {
		
        ArrayList<Integer> array = new ArrayList<Integer>();
        
        for(int num : arr) {
        	for (int i = 0; i < num; i++) {
        		array.add(num);
        	}
        }
        
        int[] resultArray = new int[array.size()];
        
        for (int i = 0; i < array.size(); i++) {
            resultArray[i] = array.get(i);
        }
        
        return resultArray;
        
    }
	
	public static int[] solution2(int[] arr) {
		
		 int[] answer = {};

	        int sum = 0;

	        for(int i=0; i<arr.length; i++) {
	            sum += arr[i];    
	        }

	        answer = new int[sum];

	        int idx = 0;

	        for(int i=0; i<arr.length; i++) {
	            for(int j=0; j<arr[i]; j++) {
	                answer[idx++] = arr[i];
	            }
	        }

	        return answer;
		
	}
	
}
