import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		
	}
	
	public static void SnakeGmae(int width, int heigth, int[][] food) {
		int snakeWidth = 0;
		int snakeHeigth = 0;
		int count = 0;
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			String key = scanner.next();
			
			if(key.equals("R") || key.equals("L")) {
				snakeWidth = move(key);
			} else {
				snakeHeigth = move(key);
			}
			
			
			
		}
		
	}
	
	public static int move(String direction) {
		
//		if()
		
		return 0;
	}
	
}
