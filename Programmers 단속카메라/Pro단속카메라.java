import java.util.Arrays;

public class Pro단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int max = routes[0][1];

        for(int i = 1; i < routes.length; i++){
            if(routes[i][1] >= max && routes[i][0] <= max){
                continue;

            } else {
                max = routes[i][1];
                answer++;
            }
        }

        return answer + 1;
    }
}
