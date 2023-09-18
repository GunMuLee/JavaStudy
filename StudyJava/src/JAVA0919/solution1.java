package JAVA0919;

public class solution1 {

	public static void main(String[] args) {

		/*
		 * 정수가 담긴 리스트 num_list가 주어집니다. 
		 * num_list의 홀수만 순서대로 이어 붙인 수와 짝수만 순서대로 이어 붙인 수의 합을
		 * return하도록 solution 함수를 완성해주세요.
		 * 	    public int solution(int[] num_list) {
	        
	        num_list			result
			[3, 4, 5, 2, 1]		393
	    }
		 */

		int[] num_list = {3,4,5,2,1};
		
		System.out.println(solution(num_list));

	}
	
    public static int solution(int[] num_list) {
        
    	String hs_num = "";
    	
    	String Ts_num = "";
    	
    	for(int num : num_list) {
    		if(num%2 > 0) {
    			hs_num += num;
    		} else {
    			Ts_num += num;
    		}
    	}
    	
        return Integer.parseInt(Ts_num) + Integer.parseInt(hs_num);
    }

}
