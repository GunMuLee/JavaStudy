package JAVA0923;

	import java.util.*;

public class solution5 {
	
	public static void main (String[] args) {
		/*
		 * 정수로 이루어진 리스트 num_list가 주어집니다. 
		 * num_list에서 가장 작은 5개의 수를 오름차순으로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
		 * 
		 * 	num_list					result
			[12, 4, 15, 46, 38, 1, 14]	[1, 4, 12, 14, 15]
		 * 
		 */
		
		int[] a = {1, 2, 3, 100, 99, 98};
		
		for(int num : solution2(a)) {
			System.out.println(num);
		}
		
	}
	
    static int[] solution(int[] num_list) 	{
        Arrays.sort(num_list);
        int[] answer = new int[5];
        for(int i = 0 ; i < answer.length ; i++) {
        	answer[i] = num_list[i];
        }
        return answer;
    }
    
    static int[] solution2(int[] num_list) {
        return Arrays.stream(num_list)
            .sorted()
            .limit(5)
            .toArray();
    }

	
}
