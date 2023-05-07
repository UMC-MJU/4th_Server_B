
public class isdistinguish {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++){
            System.out.println(isEven(i));
        }
    }
    public static boolean isEven(int num){
        if (num % 2 == 0){
            return true;
        }
        return false;
    }
}
