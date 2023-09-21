package org.example;

class MyArraySizeException extends Exception{
    public MyArraySizeException() {
        super("Неправильный размер массива");
    }
}
