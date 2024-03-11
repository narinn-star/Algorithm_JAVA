import java.io.IOException;
import java.util.Scanner;

public class BOJ2839_2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int sugar[] = new int[5001];

        sugar[3] = sugar[5] = 1;

        for(int i = 6; i < sugar.length; i++){
            if(i % 5 == 0){
                sugar[i] = sugar[i - 5] + 1;
            }
            else if(i % 3 == 0){
                sugar[i] = sugar[i - 3] + 1;
            } else {
                if(sugar[i - 3] != 0 && sugar[i - 5] != 0)
                    sugar[i] = Math.min(sugar[i - 3], sugar[i - 5]) + 1;
            }
        }

        if(sugar[N] == 0){
            System.out.println("-1");
        }else {
            System.out.println(sugar[N]);
        }

    }
}
