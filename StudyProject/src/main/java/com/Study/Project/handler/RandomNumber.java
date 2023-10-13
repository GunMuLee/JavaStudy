package com.Study.Project.handler;

public class RandomNumber {
	public int randomNumber(int i) {
	    if (i <= 0) {
	        throw new IllegalArgumentException("i는 양수여야 합니다.");
	    }

	    int min = (int) Math.pow(10, i - 1);  // i 자리 숫자의 최소값
	    int max = (int) Math.pow(10, i) - 1;  // i 자리 숫자의 최대값

	    if (min >= max) {
	        throw new IllegalArgumentException("유효한 범위가 없습니다.");
	    }

	    return min + (int) (Math.random() * ((max - min) + 1));
	}
}
