package com.geekhub.Homework5.ZipFileMaker;

public class FileNotExistException extends Exception {
    public FileNotExistException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}