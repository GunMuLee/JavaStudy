package JAVA1101;

public class Solution {
	
	public static void main(String[] args) {
		/*
		 * 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. 
		 * str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 
		 * "(최소값) (최대값)"형태의 문자열을 반환하는 함수,solution을 완성하세요.
		 *  예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
		 *  s				return
			"1 2 3 4"		"1 4"
			"-1 -2 -3 -4"	"-4 -1"
			"-1 -1"			"-1 -1"
		 */
		
		System.out.println(solution("-1 -1"));
		
	}
	
	public static String solution(String s) {
		
        String[] strs = s.split(" ");
        
        int num1, num2;
        
        num1 = Integer.parseInt(strs[0]);
        num2 = Integer.parseInt(strs[1]);
        
        for(String i : strs) {
        	int j = Integer.parseInt(i);
        	
        	if(num1 > num2) {
        		if(num1 < j) {
        			num1 = j;
        		} else if (num2 > j) {
        			num2 = j;
        		}
        	} else {
        		if(num1 > j) {
        			num1 = j;
        		} else if (num2 < j) {
        			num2 = j;
        		}
        	}
        	
        }
        
        return num1 > num2 ? num2 + " " + num1 : num1 + " " + num2;
    }
	
	 public static String getMinMaxString(String str) {
	        String[] tmp = str.split(" ");
	        int min, max, n;
	        min = max = Integer.parseInt(tmp[0]);
	        for (int i = 1; i < tmp.length; i++) {
	                n = Integer.parseInt(tmp[i]);
	            if(min > n) min = n;
	            if(max < n) max = n;
	        }

	        return min + " " + max;

	    }
	
}
