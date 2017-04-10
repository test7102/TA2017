package com.company;

import java.util.Scanner;

/**
 * Задание номер 10
 */
public class Main {

    public static void main(String[] args) {
        String lname;
        String fname;
        int age;

        
        Scanner in = new Scanner(System.in);
          lname = in.next();
          fname = in.next();
          age = in.nextInt();

        System.out.println("Фамилия "+"Имя "+"Возраст ");
        System.out.println( lname+" "+fname+" "+age);

    }


}
