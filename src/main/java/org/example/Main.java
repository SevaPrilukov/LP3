package org.example;
public class Main {
    public static void main(String[] args) {
        String[][] validArray = {
                {"7", "4", "8","7"},
                {"7", "6", "7", "7"},
                {"9", "10", "5", "12"},
                {"15", "4", "15","."}
        };
        int a = 0;
        try {
            int result = processArray(validArray);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException | MyFibonacciException e) {
            e.printStackTrace();
            a++;

        }
        if (a==1){
            System.exit(0);
        }
        for (int i = 0; i < validArray.length; i++) {
            for (int j = 0; j < validArray[i].length; j++) {
                int value = Integer.parseInt(validArray[i][j]);
                try{
                    if (isFibonacci(value)){
                        throw new MyFibonacciException(value);
                    }
                }catch (MyFibonacciException e){
                    e.printStackTrace();
                }
            }
        }

    }
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException, MyFibonacciException {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                count++;
            }
            if (count != 4){
                throw new MyArraySizeException();
            }
            count = 0;
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                    //if (isFibonacci(value)) {
                        //throw new MyFibonacciException(value);
                    //}
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }
        return sum;
    }
    public static boolean isFibonacci(int num) {
        int a = 0;
        int b = 1;
        while (a + b <= 1000) {
            int temp = a + b;
            a = b;
            b = temp;
            if (b == num) {
                return true;
            }
        }
        return false;
    }
}