import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lecture {
    int start;
    int end;

    Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class BOJ11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int lec = 0; // 강의실 수 카운팅

        Lecture[] lectures = new Lecture[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures, (lec1, lec2) -> lec1.start == lec2.start ? lec1.end - lec2.end : lec1.start - lec2.start);

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();


        for (int i = 0; i < N; i++) {
            pQueue.add(lectures[i].end);

            if (pQueue.peek() <= lectures[i].start) {
                pQueue.poll();
            }
        }

        System.out.println(pQueue.size());
    }
}
