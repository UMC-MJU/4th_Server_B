package Java;
//짝수와 홀수를 구분하는 isEven() 메서드를 작성하세요.
// 이 메서드는 int형 매개변수를 받아, 짝수인 경우 true, 홀수인 경우 false를 반환합니다.
public class EvenOdd {
    public static boolean isEven(int num) {
        //짝수인 경우 true 반환
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
