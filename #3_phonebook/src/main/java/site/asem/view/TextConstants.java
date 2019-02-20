/*
 * Copyright
 * Author: Andrii Semchenko
 * Project: #3_phonebook
 * License: MIT
 */

package site.asem.view;

public interface TextConstants {
    String INPUTING_RECORD_INFO = "=== Inputing record ===";
    String INPUT_FIRST_NAME = "Input first name: ";
    String INPUT_LAST_NAME = "Input last name: ";
    String INPUT_NICKNAME = "Input nick: ";
    String INPUT_PATRONYMIC = "Input patronymic name: ";
    String INPUT_GROUPS = "Input groups separated by space: ";
    String INPUT_MOBILE_PHONE = "Input mobile phone : ";
    String INPUT_EMAIL = "Input email: ";
    // TODO add examples in some cases

    String INPUT_INDEX = "Input your index: ";
    String INPUT_CITY = "Input city: ";
    String INPUT_STREET = "Input street: ";
    String INPUT_HOUSE_NUMBER = "Input house number: ";
    String INPUT_FLAT_NUMBER = "Input flat number: ";
    /* Is used as an argument for String.format()*/
    String WRONG_INPUT_MESSAGE_FORMAT = "Your input does not fill requirements."
            + " Probably there is an error. Regex '%s' Please try again";

    String SORRY_OCCUPIED_NICKNAME = "Sorry, entered nickname has been taken. Try another one. Good luck!";
}
