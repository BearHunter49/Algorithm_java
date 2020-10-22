package Utils;

import java.util.Arrays;

public class 크루스칼 {
    public static void main(String[] args) {
        int[][] my_edges = {{0, 1, 5}, {0, 2, 2}, {0, 3, 4}, {0, 4, 2},
                {1, 2, 1}, {3, 2, 1}, {4, 3, 1}};
        System.out.println(my_kruscal(5, my_edges));
    }

    public static int my_kruscal(int nodeNum, int[][] edges){
        int answer = 0;

        int[] parents = new int[nodeNum];
        for (int i = 0; i < nodeNum; i++) {
            parents[i] = i;
        }

        // 간선 오름차순 정렬
        Arrays.sort(edges, (s1, s2) -> s1[2] - s2[2]);

        for (int[] edge: edges){
            int s = edge[0];
            int e = edge[1];
            int d = edge[2];

            if (find_parent(parents, s) != find_parent(parents, e)){
                union_parent(parents, s, e);
                answer += d;
            }
        }
        return answer;
    }

    private static void union_parent(int[] parents, int a, int b) {
        int a_parent = find_parent(parents, a);
        int b_parent = find_parent(parents, b);

        if (a_parent < b_parent){
            parents[b_parent] = a_parent;
        }else{
            parents[a_parent] = b_parent;
        }
    }

    private static int find_parent(int[] parents, int x) {
        if (parents[x] == x){
            return x;
        }

        parents[x] = find_parent(parents, parents[x]);
        return parents[x];
    }
}
