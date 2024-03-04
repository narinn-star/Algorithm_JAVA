public class BOJ4673 {
    public static void main(String[] args) {

        boolean array[] = new boolean[10001];

        for(int i = 1; i <= 10000; i++){
            int n = divideNumber(i);

            if(n <= 10000){
                array[n] = true;
            }
        }

        for(int i = 1; i < array.length; i++){
            if(array[i] == false){
                System.out.println(i);
            }
        }
    }

    public static int divideNumber(int n){
        int sum = n;

        while(n != 0){
            sum = sum + (n % 10); // 첫째자리수 뽑기
            n = n / 10; // 버리기
        }
        return sum;
    }
}
