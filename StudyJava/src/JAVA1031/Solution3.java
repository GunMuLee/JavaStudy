package JAVA1031;

public class Solution3 {

	public static void main(String[] args) {
		/*
		 * 양의 정수 n이 매개변수로 주어질 때, 
		 * n이 홀수라면 n 이하의 홀수인 모든 양의 정수의 합을 return 하고 n이 짝수라면 
		 * n 이하의 짝수인 모든 양의 정수의 제곱의 합을 return 하는 solution 함수를 작성해 주세요.
		 * 
		 * 예제
		 * n	result
			7	16
			10	220
		 */
		
		System.out.println(solution(10));
		System.out.println(solution2(10));
		
	}
	
	public static int solution(int n) {

		int result = 0;
		
		if(n % 2 == 0) {
			for(int i=0 ; i <= n ; i+=2) {
				System.out.println(i);
				result += i*i;
			}
			return result;
		} else {
			for(int i =1; i <= n ; i+=2) {
				
				System.out.println(i);
				
				result += i;
			}
			return result;
		}

    }
	
	public static int solution2(int n) {
		
		int answer = 0;
		
		for(int i = n ; i >= 0 ; i-=2) {
			
			answer += n % 2 != 0 ? i : i*i;
			
		}
		
		return answer;
		
	}
	
}
