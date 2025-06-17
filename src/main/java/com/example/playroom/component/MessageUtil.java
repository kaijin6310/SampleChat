package com.example.playroom.component;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtil {
    private static MessageSource messageSource;

    public MessageUtil(MessageSource messageSource) {
        MessageUtil.messageSource = messageSource;
    }

    /**
     * メッセージを取得
     * @param key メッセージキー
     * @param args 置換パラメータ（オプション）
     * @param locale 言語設定
     * @return メッセージ文字列
     */
    public static String getMessage(String key, Object[] args, Locale locale) {
        return messageSource.getMessage(key, args, locale);
    }

    /**
     * デフォルトロケール（日本語）でメッセージ取得
     * @param key メッセージキー
     * @return メッセージ文字列
     */
    public static String getMessage(String key) {
        return getMessage(key, null, Locale.JAPANESE);
    }
}
