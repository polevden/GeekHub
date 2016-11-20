package com.geekhub.Homework5.Translator.source;

import com.geekhub.Homework5.Translator.SourceLoadingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Implementation for loading content from specified URL.<br/>
 * Valid paths to load are http://someurl.com, https://secureurl.com, ftp://frpurl.com etc.
 */
public class URLSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        try {
            new URL(pathToSource);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String load(String pathToSource) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(pathToSource).openStream()));
            StringBuilder content = new StringBuilder();
            String contentLine;
            while ((contentLine = reader.readLine()) != null) {
                content.append(contentLine).append("/n");
            }
            return content.toString();
        } catch (IOException e) {
            throw new SourceLoadingException("File not available", e);
        }
    }
}
