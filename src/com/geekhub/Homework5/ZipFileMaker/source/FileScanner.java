package com.geekhub.Homework5.ZipFileMaker.source;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileScanner {
    private Map<String, List<File>> filesByTypes = new HashMap<>();
    private File makeZip;

    public FileScanner(File makeZip) {
        this.makeZip = makeZip;
    }

    public List<File> scan(File pathToDir, FileFilter filter) {
        List<File> filesList = new LinkedList<>();
        collect(pathToDir, filter, filesList);
        return filesList;
    }

    public void collect(File pathToDir, FileFilter filter, List<File> resultCollector) {

        if (pathToDir.isFile()) {
            if (filter.accept(pathToDir)) {
                resultCollector.add(pathToDir);
            }
        }

        if (pathToDir.isDirectory()) {
            String[] directories = pathToDir.list();

            for (String filename : directories) {
                collect(new File(pathToDir, filename), filter, resultCollector);
            }
        }
    }

    public void filterFiles(FileFilter... filters) {
        for (FileFilter filter : filters) {
            filesByTypes.put(filter.getFileCategory(), scan(makeZip, filter));
        }
    }

    public Map<String, List<File>> getFilesByTypes() {
        return filesByTypes;
    }
}