import java.io.*;
import java.util.*;

public class BOJ5430 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());

            Deque<Integer> deque = new ArrayDeque<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            solution(func, deque);
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static void solution(String func, Deque<Integer> deque) {
        boolean reverse = true; // 안뒤집힘

        for (char f : func.toCharArray()) {
            if (f == 'R') {
                reverse = !reverse;
                continue;
            }

            if (reverse) {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }

        sb.append('[');

        if(deque.size() > 0) {

            if (reverse) {
                sb.append(deque.pollFirst());

                while (!deque.isEmpty()) sb.append(',').append(deque.pollFirst());
            } else {
                sb.append(deque.pollLast());

                while (!deque.isEmpty()) sb.append(',').append(deque.pollLast());
            }
        }

        sb.append(']').append("\n");
    }
}
