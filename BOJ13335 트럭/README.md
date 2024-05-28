# [13335] 트럭

## 분류
> 구현
>
> 자료 구조
> 
> 시뮬레이션
> 
> 큐

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 트럭 수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int l = Integer.parseInt(st.nextToken()); // 최대 하중
        int sum = 0; // 트럭 무게 합
        int cnt = 0; // 시간

        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            truck.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < w; i++){
            bridge.add(0);
        }

        while(!bridge.isEmpty()){
            sum -= bridge.poll();
            if(!truck.isEmpty()){
                if(truck.peek() + sum <= l){
                    sum += truck.peek();
                    bridge.add(truck.poll());
                }else bridge.add(0);
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
```

## 문제풀이

큐를 이용한 문제다. 
트럭과 다리에 올라간 트럭무게를 둘 다 큐로 관리했다. 다리 위에 트럭이 없는 부분은 0으로 표시해주면서 트럭 하나씩 빼서 넣어주고, 총 무게 계산 후 최대하중 비교해주고.. 반복하면 된다. while문 하나 돌 때마다 cnt++ 하면 최단시간을 구할 수 있다. 


