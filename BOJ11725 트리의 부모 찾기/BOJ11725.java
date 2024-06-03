import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BOJ11725 {
    // 트리의 부모 찾기
    private static int N;
    private static int[] parent;
    private static boolean[] visited;
    private static ArrayList<Integer> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        parent = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
        dfs(1);

        for(int i = 2; i < parent.length; i++){
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int root){
        visited[root] = true;
        for(int i: list[root]){
            if(!visited[i]){
                parent[i] = root;
                dfs(i);
            }
        }
    }
}
