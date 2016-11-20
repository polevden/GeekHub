package com.geekhub.Homework5.ZipFileMaker;

import com.geekhub.Homework5.ZipFileMaker.source.FileFilter;
import com.geekhub.Homework5.ZipFileMaker.source.FileScanner;
import com.geekhub.Homework5.ZipFileMaker.source.FilterFileType;

import java.io.File;
import java.util.Scanner;

import static com.geekhub.Homework5.ZipFileMaker.source.FileType.*;

public class ZipFileMakerController {
    public static void main(String[] args) {
        FileFilter audioFilter = new FilterFileType(AUDIO, "mp3", "wav", "wma");
        FileFilter videoFilter = new FilterFileType(VIDEO, "avi", "mp4", "flv");
        FileFilter imageFilter = new FilterFileType(IMAGE, "jpeg", "jpg", "gif");

        Scanner scanner = new Scanner(System.in);
        String dirPath = scanner.nextLine();

        try {
            File makeZipDir = new File(dirPath);
            if (!makeZipDir.exists()) {
                throw new FileNotExistException("File not exist: " + dirPath);
            }

            FileScanner fileScanner = new FileScanner(makeZipDir);
            fileScanner.filterFiles(audioFilter, videoFilter, imageFilter);

            ZipFileMaker archive = new ZipFileMaker();
            archive.makeZip(fileScanner.getFilesByTypes());
        } catch (FileNotExistException e) {
            System.out.println(e.getMessage());
        } catch (ZipCreateException e) {
            System.out.println(e.getMessage());
        }
    }
}
