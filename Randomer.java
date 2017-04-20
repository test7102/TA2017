/**
 * Задание номер 9
 */
public class Randomer {

    public static void main(String[] args) {
        String sign="!";

        System.out.println("Hello, world!\nAnd hi again!");
        for (int i = 0; i < randomrange(); i++) {
            System.out.print(sign);

        }

    }
    public static int randomrange(){
        return (int)(Math.random()*46)+5;
    }
}
