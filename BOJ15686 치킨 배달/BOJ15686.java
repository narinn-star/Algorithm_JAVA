import java.awt.Point;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15686 {
    //    static class Point {
//        int x, y;
//        public Point(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//    }
    static int N, M, min;
    static boolean[] visited;
    static List<Point> chickenMap, houseMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chickenMap = new ArrayList<>();
        houseMap = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 2) chickenMap.add(new Point(i, j));
                else if (tmp == 1) houseMap.add(new Point(i, j));
            }
        }
        visited = new boolean[chickenMap.size()];

        min = Integer.MAX_VALUE;

        dfs(0, 0);

        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int a, int cnt) {
        if (cnt == M) {
            int citySum = 0;
            for (int i = 0; i < houseMap.size(); i++) {
                int sum = Integer.MAX_VALUE;
                for (int j = 0; j < chickenMap.size(); j++) {
                    if (visited[j]) {
                        int distance = Math.abs(houseMap.get(i).x - chickenMap.get(j).x) + Math.abs(houseMap.get(i).y - chickenMap.get(j).y);
                        sum = Math.min(sum, distance);
                    }
                }
                citySum += sum;
            }

            min = Math.min(min, citySum);
            return;
        }

        for (int i = a; i < chickenMap.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
