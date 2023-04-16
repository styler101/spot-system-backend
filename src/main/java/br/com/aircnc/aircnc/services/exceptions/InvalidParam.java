package br.com.aircnc.aircnc.services.exceptions;

public class InvalidParam extends RuntimeException{

    private String message;

    public InvalidParam(){
        super();
    }

    public InvalidParam(String message){
        super(message);
    }
}
