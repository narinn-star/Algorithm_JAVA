import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((q1, q2) -> q1 - q2);

        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            priorityQueue.add(input);
        }

        int sum = 0;

        while(!priorityQueue.isEmpty()){
            if(priorityQueue.size() == 1){
                //sum = priorityQueue.poll();
                break;
            }else{
                int a = priorityQueue.poll();
                int b= priorityQueue.poll();
                sum += a + b;
                priorityQueue.add(a + b);
            }
        }

        System.out.println(sum);
    }
}
