# [14888] 연산자 끼워넣기

## 분류
> 브루트포스
>
> 백트래킹

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {
    private static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    private static int N;
    private static int[] num, op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = new int[N + 1];
        op = new int[4];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        calc(num[0], 1);
        System.out.println(max + "\n" + min);
    }

    private static void calc(int res, int cnt) {
        if(cnt == N){
            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }

        for (int i = 0; i < op.length; i++) {

            if(op[i] > 0) {
                op[i]--;
                switch (i) {
                    case 0:
                        calc(res + num[cnt], cnt + 1);
                        break;
                    case 1:
                        calc(res - num[cnt], cnt + 1);
                        break;
                    case 2:
                        calc(res * num[cnt], cnt + 1);
                        break;
                    case 3:
                        calc(res / num[cnt], cnt + 1);
                        break;
                }
                op[i]++;
            }
        }
    }
}

```

## 문제풀이
이 문제를 어떻게 풀까 고민을 많이 했다.

1. 연산자 순서만 뽑아서 num이랑 합체를 해야하는 것인지 
2. 연산자 만나자 마자 num계산을 해줘야 하는 것인지
  2-1. 그렇다면 연산자 순서는 어떻게 바꿀 것인지 ..
  
대충 이렇게 꼬리에 꼬리를 물면서 고민 한 결과, 첫번째는 하다가 엎어버렸다. 

두번째 방법으로 switch문을 사용해 계산된 값을 새로 호출하는 함수의 인자로 넘겼다.
디버깅을 밥 먹듯 하는 나는 for문 내부의 if 조건문도, op[i] 증감식도 디버깅하면서 중간중간 구멍난 옷 꿰매듯 고쳐줬다😅

op[i]를 감소시켰다가 증가시키는 이유는 돌아갔을 때 이게 감소되어 있으면 연산자가 없는 것으로 간주되기 때문 !
이제 남은 관건은 함수를 종료시켜주는 것인데, 그건 cnt랑 N이 같아질 때 종료시키면 된다.

함수에 인자를 저렇게 넣는 방법을 생각해내기까지가 가장 오래걸렸던 것 같다.
내가 아는 백트래킹의 개념을 조금만 응용하면 금방 해결될 문제였던 것..
