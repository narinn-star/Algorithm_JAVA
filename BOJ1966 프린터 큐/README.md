# [1966] 프린터 큐

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

class Printer {
    int imp, idx; // 중요도, 인덱스

    public Printer(int imp, int idx) {
        this.imp = imp;
        this.idx = idx;
    }
}
public class BOJ1966 {
    private static int N, M;
    private static LinkedList<Printer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                queue.add(new Printer(Integer.parseInt(st.nextToken()), i));
            }

            System.out.println(printDocs());
        }
    }
    private static int printDocs(){
        int cnt = 0;

        while(!queue.isEmpty()){
            Printer currentDoc = queue.poll();
            boolean check = true;

            for(int i = 0; i < queue.size(); i++){
                if(currentDoc.imp < queue.get(i).imp){
                    queue.offer(currentDoc);

                    for(int j = 0; j < i; j++){
                        queue.offer(queue.poll());
                    }
                    check = false;
                    break;
                }
            }

            if(!check) continue;

            cnt++;

            if(currentDoc.idx == M) break;
        }

        return cnt;
    }

}
```

## 문제풀이

말은 프린터 큐라 정말 쉽게 느껴졌는데, '하나씩 다 비교해주는 게 맞나?'하는 생각 때문에 시간이 걸렸다.
결국 하나씩 다 비교해주긴 했지만 😅

처음엔 Queue를 사용해서 하려 했는데, 그것보단 LinkedList를 사용해서 get으로 확인한 후에 꺼내고 넣는게 나을 듯해서 LinkedList로 바꿔주었다. 
이 문제의 포인트는 인덱스까지 기억해야한다는 것이기 때문에, 이 인덱스와 중요도를 함께 기억하기 위해 클래스를 만들어주고 입력받은 중요도와 인덱스 객체를 만들어 연결리스트에 넣어줬다. 

printDocs 함수에서 하나씩 비교해서 출력하는 것을 찾아줘야하는데, 이는 큐를 꺼내고 넣으면서 찾았다. 큰게 있다면 check = false 처리를 해주고 그렇지 않으면 인덱스 값과 M을 비교해준다. false일 때는 비교할 필요 없이 다시 돌아야하기 때문에 continue를 해줬고, true일 때는 출력되었음을 의미하기 때문에 cnt를 증가시킨다.

어려운 듯 어렵지 않은 듯,, 요즘은 구현 문제가 어렵기도 해서 계속 풀어보고 있는 중 🧐
