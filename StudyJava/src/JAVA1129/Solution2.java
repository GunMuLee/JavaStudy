package JAVA1129;

import java.util.ArrayList;

public class Solution2 {
    // 네트워크 개수를 찾는 함수
    public static int solution(int n, int[][] computers) {
        // 각 컴퓨터의 방문 여부를 저장하는 배열
        boolean[] visited = new boolean[n];
        // 네트워크 개수를 저장하는 변수
        int networkCount = 0;

        // 모든 컴퓨터에 대해 반복
        for (int i = 0; i < n; i++) {
            // 방문하지 않은 컴퓨터를 찾으면
            if (!visited[i]) {
                // 해당 컴퓨터를 시작으로 깊이 우선 탐색 수행
                dfs(i, n, computers, visited);
                // 연결된 모든 컴퓨터를 방문한 후에는 연결 요소 개수를 증가
                networkCount++;
            }
        }

        // 최종적인 네트워크 개수 반환
        return networkCount;
    }

    // 깊이 우선 탐색(DFS) 함수
    private static void dfs(int node, int n, int[][] computers, boolean[] visited) {
        // 현재 노드를 방문으로 표시
        visited[node] = true;

        // 현재 노드와 연결된 모든 노드에 대해 반복
        for (int i = 0; i < n; i++) {
            // 현재 노드와 연결되어 있고, 아직 방문하지 않은 경우
            if (computers[node][i] == 1 && !visited[i]) {
                // 해당 노드로 DFS 재귀 호출
                dfs(i, n, computers, visited);
            }
        }
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        int n1 = 3;
        int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int result1 = solution(n1, computers1);
        System.out.println(result1);

        // 테스트 케이스 2
        int n2 = 3;
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int result2 = solution(n2, computers2);
        System.out.println(result2);
    }
}
