package ru.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int n = readNumber(); //читаем размер массива
        ArrayList<Integer> integerArrayList = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            integerArrayList.add(i);
        }

        printArrayList(integerArrayList);

        Random random = new Random();
        int deletePos = random.nextInt(n);
        integerArrayList.remove(deletePos);

        printArrayList(integerArrayList);


        ArrayList<Integer> shuffledArray = shuffleArray(integerArrayList);

        printArrayList(integerArrayList);
        printArrayList(shuffledArray);








    }



    public static ArrayList<Integer> shuffleArray(ArrayList<Integer> inputArray) {
        ArrayList<Integer> buffer = (ArrayList<Integer>)inputArray.clone();
        ArrayList<Integer> newArray = new ArrayList<>(inputArray.size());
        Random random = new Random();
        int size = inputArray.size();
        for (int i = 0; i < size; i++) {
            int nextIndex = random.nextInt(buffer.size());
            newArray.add(buffer.get(nextIndex));
            buffer.remove(nextIndex);
        }

        return newArray;

    }

    public static void printArrayList(ArrayList<Integer> integerArrayList) {
        integerArrayList.forEach(x -> System.out.print(x + " "));
        System.out.println("");
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
