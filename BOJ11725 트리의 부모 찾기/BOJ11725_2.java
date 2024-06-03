import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11725_2 {
    private static int N;
    private static int[] parent;
    private static boolean[] visited;
    private static ArrayList<Integer> tree[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        tree = new ArrayList[N + 1];

        for(int i = 0; i < N+1; i++){
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(1);

        for(int i = 2; i < parent.length; i++){
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int root){
        visited[root] = true;

        for(int c : tree[root]){
            if(!visited[c]){
                parent[c] = root;
                dfs(c);
            }
        }
    }
}
