package org.example;

public class MyFibonacciException extends Exception{
    public MyFibonacciException(int value) {
        super("В ячейке массива находится число Фибоначчи в пределах тысячи: " + value);
    }
}
