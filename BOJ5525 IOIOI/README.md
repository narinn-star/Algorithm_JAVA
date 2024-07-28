# [5525] IOIOI

## 분류
> 구현

## 코드
```java
import java.io.*;

public class BOJ5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int res = 0;

        for (int i = 0; i < M - 2; i++) {
            if (S.charAt(i) == 'I') {
                int cnt = 0;

                while (i + 2 < M && S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
                    cnt++;
                    i += 2;

                    if (cnt == N) {
                        res++;
                        cnt--;
                    }
                }
            }
        }

        bw.write(res + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
```

## 문제풀이

문자열 문제! 하나씩 뒤적뒤적하면서 조건문 / 반복문만 잘 써주면 된다.  

처음에는 아예 비교할 IOI...를 구해두고 equals를 사용했는데 시간초과도 아니고 아예 틀렸다고 뜸.. 왜인지는 모르겠지만 어쨌든 그렇게 하면 시간초과도 날 것 같아서, charAt()을 사용해서 하나씩 확인해주기로 했다.  

전체 for루프는 한 번씩만 탐색하려고 하기 때문에 M - 2 까지 돌았다. 내부 while문에서 i + 2까지 한 번에 확인해줄 것이기 때문이다. cnt는 내가 확인하고자 하는 N값과 일치하는지를 확인해줄 변수이고, res는 정답을 담을 변수다. while 조건문에서 미리 O, I를 확인해준 뒤에 뒤로 쭉 돌면서 cnt값도 올려주고 O,I가 한 세트이기 때문에 i += 2를 해줘야 그 다음 OI를 확인해줄 수 있다. 만약 cnt가 N과 같아지면 내가 구하고자 하는 문자열과 일치한다는 것이므로, 정답 값 res는 증가시키고, 더 나올 수 있는 값들을 위해 cnt는 줄여준다.  

풀고나서 보니 슬라이딩 윈도우로 풀어졌..네?
