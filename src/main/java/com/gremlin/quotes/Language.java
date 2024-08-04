package com.gremlin.quotes;

public enum Language {
    ENGLISH ("en"),
    RUSSIAN ("ru");

    private final String languageValue;

    Language(String languageValue) {
        this.languageValue = languageValue;
    }

    public String getLanguageValue() {
        return languageValue;
    }
}