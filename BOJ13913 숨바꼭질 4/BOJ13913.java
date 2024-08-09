import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ13913 {
    static int N, K;
    static int[] visited;
    static int[] before;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K) {
            System.out.print(0 + "\n" + N);
            return;
        }

        visited = new int[100001];
        before = new int[100001];

        bfs();

        Stack<Integer> stack = new Stack<>();

        int tmp = K;
        while (tmp != N) {
            stack.push(tmp);
            tmp = before[tmp];
        }
        stack.push(N);

        while(!stack.isEmpty()) sb.append(stack.pop()).append(' ');

        bw.write(sb + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited[N] = 0;
        queue.add(N);

        while (!queue.isEmpty()) {
            int q = queue.poll();

            if (visited[K] != 0) {
                sb.append(visited[K]).append('\n');
                break;
            }

            if (q - 1 >= 0 && visited[q - 1] == 0) {
                visited[q - 1] = visited[q] + 1;
                queue.add(q - 1);
                before[q - 1] = q;
            }
            if (q + 1 < visited.length && visited[q + 1] == 0) {
                visited[q + 1] = visited[q] + 1;
                queue.add(q + 1);
                before[q + 1] = q;
            }
            if (q * 2 < visited.length && visited[q * 2] == 0) {
                visited[q * 2] = visited[q] + 1;
                queue.add(q * 2);
                before[q * 2] = q;
            }

        }
    }
}
