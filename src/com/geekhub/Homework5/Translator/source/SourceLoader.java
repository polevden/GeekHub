package com.geekhub.source;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * SourceLoader should contain all implementations of SourceProviders to be able to load different sources.
 */
public class SourceLoader {
    private List<SourceProvider> sourceProviders = new ArrayList<>();

    public SourceLoader() {
        //TODO: initialize me
    }

    public String loadSource(String pathToSource) throws IOException {
        //TODO: implement me
        return null;
    }
}
