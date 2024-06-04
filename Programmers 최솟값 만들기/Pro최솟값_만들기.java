import java.util.Arrays;
import java.util.Comparator;

public class Pro최솟값_만들기 {
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Integer[] tmpB = new Integer[B.length];

        for(int i = 0; i < tmpB.length; i++){
            tmpB[i] = new Integer(B[i]);
        }

        Arrays.sort(A);
        Arrays.sort(tmpB, Comparator.reverseOrder());

        for(int i = 0; i < A.length; i++){
            answer += A[i] * tmpB[i];
        }

        return answer;
    }
}
