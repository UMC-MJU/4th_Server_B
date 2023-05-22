// https://www.acmicpc.net/problem/2739 반복문 1번 구구단 문제 코드

import java.io.*;
import java.util.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int number = Integer.parseInt(br.readLine());
        
        for (int i = 1; i < 10; i++) {
            bw.write(number + " * " + i + " = " + (number * i) + "\n");
        }
        bw.close();
        br.close();
    }
}
