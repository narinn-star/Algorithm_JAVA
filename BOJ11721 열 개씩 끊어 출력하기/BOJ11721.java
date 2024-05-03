import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputStr = br.readLine();

        for (int i = 0; i < inputStr.length(); ++i) {
            System.out.print(inputStr.charAt(i));
            if (i % 10 == 9) {
                System.out.println();
            }
        }
    }
}
