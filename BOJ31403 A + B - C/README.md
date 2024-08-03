# [31403] A + B - C

## 분류
> 수학
> 
> 문자열
> 
> 사칙연산

## 코드
```java
import java.io.*;

public class BOJ31403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String A = br.readLine();
        String B = br.readLine();
        int C = Integer.parseInt(br.readLine());

        int strRes = Integer.parseInt(A + B) - C;
        int intRes = Integer.parseInt(A) + Integer.parseInt(B) - C;

        bw.write(intRes +"\n" + strRes);
        bw.flush();
        bw.close();
        br.close();
    }
}
```

## 문제풀이
