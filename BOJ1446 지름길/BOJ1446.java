import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1446 {
    static class Drive {
        int start;
        int end;
        int shortcut;

        Drive(int start, int end, int shortcut) {
            this.start = start;
            this.end = end;
            this.shortcut = shortcut;
        }
    }

    private static List<Drive> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int shortcut = Integer.parseInt(st.nextToken());

            if (end - start <= shortcut || end > D) continue;
            list.add(new Drive(start, end, shortcut));
        }

        Collections.sort(list, (l1, l2) ->
                l1.start == l2.start ? l1.end - l2.end : l1.start - l2.start);

        int now = 0;
        int size = 0;
        int[] distance = new int[10001];
        Arrays.fill(distance, (int) 10001);
        distance[0] = 0;

        while (now < D) {
            if (size < list.size()) {
                Drive drive = list.get(size);
                if (drive.start == now) {
                    distance[drive.end] = Math.min(distance[drive.end], distance[now] + drive.shortcut);
                    size++;
                } else {
                    distance[now + 1] = Math.min(distance[now] + 1, distance[now + 1]);
                    now++;
                }
            } else {
                distance[now + 1] = Math.min(distance[now] + 1, distance[now + 1]);
                now++;
            }
        }

        System.out.println(distance[D]);
    }
}
