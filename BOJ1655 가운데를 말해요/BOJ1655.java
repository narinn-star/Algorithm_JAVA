import java.io.*;
import java.util.*;

public class BOJ1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if(N == 1) {
            bw.write(br.readLine());
            bw.flush();
            bw.close();
            return;
        }

        PriorityQueue<Integer> pQueue1 = new PriorityQueue<>(Collections.reverseOrder()); // 큰거부터
        PriorityQueue<Integer> pQueue2 = new PriorityQueue<>(); // 작은거부터

        for(int i = 0; i < N; i++){
            int inputNum = Integer.parseInt(br.readLine());

            if(pQueue1.size() == pQueue2.size()){
                pQueue1.add(inputNum);

                if(!pQueue2.isEmpty() && pQueue1.peek() > pQueue2.peek()){
                    pQueue2.add(pQueue1.poll());
                    pQueue1.add(pQueue2.poll());
                }
            }else {
                pQueue2.add(inputNum);

                if(pQueue1.peek() > pQueue2.peek()){
                    pQueue2.add(pQueue1.poll());
                    pQueue1.add(pQueue2.poll());
                }
            }
            bw.write(pQueue1.peek() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
