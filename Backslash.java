/**
 * Задание номер 6
 */

public class Backslash {
   private final static char SLSH='\\';
    public static void main(String[] args) {

        System.out.println(convert(2));


    }
    public static char convert(int a){
       return (char)(SLSH+a);
    }
}
