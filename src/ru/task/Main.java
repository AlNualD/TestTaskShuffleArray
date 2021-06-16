package ru.task;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int n = readNumber(); //читаем размер массива

    }

    public static int readNumber() {
        int n = -1;
        System.out.println("Введите размер массива - целое число не меньше 10:");
        while (n<0){
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if(n<10) {
                    n = -1;
                    System.out.println("Введите число не меньше 10");
                }
            } else {
                System.out.println("Введите целое число");
            }

        }
        return n;
    }
}
