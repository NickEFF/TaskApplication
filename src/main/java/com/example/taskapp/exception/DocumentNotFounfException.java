package com.example.taskapp.exception;

public class DocumentNotFounfException extends RuntimeException{
    private final int documentId;

    public DocumentNotFounfException(int documentId){
        this.documentId = documentId;
    }

    @Override
    public String getMessage(){
        return "Document with id = " + documentId + "not found";
    }
}
