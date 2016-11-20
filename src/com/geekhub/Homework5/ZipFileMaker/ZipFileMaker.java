package com.geekhub.Homework5.ZipFileMaker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileMaker {
    public void makeZip(Map<String, List<File>> allFilesToZip) throws ZipCreateException {

        for (String format : allFilesToZip.keySet()) {
            try {
                writeData(allFilesToZip.get(format), format);
            } catch (IOException e) {
                throw new ZipCreateException("Error creating archive: ", e);
            }
        }
    }

    private void writeData(List<File> filesList, String format) throws IOException {
        ZipOutputStream zOutputStream = new ZipOutputStream(new FileOutputStream(format + ".zip"));

        for (File file : filesList) {
            zOutputStream.putNextEntry(new ZipEntry(file.getPath().substring(3)));
            FileInputStream fileInputStream = new FileInputStream(file);

            byte[] buffer = new byte[4096];
            int data;

            while ((data = fileInputStream.read()) != -1) {
                zOutputStream.write(buffer, 0, data);
            }
        }
        zOutputStream.close();
    }
}

