// 숫자를 입력받아 10으로 나눈 값을 출력하는 프로그램을 작성하세요. 예외 처리를 이용하여, 0으로 나누려는 경우 "Cannot divide by zero"라는 메시지를 출력하세요.
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int number = Integer.parseInt(br.readLine());
        
        try {
            bw.write("result: " + (number / 10));    
        } catch (ArithmeticException e) {
            bw.write("Cannot divide by zero");
        }
 
        bw.close();
        br.close();
    }
}
