//ex6

package com.company;

public class Main {
   final static    char SLSH='\\';
    public static void main(String[] args) {

        System.out.println(convert(2));


    }
    public static char convert(int a){
       return (char)(SLSH+a);
    };


}
