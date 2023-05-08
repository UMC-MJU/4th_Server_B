// https://www.acmicpc.net/problem/10810 1차원 배열 5번 공 넣기 문제 코드

import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] result = new int[N + 1];

        for (int z = 0; z < M; z++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(row.nextToken());
            int j = Integer.parseInt(row.nextToken());
            int k = Integer.parseInt(row.nextToken());
            for (int pos = i; pos <= j; pos++) {
                result[pos] = k;
            }
        }

        for (int i = 1; i < N + 1; i++) {
            bw.write(result[i] + " ");
        }

        bw.close();
        br.close();
    }
}
