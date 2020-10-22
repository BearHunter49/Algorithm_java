package Utils;

public class 플로이드워셜 {
    public static void main(String[] args) {
        int[][] my_edges = {{0, 1, 5}, {0, 2, 2}, {0, 3, 4}, {0, 4, 2},
                {1, 2, 1}, {3, 2, 1}, {4, 3, 1}};
        System.out.println(my_floyd_warshall(5, my_edges, 0, 3));
    }

    // 양방향 연결로 함
    public static int my_floyd_warshall(int nodeNum, int[][] edges, int start, int end){
        int answer = 0;
        int INF = (int)1e9;

        // 자기 자신 0, 나머진 무한대
        int[][] graph = new int[nodeNum][nodeNum];
        for (int i = 0; i < nodeNum; i++) {
            for (int j = 0; j < nodeNum; j++) {
                if (i != j){
                    graph[i][j] = INF;
                }
            }
        }

        for (int[] edge: edges){
            int s = edge[0];
            int e = edge[1];
            int d = edge[2];

            // 양방향
            graph[s][e] = d;
            graph[e][s] = d;
        }

        for (int k = 0; k < nodeNum; k++) {
            for (int i = 0; i < nodeNum; i++) {
                for (int j = 0; j < nodeNum; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        answer = graph[start][end];
        return answer;
    }

}
