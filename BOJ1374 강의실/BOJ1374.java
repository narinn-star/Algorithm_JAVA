import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ1374 {
    public static class Lecture {
        int number;
        int start;
        int end;
        Lecture(int number, int start, int end){
            this.number = number;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(number, start, end);
        }

        Arrays.sort(lectures, (lec1, lec2) -> lec1.start == lec2.start ? lec1.end - lec2.end : lec1.start - lec2.start);

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            pQueue.add(lectures[i].end);

            if(lectures[i].start >= pQueue.peek()) pQueue.poll();
        }

        System.out.println(pQueue.size());
    }
}
