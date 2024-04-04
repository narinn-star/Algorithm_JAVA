# [11286] 절대값 힙

## 분류
> 자료 구조
>
> 우선순위 큐

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)){
                    return Math.abs(o1) - Math.abs(o2);
                }else if(Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }else {
                    return -1;
                }
            }
        });

        for(int i = 0; i < N; i++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(pQueue.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pQueue.poll());
                }
            }else {
                pQueue.add(input);
            }
        }
    }
}
```

## 문제풀이

default가 오름차순인 priorityQueue의 comparator를 오버라이딩해주면 되는 문제.

오버라이딩 너무 오랜만에 해봐서😅 조금 찾아봤다. 함수 내부에서 절대값 처리를 한 채로 비교한 후 알맞은 리턴값을 넘겨주면 된다. 
절대값 기준으로 앞 값이 크다면 자리를 바꿔주고, 두 값이 같다면 음수를 앞으로 보내준다. 

알맞게 우선순위를 조작하는 게 포인트인듯
