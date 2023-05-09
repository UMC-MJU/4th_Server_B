package 백준_2단계;

import java.util.Scanner;

public class 백준_2단계_알람시계 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int H = sc.nextInt(); // 시간
		int M = sc.nextInt(); // 분
		int clock = H * 60 + M; // 입력받은 시간을 모두 분단위로 나타낸 것
		int alarm = H * 60 + M - 45; // 알람 시각

		if (clock >= 45) { // 0시 45분이상의 입력값들을 받은 경우에만 다  들어가는경
			System.out.print(alarm / 60 + " " + alarm % 60);
		} else {// 0시 45분 미만의 입력값들을 받은경우만 들어감 0 시 
			System.out.print(23 + " " + (M + 15));
		}

		sc.close();
	}
}
