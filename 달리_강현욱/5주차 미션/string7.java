package StreamPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String7 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer strTo;

        for (int i = 0; i < t; i++) {
            strTo = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(strTo.nextToken());
            String s = strTo.nextToken();

            for (int j = 0; j < s.length(); j++) {
                int count = 0;

                while (count < n) {
                    sb.append(s.charAt(j));
                    count++;
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}