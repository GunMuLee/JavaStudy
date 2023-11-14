package JAVA1107;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.IntFunction;

public class Solution4 {

	public static void main(String[] args) {
		/*
		 * 문제 설명
		정수 리스트 num_list와 정수 n이 주어질 때, 
		num_list를 n 번째 원소 이후의 원소들과 n 번째까지의 원소들로 나눠 
		n 번째 원소 이후의 원소들을 n 번째까지의 원소들 앞에 붙인 리스트를 return하도록 solution 함수를 완성해주세요.

		제한사항
		2 ≤ num_list의 길이 ≤ 30
		1 ≤ num_list의 원소 ≤ 9
		1 ≤ n ≤ num_list의 길이
		입출력 예
		num_list	n	result
		[2, 1, 6]	1	[1, 6, 2]
		[5, 2, 1, 7, 5]	3	[7, 5, 5, 2, 1]
		 */
		
		int[] nums = {2, 1, 6};
		for(int i : solution(nums, 1)) {
			System.out.println(i);
		}

	}
	public static int[] solution(int[] num_list, int n) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = n ; i < num_list.length ; i++){
        	list.add(num_list[i]);
        }
        for(int i = 0 ; i < n ; i++){
        	list.add(num_list[i]);
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
	
	public static int[] solution2(int[] num_list, int n) {
        int idx = 0;
        int[] answer = new int[num_list.length];
        for (int i = n;i < num_list.length;i++)
            answer[idx++] = num_list[i];
        for (int i = 0;i < n;i++)
            answer[idx++] = num_list[i];
        return answer;
    }
	
}
