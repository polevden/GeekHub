package com.geekhub.Homework5.ZipFileMaker.source;

import java.io.File;

public interface FileFilter {
    boolean accept(File path);

    String getFileCategory();
}