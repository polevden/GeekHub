package com.geekhub.Homework5.Translator.source;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * SourceLoader should contain all implementations of SourceProviders to be able to load different sources.
 */
public class SourceLoader {
    private List<SourceProvider> sourceProviders = new ArrayList<>();

    public SourceLoader() {
        sourceProviders.add(new FileSourceProvider());
        sourceProviders.add(new URLSourceProvider());
    }

    public String loadSource(String pathToSource) throws IOException {
        for (SourceProvider spList : sourceProviders) {
            if (spList.isAllowed(pathToSource)) {
                return spList.load(pathToSource);
            }
        }
        throw new IOException("Source can not load");
    }
}
