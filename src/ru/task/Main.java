package ru.task;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int n = readNumber(); //читаем размер массива
        ArrayList<Integer> integerArrayList = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            integerArrayList.add(i);
        }

        //генерируем случаный индекс чтобы удалить
        Random random = new Random();
        int deletePos = random.nextInt(n);
        integerArrayList.remove(deletePos);


        //перемешиваем массив
        ArrayList<Integer> shuffledArray = shuffleArray(integerArrayList);

        System.out.println("Исходный массив после удаления");
        printArrayList(integerArrayList);
        System.out.println("Перемешанная версия:");
        printArrayList(shuffledArray);

        //ищем пропавшее число
        int answer = findMissingValue(shuffledArray);

        System.out.print("Пропавшее значение: " + answer);



    }

    //функция поиска пропавшего числа Сложность О(n + n) -> O(n)
    public static int findMissingValue(ArrayList<Integer> inputArray) {
        //создаем буферный массив где индекс+1 соответствует элементам исходного массива
        boolean[] values = new boolean[inputArray.size() + 1];
        for (Integer integer : inputArray) {
            //для всех элементов которые есть во входном массиве ставим true
            values[integer - 1] = true;
        }
        int ans = -1;
        for (int i = 0; i < values.length; i++) {
            if(!values[i]) { //ищем индекс в котором лежит единственнное значение false, это и есть искомый элемент
                ans = i + 1;
                break;
            }
        }
        return ans;
    }



    //функция перемешивания массива
    public static ArrayList<Integer> shuffleArray(ArrayList<Integer> inputArray) {
        //создаем буферный массив, чтобы не трогать исходный
        ArrayList<Integer> buffer = (ArrayList<Integer>)inputArray.clone();
        //Пустой новый массив, в котором будет результат
        ArrayList<Integer> newArray = new ArrayList<>(inputArray.size());
        Random random = new Random();
        int size = inputArray.size();
        for (int i = 0; i < size; i++) {
            //генерируем случайный индекс, который будет взят из буфферного массива
            int nextIndex = random.nextInt(buffer.size());
            //добавляем значение по этому индексу в новый массив
            newArray.add(buffer.get(nextIndex));
            //удаляем из буффера использованный элемент
            buffer.remove(nextIndex);
        }

        return newArray;

    }

    //вспомогаетльная функция для вывода массива на экран
    public static void printArrayList(ArrayList<Integer> integerArrayList) {
        integerArrayList.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    //функция для чтения целого числа из консоли
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
