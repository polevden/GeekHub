package com.geekhub.source;

import java.io.IOException;

/**
 * Base interface to access different sources.</br>
 * isAllowed method should protect and help to determine can we load resource for specified path ot not.
 */
public interface SourceProvider {
    /**
     * Determines can current implementation load source by provided pathToSource
     * @param pathToSource  absolute path to the source
     * @return whether current implementation load the source for specified pathToSource
     */
    boolean isAllowed(String pathToSource);

    /**
     * Loads text from specified path.
     * @param pathToSource absolute path to the source
     * @return content of the source for specified pathToSource
     */
    String load(String pathToSource) throws IOException;
}
