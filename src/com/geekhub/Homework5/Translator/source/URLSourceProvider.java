package com.geekhub.source;

import java.io.IOException;

/**
 * Implementation for loading content from specified URL.<br/>
 * Valid paths to load are http://someurl.com, https://secureurl.com, ftp://frpurl.com etc.
 */
public class URLSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        //TODO: implement me
        return false;
    }

    @Override
    public String load(String pathToSource) throws IOException {
        //TODO: implement me
        return null;
    }
}
