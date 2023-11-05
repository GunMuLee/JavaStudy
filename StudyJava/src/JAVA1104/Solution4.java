package JAVA1104;

import java.util.ArrayList;

public class Solution4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {293, 1000, 395, 678, 94};
		int[] delete_list = {94, 777, 104, 1000, 1, 12};
		
		
		System.out.println(solution(arr, delete_list));
	}
	
	public static int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> delete = new ArrayList<Integer>();
        for(int i : delete_list) {
        	delete.add(i);
        }
        for(int i : arr) {
        	if(!delete.contains(i)) {
        		list.add(i);
        	}
        }
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++) {
        	answer[i]+=list.get(i);
        }
        
        return answer;
    }
}
