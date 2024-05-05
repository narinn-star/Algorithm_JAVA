# [2776] 암기왕

## 분류
> 자료 구조
> 
> 정렬
> 
> 이분 탐색
> 
> 해시를 사용한 집합과 맵

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            int[] note1 = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                note1[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(note1);
            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                int min = 0, max = N, mid;

                int findNum = Integer.parseInt(st.nextToken());
                boolean find = false;

                while(min <= max) {
                    mid = (min + max) / 2;

                    if(note1[mid] == findNum){
                        find = true;
                        break;
                    }
                    else if(note1[mid] < findNum) min = mid + 1;
                    else max = mid - 1;
                }
                sb.append(find ? 1 : 0).append("\n");
            }

            System.out.print(sb);
        }
    }
}
```

## 문제풀이

시간 초과때문에 출력 방식을 System.out.printnln() 대신 StringBuilder를 사용했다. 물론 틀리기 전까진 시간 초과인지 아닌지 알 수 없었지만😭

수첩1에 있는 숫자들만 정렬해서 입력받은 숫자들이 있는지 이분탐색으로 찾아주는 문제로, 크게 어려운 문제는 아니었다. 다른 문제들과 달리 true/false로만 판단하면 되기 때문인가.. 아무튼 쉽게 풀었음
