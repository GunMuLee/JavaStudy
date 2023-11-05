package JAVA1103;

public class Solution2 {

	public static void main(String[] args) {
	/*
	 * 문제 설명
	자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
	
	조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
	조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
	조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
	예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
	
	자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
	 */
		
		System.out.println(Integer.toBinaryString(78));
//		System.out.println(Integer.toBinaryString(solution(78)));
		System.out.println(Integer.toBinaryString(solution2(78)));
		System.out.println(Integer.toBinaryString(solution3(78)));
		
	}
	
//	public static int solution(int n) {
//		String x = Integer.toBinaryString(n);
//		String y = "";
//		
//		char[] chr = x.toCharArray();
//		
//		for(int i =chr.length-1; i >= 0 ; i--) {
//			if(chr[i] == '0') {
//				
//				chr[i] = '1';
//				
//				for(char c : chr) {
//					y += c;
//				}
//				return Integer.parseInt(y, 2);
//			} else {
//				chr[i] = '0';
//			}
//		}
//        
//		return 0;
//        
//    }
	
	public static int solution2(int n) { // 효율성 x
        int x = Integer.toBinaryString(n).replaceAll("0", "").length();
		int answer;
        for(int i = n+1 ; true ; i++) {
        	answer = i;
        	if(Integer.toBinaryString(i).replaceAll("0", "").length() == x) {
        		return answer;
        	}
        }
    }
	
	public static int solution3(int n) {
	    int countOne = Integer.bitCount(n); // n을 2진수로 변환하여 1의 갯수를 센다
	    int nextNumber = n + 1; // n보다 큰 다음 숫자부터 시작
	    // bitCount 2진수로 변환하여 1의 갯수를 센다
	    while (true) {
	        if (Integer.bitCount(nextNumber) == countOne) {
	            return nextNumber;
	        }
	        nextNumber++;
	    }
	}

}
