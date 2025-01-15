package com.idv.demo.services;

import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TranslationService {

    private final MessageSource messageSource;

    public String getTranslatedMessage(String key, Locale locale) {
        try {
            return messageSource.getMessage(key, null, locale);
        } catch (Exception e) {
            return key;
        }
    }
}
