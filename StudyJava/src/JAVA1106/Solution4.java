package JAVA1106;

public class Solution4 {

	public static void main(String[] args) {
		//최대 공약수 및 최대 공배수
		
		System.out.println(findGCD(200, 100));
		System.out.println(findLCM(200, 100));
		
	}
	
	// 최대 공약수(GCD)를 계산하는 함수
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
	
    //최대 공배수 LCM을 계산하는 함수
    public static int findLCM(int a, int b) {
    	return (a*b) / findGCD(a, b);
    }
    
}
