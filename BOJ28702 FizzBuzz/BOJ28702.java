import java.io.*;

public class BOJ28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();

        int num = 0;
        if(isInteger(first)){
            num = Integer.parseInt(first);
            fizzBuzz(num + 3);
        }else if(isInteger(second)){
            num = Integer.parseInt(second);
            fizzBuzz(num + 2);
        }else if(isInteger(third)){
            num = Integer.parseInt(third);
            fizzBuzz(num + 1);
        }
    }
    static boolean isInteger(String str) {
        try{
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }
    static void fizzBuzz(int num){
        if(num % 3 == 0){
            if(num % 5 == 0){
                System.out.println("FizzBuzz");
            }else {
                System.out.println("Fizz");
            }
        }else {
            if(num % 5 == 0){
                System.out.println("Buzz");
            }else {
                System.out.println(num);
            }
        }
    }
}
