# [17478] 재귀함수가 뭔가요?

## 분류
> 구현
>
> 재귀

## 코드
```java
import java.io.*;

public class BOJ17478 {
    private static int cnt = 1;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        bw.write(finish(number, ""));
        bw.flush();
        bw.close();
    }

    private static String finish(int number, String hyphen) throws IOException {
        if(cnt > number) {
            bw.write(hyphen + "\"재귀함수가 뭔가요?\"\n");
            bw.write(hyphen + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            return hyphen + "라고 답변하였지.\n";
        }
        bw.write(hyphen + "\"재귀함수가 뭔가요?\"\n");
        bw.write(hyphen + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
        bw.write(hyphen + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
        bw.write(hyphen + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        cnt++;
        bw.write(finish(number, hyphen + "____"));
        return hyphen + "라고 답변하였지.\n";
    };
}

```

## 문제풀이

'리턴'의 중요성을 잊고 있었다.
바보같이 재귀는 잘 넣어놓고, 함수를 출력한다는 것을 생각도 안하고 있었다. 그러니 아무리 언더바 갯수를 조절하려해도 되지 않지.. 원래 재귀 돌리면 자동으로 언더바 갯수가 따라가야 하는 것인데, 아무리 해도 마지막 언더바 갯수가 고정되어 "라고 답변하였지." 앞에 똑같은 수의 언더바가 게속 찍혔다.
너무 답답하고 아무리 생각해도 로직상에는 문제가 없었다. 언더바 갯수를 빼놓고는 모든게 완벽했으니까. 이리저리 옮겨봐도 뭐가 되질 않았다. 함수는 함수대로 호출되고 "라고 답변하였지"는 계속 언더바가 고정된 채로 출력됐다.
지금 생각하면 너무 멍청하고 안타까운 일이나.. 과거 나의 코드를 열어버렸다. 작년의 나는 어떻게 이 문제를 풀어냈을까?
열자마자 후회했지만..
아무튼.. 리턴으로 해주고 나니 당연히ㅠㅠ 당연히!!!!!!
