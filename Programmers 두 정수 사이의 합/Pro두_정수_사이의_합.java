public class Pro두_정수_사이의_합 {
    public long solution(int a, int b) {
        long answer = 0;

        if (a > b) {
            int tmp = b;
            b = a;
            a = tmp;
        }

        for (int i = a; i <= b; i++) {
            answer += i;
        }

        return answer;
    }

}
