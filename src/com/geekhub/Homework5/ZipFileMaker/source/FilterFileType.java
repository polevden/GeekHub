package com.geekhub.Homework5.ZipFileMaker.source;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FilterFileType implements FileFilter {
    private String fileCategory;
    private Set<String> acceptTypes = new HashSet<>();

    public FilterFileType(FileType category, String type, String... types) {
        this.fileCategory = category.name();
        acceptTypes.addAll(Arrays.asList(types));
    }

    @Override
    public boolean accept(File path) {
        String fileName = path.getName();

        if (path.isDirectory()) {
            return false;
        }

        for (String type : acceptTypes) {
            if (fileName.endsWith(type)) {
                return true;
            }
        }
        return false;
    }

    public String getFileCategory() {
        return fileCategory;
    }
}