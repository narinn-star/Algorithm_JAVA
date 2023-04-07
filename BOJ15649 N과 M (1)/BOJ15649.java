import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
    private static int N, M;
    private static boolean[] visited;
    private static int[] res;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        res = new int[M + 1];

        nm(0);
        System.out.println(sb);
    }
    private static void nm(int index){
        //다 탐색했으면 종료
        if(index == M){
            for(int i = 0; i < M; i++){ // 출력할 갯수만큼
                sb.append(res[i] + " ");
            }
            sb.append("\n");
            return;
        }

        //계속 탐색
        for(int i = 1; i <= N; i++){ // [1, ...], [2, ...], [3, ...]
            if(visited[i]) continue; //이미 방문했다면 패스
            visited[i] = true;
            res[index] = i; //숫자 넣고
            nm(index + 1); // 다음으로 넘어가기
            visited[i] = false; // 다시 열어줘야 다음 반복에서 방문 가능
        }
    }
}
