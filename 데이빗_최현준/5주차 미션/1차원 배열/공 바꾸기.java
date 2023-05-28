// https://www.acmicpc.net/problem/10813 1차원 배열 6번 공 바꾸기 문제 코드

import java.io.*;
import java.util.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            arr[i] = i;
        }
        
        for (int i = 0; i < M; i++) {
            int temp = 0;
            StringTokenizer row = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(row.nextToken());
            int to = Integer.parseInt(row.nextToken());
            temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
        }
        
        for (int i = 1; i < N + 1; i++) {
            bw.write(arr[i] + " ");    
        }
        
        bw.close();
        br.close();
    }
}
