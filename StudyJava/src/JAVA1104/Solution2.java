package JAVA1104;

public class Solution2 {

	public static void main(String[] args) {
		/*
		 * Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 
		 * 칠해져 있고 테두리 1줄은 갈색으로 
		 * 칠해져 있는 격자 모양 카펫을 봤습니다.

			Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 
			전체 카펫의 크기는 기억하지 못했습니다.
			
			Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 
			카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
		 */

	}
	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2]; // 결과를 저장할 배열

	    int total = brown + yellow; // 전체 카펫의 크기는 갈색과 노란색 격자 수의 합

	    // 가로 길이를 3부터 전체 크기의 1/3까지 순회
	    for (int i = 3; i <= total / 3; i++) {
	        if (total % i == 0) { // 전체 크기가 가로 길이로 나누어 떨어지는 경우
	            int width = total / i; // 가능한 가로 길이
	            int height = i; // 가능한 세로 길이

	            // 가로가 세로보다 크거나 같고, 갈색 격자 수가 올바른지 확인
	            if (width >= height && (width - 2) * (height - 2) == yellow) {
	                answer[0] = width; // 가로 길이 저장
	                answer[1] = height; // 세로 길이 저장
	                break; // 조건을 만족하는 경우를 찾았으므로 반복문 종료
	            }
	        }
	    }

	    return answer; // 결과 배열 반환
    }
	

}
