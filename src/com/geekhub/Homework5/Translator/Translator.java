package com.geekhub.Homework5.Translator;

import com.geekhub.Homework5.Translator.source.URLSourceProvider;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * Provides utilities for translating texts to russian language.<br/>
 * Uses Yandex Translate API, more information at <a href="http://api.yandex.ru/translate/">http://api.yandex.ru/translate/</a><br/>
 * Depends on {@link URLSourceProvider} for accessing Yandex Translator API service
 */
public class Translator {
    /**
     * Yandex Translate API key could be obtained at <a href="http://api.yandex.ru/key/form.xml?service=trnsl">http://api.yandex.ru/key/form.xml?service=trnsl</a>
     * to do that you have to be authorized.
     */
    private static final String YANDEX_API_KEY = "trnsl.1.1.20131116T095927Z.86fe567e8de2cf44.5be1510f166cd444fdd9363db18bb3b5537bb7e9";
    private static final String TRANSLATION_DIRECTION = "ru";

    private URLSourceProvider urlSourceProvider;

    public Translator(URLSourceProvider urlSourceProvider) {
        this.urlSourceProvider = urlSourceProvider;
    }

    /**
     * Translates text to russian language
     *
     * @param original text to translate
     * @return translated text
     * @throws IOException
     */
    public String translate(String original) throws TranslateException {
        try {
            return parseContent(prepareURL(original));
        } catch (IOException e) {
            throw new TranslateException("Parsing error: " + e);
        }
    }

    /**
     * Prepares URL to invoke Yandex Translate API service for specified text
     *
     * @param text to translate
     * @return url for translation specified text
     */
    private String prepareURL(String text) throws IOException {
        return "https://translate.yandex.net/api/v1.5/tr/translate?key=" + YANDEX_API_KEY + "&text=" + encodeText(text) + "&lang=" + TRANSLATION_DIRECTION;
    }

    /**
     * Parses content returned by Yandex Translate API service. Removes all tags and system texts. Keeps only translated text.
     *
     * @param content that was received from Yandex Translate API by invoking prepared URL
     * @return translated text
     */
    private String parseContent(String content) throws IOException {
        String translatedContent = urlSourceProvider.load(content);
        int contentCharLength = translatedContent.toCharArray().length - 1,
                beginIndex = 0,
                endIndex = contentCharLength;
        for (int i = 0; i < contentCharLength; i++) {
            if (content.charAt(i) == '<'
                    && content.charAt(i + 1) == 't'
                    && content.charAt(i + 2) == 'e'
                    && content.charAt(i + 3) == 'x'
                    && content.charAt(i + 4) == 't'
                    && content.charAt(i + 5) == '>') {
                beginIndex = i + 6;
                i += 6;
            }
            if (content.charAt(i) == '<'
                    && content.charAt(i + 1) == '/'
                    && content.charAt(i + 2) == 't'
                    && content.charAt(i + 3) == 'e'
                    && content.charAt(i + 4) == 'x'
                    && content.charAt(i + 5) == 't'
                    && content.charAt(i + 6) == '>') {
                endIndex = i;
                break;
            }
        }
        return content.substring(beginIndex, endIndex);
    }

    /**
     * Encodes text that need to be translated to put it as URL parameter
     *
     * @param text to be translated
     * @return encoded text
     */

    private String encodeText(String text) throws IOException {
        return URLEncoder.encode(text, "UTF-8");
    }
}
