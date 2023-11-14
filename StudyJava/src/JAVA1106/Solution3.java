package JAVA1106;

public class Solution3 {

	public static void main(String[] args) {

		System.out.println(solution("Pyy"));

	}
	public static boolean solution(String s) {
        int p = 0;
        int y = 0;
        
        for(String str : s.toLowerCase().split("")){
            if(str.equals("p")){
                p++;
            } else if(str.equals("y")){
                y++;
            }
        }

        return p==y;
    }
}
