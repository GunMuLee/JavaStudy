package JAVA1129;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/*
		 * 문자열 myString이 주어집니다. "x"를 기준으로 해당 문자열을 잘라내 배열을 만든 후 
		 * 사전순으로 정렬한 배열을 return 하는 solution 함수를 완성해 주세요.

		단, 빈 문자열은 반환할 배열에 넣지 않습니다.
		
		제한사항
		1 ≤ myString ≤ 100,000
		myString은 알파벳 소문자로 이루어진 문자열입니다.
		입출력 예
		myString	result
		"axbxcxdx"	["a","b","c","d"]
		"dxccxbbbxaaaa"	["aaaa","bbb","cc","d"]
		 */
		String[] answer = solution("axbxcxdxxxxxxx");
		
		for(String s : answer) {
			System.out.println(s);
		}

	}
	
	public static String[] solution(String myString) {
		// "x"를 기준으로 문자열을 자른 후 배열에 저장
        String[] splitArray = myString.split("x");

        // 빈 문자열을 제외하고 리스트에 추가
        ArrayList<String> resultList = new ArrayList<>();
        for (String s : splitArray) {
            if (!s.isEmpty()) {
                resultList.add(s);
            }
        }

        // 사전순으로 정렬
        Collections.sort(resultList);

        // 리스트를 배열로 변환하여 반환
        String[] resultArray = new String[resultList.size()];
        resultArray = resultList.toArray(resultArray);

        return resultArray;
    }
	
}
