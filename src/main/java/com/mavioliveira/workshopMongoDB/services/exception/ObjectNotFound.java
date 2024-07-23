package com.mavioliveira.workshopMongoDB.services.exception;

public class ObjectNotFound extends RuntimeException {

    public ObjectNotFound (String msg){
        super(msg);
    }

}
