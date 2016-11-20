package com.geekhub.Homework5.Translator.source;

import com.geekhub.Homework5.Translator.SourceLoadingException;

import java.io.*;

/**
 * Implementation for loading content from local file system.
 * This implementation supports absolute paths to local file system without specifying file:// protocol.
 * Examples c:/1.txt or d:/pathToFile/file.txt
 */
public class FileSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        File file = new File(pathToSource);
        return file.isFile();
    }

    @Override
    public String load(String pathToSource) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(pathToSource)));
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
