package task_02;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
* 2 . Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в
* лог-файл.
* */
public class task02 {
    public static void main(String[] args) {
        int[] newArray = getNewArray();

        System.out.println("Исходный массив: " + Arrays.toString(newArray));

        System.out.println("Отсортированный массив: " + Arrays.toString(getSortArray(newArray)));

    }
    //Метод создания массива
    public static int[] getNewArray() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        int arrayLenght = input.nextInt();
        int[] newArray = new int[arrayLenght];
        System.out.println("Введите максимальное значение массива: ");
        int maxValue = input.nextInt();
        Random random = new Random();
        IntStream.range(0, arrayLenght).forEach(index -> newArray[index] = random.nextInt(maxValue + 1));
        return newArray;
    }

    //Метод сортировки массива
    public static int[] getSortArray(int[] array) {
        boolean isSorted = false;
        int temp;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i] > array[i+1]){
                    isSorted = false;

                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            writeIter(array);
        }
        return array;
    }

    //Метод записи итерации сортировки в файл
    public static void writeIter(int[] array) {
        File file = new File("file.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            String lineSeparator = System.getProperty("line.separator");
            writer.write(Arrays.toString(array) + lineSeparator);
            writer.flush();
            writer.close();

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

}
