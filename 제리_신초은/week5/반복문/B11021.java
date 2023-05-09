package week5.반복문;

import java.io.*;
import java.util.StringTokenizer;

//백준 for문을 풀기 위한 메인 클래스
public class B11021 {
    //백준 for문을 풀기 위한 메인 메소드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //예외처리는 필수. throws IOException을 해줘야 함. 이클립스에 작성하면 빨간 줄 뜨는데
        //마우스 가져다 대면 자동으로 작성된다.
        int num = Integer.parseInt(br.readLine());

        //int a = Integer.parseInt(br.readLine());

        for(int i = 0; i < num ; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write("Case #"+(i+1)+": "+(a+b)+"\n");
        }

        bw.close();
        br.close();
    }

}
