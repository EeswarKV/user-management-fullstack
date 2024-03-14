package com.example.usermanagement.exception;

public class UserNotPresentException extends Exception{
    String message;
   public  UserNotPresentException(String message){
        super(message);
        this.message= message;   
    } 
    public UserNotPresentException(){
        super("UserNotPresentException"); 
    } 
}
