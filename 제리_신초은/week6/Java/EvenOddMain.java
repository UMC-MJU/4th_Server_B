package Java;
//isEven() 메서드를 사용하여, 1부터 10까지의 수 중에서 짝수인 수를 출력해보세요.
public class EvenOddMain {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            //짝수만 출력
            if (EvenOdd.isEven(i)) {
                System.out.println(i + " is even.");
            }
        }
    }
}
