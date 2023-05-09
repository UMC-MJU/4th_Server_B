public class Umc {

    public boolean isEven(int num){
        if(num % 2 ==0){
            return true;
        }
        else
            return false ;
    }

    public static void main(String[]  args){
        Umc umc = new Umc();

        for(int i=1; i<11; i++) {
            if (umc.isEven(i))
                System.out.println(i);
        }
    }
}
