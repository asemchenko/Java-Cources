/*
 * Copyright
 * Author: Andrii Semchenko
 * Project: #3_phonebook
 * License: MIT
 */

package site.asem.view;

import java.util.ResourceBundle;

public final class TextConstants {
    TextConstants(ResourceBundle resourceBundle) {
        INPUTTING_RECORD_INFO = resourceBundle.getString("INPUTTING_RECORD_INFO");
        INPUT_FIRST_NAME = resourceBundle.getString("INPUT_FIRST_NAME");
        INPUT_LAST_NAME = resourceBundle.getString("INPUT_LAST_NAME");
        INPUT_NICKNAME = resourceBundle.getString("INPUT_NICKNAME");
        INPUT_PATRONYMIC = resourceBundle.getString("INPUT_PATRONYMIC");
        INPUT_GROUPS = resourceBundle.getString("INPUT_GROUPS");
        INPUT_MOBILE_PHONE = resourceBundle.getString("INPUT_MOBILE_PHONE");
        INPUT_EMAIL = resourceBundle.getString("INPUT_EMAIL");
        INPUT_INDEX = resourceBundle.getString("INPUT_INDEX");
        INPUT_CITY = resourceBundle.getString("INPUT_CITY");
        INPUT_STREET = resourceBundle.getString("INPUT_STREET");
        INPUT_HOUSE_NUMBER = resourceBundle.getString("INPUT_HOUSE_NUMBER");
        INPUT_FLAT_NUMBER = resourceBundle.getString("INPUT_FLAT_NUMBER");
        WRONG_INPUT_MESSAGE_FORMAT = resourceBundle.getString("WRONG_INPUT_MESSAGE_FORMAT");
        SORRY_OCCUPIED_NICKNAME = resourceBundle.getString("SORRY_OCCUPIED_NICKNAME");
    }

    public final String INPUTTING_RECORD_INFO;
    public final String INPUT_FIRST_NAME;
    public final String INPUT_LAST_NAME;
    public final String INPUT_NICKNAME;

    public final String INPUT_PATRONYMIC;
    public final String INPUT_GROUPS;
    public final String INPUT_MOBILE_PHONE;
    public final String INPUT_EMAIL;

    public final String INPUT_INDEX;
    public final String INPUT_CITY;
    public final String INPUT_STREET;
    public final String INPUT_HOUSE_NUMBER;
    public final String INPUT_FLAT_NUMBER;
    /* Is used as an argument for public final String.format()*/;
    public final String WRONG_INPUT_MESSAGE_FORMAT;
    public final String SORRY_OCCUPIED_NICKNAME;
}
