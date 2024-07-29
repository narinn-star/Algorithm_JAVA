# [1074] Z

## 분류
> 분할 정복
>
> 재귀

## 코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ1074 {
    static int r, c, res = 0;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        z(0, 0, (int)Math.pow(2, N)); // 0, 0 ~ 2^N, 2^N
    }

    static void z(int x, int y, int len)throws IOException{
        if(len == 1) {
            bw.write(res + "");
            bw.flush();
            bw.close();
            return;
        }

        int newLen = len / 2;

        if(r < x + newLen && c < y + newLen){ // 1 왼쪽 위
            res += 0;
            z(x, y, newLen);
        }else if(r < x + newLen && c >= y + newLen){ // 2 오른쪽 위
            res += (len * len) / 4;
            z(x, y + newLen, newLen);
        }else if(r >= x + newLen && c < y + newLen){ // 3 왼쪽 아래
            res += ((len * len) / 4) * 2;
            z(x + newLen, y, newLen);
        }else if(r >= x + newLen && c >= y + newLen){ // 4 오른쪽 아래
            res += ((len * len) / 4) * 3;
            z(x + newLen, y + newLen, newLen);
        }
    }
}
```

## 문제풀이

재귀로 풀어야하는 건 알겠는데, 어떻게 줄여가야 할 지 감이 전혀 잡히지 않아서 정말 오래걸렸다.  
너무 오래 잡고 있었어서 과정이 기억이 안남.. 과정은 패스 -   

규칙은 칸이 4개씩 계속 나누어진다는 것 정도에서 시작했다. 4개씩 나누어지는 와중에 왼쪽 위 첫번째 값이 가장 작은 값이라는 걸 알 수 있다. 우리가 구해야 할 것은 마지막에 결국 1개가 남을 때까지 4개씩 쪼개어 가는 것이므로, 계속 쪼개면서 값만 잘 계산해주면 된다고 생각했다.  
첫 번째 예제인 2 3 1을 예로 들면  
1. 왼쪽 위 박스 (8 x 8에서 4등분 했을 때 왼쪽 위)  
2. 왼쪽 아래 박스 (4 x 4에서 4등분 했을 때 왼쪽 아래)  
3. 오른쪽 아래 남은 한 개 (2 x 2에서 4등분 했을 때 오른쪽 아래)   

이렇게 되는 것을 확인하고, 각각 조건문에 넣으면서 위치를 찾은 후에 값을 더해주고 다음 재귀를 호출했다.

어려워🤯

