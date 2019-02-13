/*
 * Copyright
 * Author: Andrii Semchenko
 * Project: #3_phonebook
 * License: MIT
 */

package site.asem.controller;

public interface RegexContainer {
    String FIRST_NAME_REGEX = "^[a-zA-Z]+(([\\'\\,\\.\\-][a-zA-Z])?[a-zA-Z]*)*$";
    String LAST_NAME_REGEX = "^[a-zA-Z]+(([\\'\\,\\.\\-][a-zA-Z])?[a-zA-Z]*)*$";
    String PATRONYMIC_REGEX = "^[a-zA-Z]+(([\\'\\,\\.\\-][a-zA-Z])?[a-zA-Z]*)*$";
    String GROUP_REGEX = "RELATIVES|FRIENDS|COLLEAGUES|OTHER";
    String GROUPS_REGEX = "(" + GROUP_REGEX + ")+";
    String MOBILE_PHONE_REGEX = "^\\+[1-9][0-9]{3,14}$";
    String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    String INDEX_REGEX = "^\\d{5}$";
    String CITY_REGEX = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$";
    String STREET_REGEX = "^(.+)\\s(\\d*(\\s*[^\\d\\s]+)*)$";
    String HOUSE_NUMBER_REGEX = "^\\d+[a-zA-Z]*$";
    String FLAT_NUMBER_REGEX = "^\\d+[a-zA-Z]*$";
}
