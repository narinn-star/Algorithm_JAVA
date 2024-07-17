# [5430] AC

## 분류
> 구현
> 
> 자료 구조
> 
> 문자열
> 
> 파싱
> 
> 덱

## 코드
```java
import java.io.*;
import java.util.*;

public class BOJ5430 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());

            Deque<Integer> deque = new ArrayDeque<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            solution(func, deque);
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();
    }

    static void solution(String func, Deque<Integer> deque) {
        boolean reverse = true; // 안뒤집힘

        for (char f : func.toCharArray()) {
            if (f == 'R') {
                reverse = !reverse;
                continue;
            }

            if (reverse) {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }

        sb.append('[');

        if(deque.size() > 0) {

            if (reverse) {
                sb.append(deque.pollFirst());

                while (!deque.isEmpty()) sb.append(',').append(deque.pollFirst());
            } else {
                sb.append(deque.pollLast());

                while (!deque.isEmpty()) sb.append(',').append(deque.pollLast());
            }
        }

        sb.append(']').append("\n");
    }
}

```

## 문제풀이

자바에서 처음 사용해본 덱! 덱 사용이 어려운게 아니고, 뒤집고 뽑는 과정에서 문자열 자체에 문제가 있었는지 자꾸 오류가 났다. 에러처리하려고 flag도 만들어 봤는데 리턴시키는게 쉽지 않아서 그냥 함수로 분리해버렸다. 왜인지 모르겠지만 통과됨..   

문자열 자르는 방법을 알아서 그래도 얻어가는 게 있는 문제였다🫠
