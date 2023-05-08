// https://www.acmicpc.net/problem/2908 문자열 9번 상수 문제 코드

import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder(st.nextToken());
        int a = Integer.parseInt(sb.reverse().toString());
        sb = new StringBuilder(st.nextToken());
        int b = Integer.parseInt(sb.reverse().toString());
        
        if (a > b) {
            bw.write(a + "");
        } else {
            bw.write(b + "");
        }
        bw.close();
        br.close();
    }
}
