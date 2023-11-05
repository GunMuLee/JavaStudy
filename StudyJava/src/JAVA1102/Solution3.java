package JAVA1102;

public class Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution("1111111"));
		
	}
	
	public static int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")) {
        	
        	if(s.contains("0")) {
        		char[] chars = s.toCharArray();
        		for(char c : chars) {
        			answer[1] += c=='0' ? 1 : 0;
        		}
        		s.replaceAll("0", "");
        	}
        	String[] strs = s.split("");
        	int result = 0;
        	for(int i = 0; i < strs.length ; i++) {
        		result += Integer.parseInt(strs[i]);
        	}
        	s=Integer.toBinaryString(result);
        	answer[0]++;
        }
        
        return answer;
    }
	
	public static int[] solution2(String s) {
		int[] answer = new int[2];
        int temp;
        while( !s.equals("1") ) {
            answer[1] += s.length();
            s = s.replaceAll("0", "");
            temp = s.length();
            s = Integer.toBinaryString(temp);
            //System.out.println("s : " + s ); 
            answer[0]++;
            answer[1] -= temp;
        }
        return answer;  
	}

}
