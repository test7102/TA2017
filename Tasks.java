import java.util.Random;
import java.util.Scanner;

/**
 * Решение задач  на массивы и базовые конструкции
 *
 * @author Vivyen
 * @version 1.0
 * @since 2017-04-16
 */

public class Tasks {
    /**
     * This method is used for printing an array
     *
     * @param array array, which should be printed
     */
    public static void print2d(int[][] array) {
        for (int[] arr : array) {
            for (int v : arr) {
                System.out.printf("%3d", v);
            }
            System.out.println();
        }
        System.out.println(new String(new char[array.length]).replace("\0", "==="));
    }

    /**
     * This method fills an array
     *
     * @param v array, which should be filled
     */
    public static void fill(int v[][]) {
        Random rand = new Random();
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v.length; j++) {
                v[i][j] = rand.nextInt(v.length * 2 + 1) - v.length; //[-n;n]
            }
        }

    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please, enter N argument");
            System.exit(1);
        }
        int n = Integer.valueOf(args[0]);
//        task1(n);
        task2(n);
//        task3();
//        task4(n);

    }

    public static void task1(int n) {
        String[] arr = new String[n];
        double sum = 0.;
        double avg = 0.;
        int k = 0;

        while (k < n) {
            System.out.println("Enter " + k + " string");
            Scanner sc = new Scanner(System.in);
            arr[k] = sc.nextLine();
            sum += arr[k].length();
            k++;
        }
        avg = sum / n;
        for (int i = 0; i < n; i++) {
            if (arr[i].length() < avg) {
                System.out.println("String:'" + arr[i] + "' has length=" + arr[i].length());
            }
        }
        System.out.printf("average is %2.2f \n", avg);

    }

    public static void task2(int n) {
        Scanner sc = new Scanner(System.in);
        int k = 0;

        int latinWords = 0;
        int equalsWords = 0;
        String st;

        while (k < n) {
            int latin = 0;
            int vowls = 0;
            int cons = 0;

            System.out.println("Enter " + k + " word");
            st = sc.nextLine();

            st = st.toLowerCase();
            String alpbt = "abcdefghijklmnopqrstuvwxyz";
            String vowels = "aeiouy";
            String consonants = "bcdfghjklmnpqrstvwxz";

            for (int i = 0; i < alpbt.length(); i++) {
                if (st.contains(String.valueOf(alpbt.charAt(i)))) {
                    latin++;
                }
            }
            for (int j = 0; j < vowels.length(); j++) {
                if (st.contains(String.valueOf(vowels.charAt(j)))) {
                    vowls++;
                }
            }
            for (int j = 0; j < consonants.length(); j++) {
                if (st.contains(String.valueOf(consonants.charAt(j)))) {
                    cons++;
                }
            }

            System.out.println("vowls " + vowls + " cons " + cons+" lat "+latin);
            if (latin == st.length()) {
                latinWords++;
            }
            if (vowls == cons) {
                equalsWords++;
            }


            k++;
        }
        System.out.println("Latin words "+latinWords+" equalsWords "+equalsWords);
    }


    public static void task3() {
        String monthName;
        int month = 0;

        System.out.println("Enter month ordinal from 1 to 12");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            month = sc.nextInt();
            if (month > 0 & month < 13) {
                switch (month) {
                    case 1:
                        monthName = "January";
                        break;
                    case 2:
                        monthName = "February";
                        break;
                    case 3:
                        monthName = "March";
                        break;
                    case 4:
                        monthName = "April";
                        break;
                    case 5:
                        monthName = "May";
                        break;
                    case 6:
                        monthName = "June";
                        break;
                    case 7:
                        monthName = "July";
                        break;
                    case 8:
                        monthName = "August";
                        break;
                    case 9:
                        monthName = "September";
                        break;
                    case 10:
                        monthName = "October";
                        break;
                    case 11:
                        monthName = "November";
                        break;
                    case 12:
                        monthName = "December";
                        break;
                    default:
                        monthName = "none";
                }
                System.out.println(monthName);

            } else {
                System.out.println("Please, input  numbers from 1 to 12 only");
            }
        } else {
            System.out.println("Please, input  numbers only");
        }


    }

    public static void task4(int n) {
        int a[][] = new int[n][n];
        int max;
        int iteration = 0;
        int k = 2; // сортировать матрицу по к-ому столбцу

        fill(a);
        print2d(a);

        while (iteration < n) {
            for (int i = 0; i < n - 1; i++) {
                if (a[i][k] > a[i + 1][k]) {
                    for (int j = 0; j < n; j++) {
                        // перемещения строк
                        max = a[i][j];
                        a[i][j] = a[i + 1][j];
                        a[i + 1][j] = max;
                    }
                }
            }
            iteration += 1;
        }
        print2d(a);
    }
}
