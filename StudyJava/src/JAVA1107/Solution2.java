package JAVA1107;

import java.util.*;

public class Solution2 {
	public static void main(String[] args) {
		String[] names = {"nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx"};
		for(String str : solution(names)) {
			System.out.println(str);
		}
	}
	public static String[] solution(String[] names) {
        List<String> list = new ArrayList<String>();
        for(int i = 0 ; i < names.length ; i += 5) {
        	list.add(names[i]);
        }
        return list.toArray(new String[list.size()]);
    }
}
