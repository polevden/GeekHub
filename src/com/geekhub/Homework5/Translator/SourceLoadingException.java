package com.geekhub.Homework5.Translator;

import java.io.IOException;

public class SourceLoadingException extends IOException {
    public SourceLoadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
