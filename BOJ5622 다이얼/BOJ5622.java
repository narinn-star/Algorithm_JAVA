import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5622 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sec = 0;
		String[] line = br.readLine().split("");
		
		for(int i = 0; i < line.length; i++) {
			switch(line[i]) {
			case "A":case "B":case "C": sec = sec + 3;
			break;
			case "D":case "E":case "F": sec = sec + 4;
			break;
			case "G":case "H":case "I": sec = sec + 5;
			break;
			case "J":case "K":case "L": sec = sec + 6;
			break;
			case "M":case "N":case "O": sec = sec + 7;
			break;
			case "P":case "Q":case "R":case "S": sec = sec + 8;
			break;
			case "T":case "U":case "V": sec = sec + 9;
			break;
			case "W":case "X":case "Y":case "Z": sec = sec + 10;
			break;				
			}
		}
		br.close();
		System.out.println(sec);
	}
}