package com.viettelpost.scrape.ultils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Component
public class LanguageUtils {

    public final static String LANG_VI = "vi-VN";
    public final static String LANG_EN = "en-US";

    @Autowired
    MessageSource messageSource;

    public String getMessage(String languageHeader, String key) {
        String langTag = LANG_VI;
        if (TextUtils.isEmpty(languageHeader) || LANG_VI.equals(languageHeader)) {
            langTag = LANG_VI;
        }
        if (LANG_EN.equals(languageHeader)) {
            langTag = LANG_EN;
        }
        String outMessage = messageSource.getMessage(key, null, Locale.forLanguageTag(langTag));
        if (TextUtils.isEmpty(outMessage)) {
            outMessage = messageSource.getMessage("common.system.error", null, Locale.getDefault());
        }
        return outMessage;
    }

    public String getLanguageTag() {
        String languageHeader = LANG_VI;
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            languageHeader = request.getHeader("Language");
        }
        if (TextUtils.isEmpty(languageHeader) || LANG_VI.equals(languageHeader)) {
            languageHeader = LANG_VI;
        }
        if (LANG_EN.equals(languageHeader)) {
            languageHeader = LANG_EN;
        }
        return languageHeader;
    }

    public String getMessageByKey(String key) {
        String languageHeader = LANG_VI;
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            languageHeader = request.getHeader("Language");
        }
        return getMessage(languageHeader, key);
    }

}
