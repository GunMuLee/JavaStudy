package JAVA1106;

public class Solution {

	public static void main(String[] args) {
		/*
		 * 정수 리스트 num_list가 주어질 때, 
		 * 마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을 마지막 원소가 
		 * 그전 원소보다 크지 않다면 마지막 원소를 두 배한 값을 추가하여 return하도록 solution 함수를 완성해주세요.
		 * 입출력 예
		num_list	result
		[2, 1, 6]	[2, 1, 6, 5]
		[5, 2, 1, 7, 5]	[5, 2, 1, 7, 5, 10]
		 */
		int[] num_list = {5, 2, 1, 7, 5};
		for(int i : solution(num_list)) {
			System.out.println(i);
		}
	}
	public static int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];
        int last_num = num_list[num_list.length-1] > num_list[num_list.length-2] ? num_list[num_list.length-1]-num_list[num_list.length-2]
        																					: num_list[num_list.length-1]*2;
        for(int i = 0 ; i < num_list.length ; i ++) {
        	answer[i] += num_list[i];
        }
        answer[answer.length-1] = last_num;
        return answer;
    }
}
