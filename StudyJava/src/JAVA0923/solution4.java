package JAVA0923;

import java.util.*;

public class solution4 {
	
	public static void main (String[] args) {
		/*
		 * 정수 배열 arr가 주어집니다. arr의 각 원소에 대해 값이 50보다 크거나 같은 짝수라면 2로 나누고,
		 * 50보다 작은 홀수라면 2를 곱합니다.
		 * 그 결과인 정수 배열을 return 하는 solution 함수를 완성해 주세요.
		 * 
		 * arr						result
		 * [1, 2, 3, 100, 99, 98]	[2, 2, 6, 50, 99, 49]
		 * 
		 */
		
		int[] a = {1, 2, 3, 100, 99, 98};
		
		System.out.println(solution(a));
		System.out.println(solution2(a));
		
	}
	
    static int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        for(int i = 0 ; i < arr.length; i++){
            answer[i] = arr[i]>50||arr[i]%2==0 ? arr[i]/2 : arr[i]<50||arr[i]%2!=0 ? arr[i]*2 : arr[i];
        }
        return answer;
    }
    
    static int[] solution2(int[] arr) {
    	return Arrays.stream(arr).map(operand -> operand >= 50 && operand % 2 == 0 ? operand / 2 : operand < 50 && operand % 2 == 1 ? operand * 2 : operand).toArray();
    }
	
}
