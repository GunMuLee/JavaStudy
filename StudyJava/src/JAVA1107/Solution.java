package JAVA1107;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println(confusingNumber(11));
		
	}
	
	public static boolean confusingNumber(int n) {
		
		String[] nums = Integer.toString(n).split("");
		String[] resultNums = new String[nums.length];
		String num = "";
		
		for(int i = nums.length-1 ; i >= 0 ; i--) {
			if (nums[i].equals("6")) {
				resultNums[nums.length-1-i] = "9";
			} else if (nums[i].equals("9")) {
				resultNums[nums.length-1-i] = "6";
			} else {
				resultNums[nums.length-1-i] = nums[i];
			}
		}
		
		for(String str : resultNums) {
			num += str;
		}
		
		return !(n == Integer.parseInt(num));
	}
	
}
