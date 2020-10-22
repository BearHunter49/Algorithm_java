package Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 다익스트라_heap {
    public static void main(String[] args) {
        int[][] my_edges = {{0, 1, 5}, {0, 2, 2}, {0, 3, 4}, {0, 4, 2},
                {1, 2, 1}, {3, 2, 1}, {4, 3, 1}};
        System.out.println(my_dijkstra(5, my_edges, 0, 3));
    }

    // 인덱스 0부터 함
    public static int my_dijkstra(int nodeNum, int[][] edges, int start, int end){
        PriorityQueue<int[]> mHeap = new PriorityQueue<>((a, b)->((int[])a)[0] - ((int[])a)[0]);
        int INF = (int)1e9;

        int[] shortest = new int[nodeNum];
        int[] visited = new int[nodeNum];

        for (int i = 0; i < nodeNum; i++) {  // 시작지점 빼고 INF
            if (i != start){
                shortest[i] = INF;
            }
        }

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < nodeNum; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge: edges){
            int s = edge[0];
            int e = edge[1];
            int d = edge[2];

            graph.get(s).add(new int[]{e, d});
        }

        // 다익스트라 알고리즘
        mHeap.offer(new int[]{0, start});
        while (!mHeap.isEmpty()){
            int[] info = mHeap.poll();
            int distance = info[0];
            int node = info[1];

            if (visited[node] == 1){  // 이미 방문
                continue;
            }

            visited[node] = 1;
            for (int[] edge: graph.get(node)){
                int e = edge[0];
                int d = edge[1];

                int new_distance = distance + d;
                int origin_distance = shortest[e];
                if (new_distance < origin_distance){  // 더 짧은 거리 발견
                    shortest[e] = new_distance;
                    mHeap.offer(new int[]{new_distance, e});
                }
            }
        }
        System.out.println(Arrays.toString(shortest));
        return shortest[end];
    }
}
