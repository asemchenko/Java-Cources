/*
 * Copyright
 * Author: Andrii Semchenko
 * Project: #3_phonebook
 * License: MIT
 */

package site.asem.view;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public final class RegexConstants {
    private static Map<Locale, RegexConstants> cache = new HashMap<>();

    public static RegexConstants getForLocale(Locale locale) {
        if (!cache.containsKey(locale)) {
            ResourceBundle bundle = ResourceBundle.getBundle("regexConstants", locale);
            cache.put(locale, new RegexConstants(bundle));
        }
        return cache.get(locale);
    }

    public RegexConstants(ResourceBundle resourceBundle) {
        FIRST_NAME_REGEX = resourceBundle.getString("FIRST_NAME_REGEX");
        LAST_NAME_REGEX = resourceBundle.getString("LAST_NAME_REGEX");
        PATRONYMIC_REGEX = resourceBundle.getString("PATRONYMIC_REGEX");
        NICKNAME_REGEX = resourceBundle.getString("NICKNAME_REGEX");
        GROUP_REGEX = resourceBundle.getString("GROUP_REGEX");
        GROUPS_REGEX = String.format("(%s)( (%s))*", GROUP_REGEX, GROUP_REGEX);
        MOBILE_PHONE_REGEX = resourceBundle.getString("MOBILE_PHONE_REGEX");
        EMAIL_REGEX = resourceBundle.getString("EMAIL_REGEX");

        INDEX_REGEX = resourceBundle.getString("INDEX_REGEX");
        CITY_REGEX = resourceBundle.getString("CITY_REGEX");
        STREET_REGEX = resourceBundle.getString("STREET_REGEX");
        HOUSE_NUMBER_REGEX = resourceBundle.getString("HOUSE_NUMBER_REGEX");
        FLAT_NUMBER_REGEX = resourceBundle.getString("FLAT_NUMBER_REGEX");
    }

    public final String FIRST_NAME_REGEX;
    public final String LAST_NAME_REGEX;
    public final String PATRONYMIC_REGEX;
    public final String NICKNAME_REGEX;
    public final String GROUP_REGEX;
    public final String GROUPS_REGEX;
    public final String MOBILE_PHONE_REGEX;
    public final String EMAIL_REGEX;

    public final String INDEX_REGEX;
    public final String CITY_REGEX;
    public final String STREET_REGEX;
    public final String HOUSE_NUMBER_REGEX;
    public final String FLAT_NUMBER_REGEX;
}
