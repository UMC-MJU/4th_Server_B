// https://www.acmicpc.net/problem/10798 2차원 배열 3번 세로읽기 문제 코드

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[][] board = new char[5][15]; // 단어를 저장할 2차원 배열

        // 단어 입력 받기
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // 세로로 읽어서 출력하기
        for (int j = 0; j < 15; j++) { // 열을 순회
            for (int i = 0; i < 5; i++) { // 행을 순회
                if (board[i][j] != '\0') { // 해당 위치에 글자가 있으면
                    sb.append(board[i][j]); // StringBuilder에 추가
                }
            }
        }

        bw.write(sb.toString()); // 출력

        br.close();
        bw.close();
    }
}
