package JAVA1031;

public class Solution {
	
	public static void main (String[] args) {
		
		System.out.println(solution2("banana", "ban"));
		
	}
	
   public static int solution(String my_string, String is_prefix) {
	   return my_string.length() >= is_prefix.length() ? my_string.substring(0,is_prefix.length()).equals(is_prefix) ? 1 : 0 : 0;
    }
   
   public static int solution2(String my_string, String is_prefix) {

	   if(my_string.startsWith(is_prefix)) {
		   return 1;
	   }
	   
	   return 0;
	   
   }
}
