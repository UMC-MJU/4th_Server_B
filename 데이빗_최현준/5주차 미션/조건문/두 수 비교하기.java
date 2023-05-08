// https://www.acmicpc.net/problem/1330 조건문 1번 두 수 비교하기 문제 코드

import java.io.*;
import java.util.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
    
        if (A > B) {
            bw.write(">");
        } else if (A < B) {
            bw.write("<");
        } else {
            bw.write("==");
        }
        bw.close();
        br.close();
    }
}
