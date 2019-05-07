package base.filetest;

public class RecursionTest {
    public static void main(String[] args) {
        System.out.println("======While toBin2=====");
        toBin(6);
        System.out.println("======Recursion toBin2=====");
        toBin2(6);
    }

    private static void toBin2(int i) {
        if(i>0){
            System.out.println(i%2);
            toBin2(i/2);
        }
    }

    private static void toBin(int i) {
        while (i>0){
            System.out.println(i%2);
            i/=2;
        }
    }


}
