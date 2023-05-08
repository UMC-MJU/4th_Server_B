// https://www.acmicpc.net/problem/1152 문자열 8번 단어의 개수 문제 코드

import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(st.countTokens() + "");
        bw.close();
        br.close();
    }
}
