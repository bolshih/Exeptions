package ru.netology.Product;

public class AlreadyExistsException extends RuntimeException{

    public AlreadyExistsException(String s){
        super(s);
    }
}
