# [1629] 곱셈

## 분류
> 수학
>
> 분할 정복을 이용한 거듭제곱

## 코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(solution(A, B, C));

    }
    static long solution(long A, long B, long C){
        if(B == 1) return A % C;

        long res = solution(A, B / 2, C);

        if(B % 2 == 1){
            return (res * res % C) * A % C;
        }
        return res  * res % C;
    }
}
```

## 문제풀이

지수 법칙과 모듈러 법칙 두가지를 사용하는 문제다. A,B,C의 값들이 2,147,783,647로 큰 수가 주어지기 때문에 long을 사용해야하는 것은 당연하다. 문제는 어떻게 계속해서 작은 값들을 가지고 끝까지 가느냐였다.  

규칙을 찾아보기도 하고, 이것저것 나눠보기도 했다. 결국 문제 유형을 보고 지수를 반으로 나누는 방법을 떠올릴 수 있었다.🫠  

트리를 사용한 다른 분의 풀이를 보고 재귀로 풀어낼 수 있었슴.. 계속 지수를 반으로 나눠가다 보면, 다시 계산할 필요가 없는 값들도 나오고, 결국 계산할 값들은 둘 중 한 번만 구하면 된다. 
너무 어려워요🥲
