# [10431] 줄세우기

## 분류
> 구현
>
> 정렬
>
> 시뮬레이션

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++){
            st = new StringTokenizer(br.readLine());
            //int[] height = new int[21];
            int max = -1;
            int cnt = 0;
            int num = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);

            for(int j = 1; j <= 20; j++){
                int h = Integer.parseInt(st.nextToken());

                if(max < h) { // 맨 뒤에 세우기
                    max = h;
                    list.add(j, h);
                }
                else { // 자기 자리 찾아가기
                    for(int k = 1; k <= j; k++){
                        if(list.get(k) > h){
                            list.add(k, h);
                            cnt += list.size() - k  - 1;
                            break;
                        }
                    }
                }
            }
            System.out.println(i + " " + cnt);
        }
    }
}

```

## 문제풀이

처음엔 예제에 맞춰 풀다 보니, min 값을 계속 갱신하면서 갱신 후 cnt값을 cnt += (j - 1)해주도록 했는데 당연히 틀림.. 

참고한 반례는 아래와 같다.
1
1 19 20 17 18 15 16 13 14 11 12 9 10 7 8 5 6 3 4 1 2

17 19 20으로 정렬되어 있을 때, 18이 들어오면 min 값이 17이기때문에 17 19 20 18로 들어가기 때문이다. 그렇기 때문에 반대로 max값을 저장해서 max보다 크면 그냥 맨 뒤에 세우고 그렇지 않다면 자기 자리를 찾아가도록 반복문을 한 번 더 수행해줬다. ArrayList.add(idx, value)를 사용해서 원하는 인덱스에 값을 집어넣고 cnt는 알맞게 더해줬다. 

어려운 문제가 전혀 아니었는데 틀려서 속상했삼..😢
