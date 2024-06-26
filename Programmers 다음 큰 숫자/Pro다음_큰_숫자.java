import java.lang.Integer;
public class Pro다음_큰_숫자 {
        public int solution(int n) {
            int answer = 0;
            String strN = Integer.toBinaryString(n);
            int nCnt = 0;

            for(int i = 0; i < strN.length(); i++){
                if(strN.charAt(i) == '1') nCnt++;
            }

            while(true){
                // 1의 개수가 같으면 break;
                String str = Integer.toBinaryString(++n);
                int cnt = 0;

                for(int i = 0; i < str.length(); i++){
                    if(str.charAt(i) == '1') cnt++;
                }

                if(nCnt == cnt) {
                    answer = n;
                    break;
                }
            }

            return answer;
        }
}
