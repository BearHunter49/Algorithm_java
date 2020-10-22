package Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 위상정렬 {
    public static void main(String[] args) {
          int[][] myEdges = {{0, 2}, {1, 2}, {2, 3}, {2, 4}, {4, 3}, {4, 5}};
          System.out.println(Arrays.toString(my_topology(6, myEdges)));
    }

    public static int[] my_topology(int nodeNum, int[][] edges){
        ArrayList<Integer> nodeAnswer = new ArrayList<>();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < nodeNum; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력 (+진입 차수)
        int[] indegrees = new int[nodeNum];
        for (int[] edge: edges){
            int s = edge[0];
            int e = edge[1];

            graph.get(s).add(e);
            indegrees[e]++;
        }

        // 진입 차수 0인 노드 큐에 넣기
        Queue<Integer> mQueue = new LinkedList<>();
        for (int i = 0; i < nodeNum; i++) {
            if (indegrees[i] == 0){
                mQueue.offer(i);
            }
        }

        while (!mQueue.isEmpty()){
            int node = mQueue.poll();
            nodeAnswer.add(node);

            for (int number: graph.get(node)){
                indegrees[number]--;
                if (indegrees[number] == 0){  // 진입차수 0이면 큐에 넣기
                    mQueue.offer(number);
                }
            }
        }

        int[] answer = new int[nodeNum];
        for (int i = 0; i < nodeNum; i++) {
            answer[i] = nodeAnswer.get(i);
        }
        return answer;
    }
}
