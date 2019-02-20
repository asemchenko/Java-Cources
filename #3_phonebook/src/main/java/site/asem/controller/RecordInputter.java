/*
 * Copyright
 * Author: Andrii Semchenko
 * Project: #3_phonebook
 * License: MIT
 */

package site.asem.controller;

import site.asem.model.entities.Address;
import site.asem.model.entities.Group;
import site.asem.model.entities.Record;
import site.asem.view.ConsoleView;

import java.util.*;

// loading string constants

/**
 * An inputter which can create Record instance
 *
 * @see Record
 */
class RecordInputter {
    private ConsoleView view;
    private RegexScanner sc;
    private RegexConstants regexConstants;

    RecordInputter(ConsoleView view, Scanner scanner) {
        this.view = view;
        this.sc = new RegexScanner(view, scanner);
        setLocale(Locale.getDefault());
    }

    public RecordInputter(ConsoleView view, Scanner scanner, Locale locale) {
        this.view = view;
        this.sc = new RegexScanner(view, scanner);
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
        loadRegexConstants(locale);
    }

    private void loadRegexConstants(Locale locale) {
        ResourceBundle regexConstants = ResourceBundle.getBundle("regexConstants",
                locale);
        this.regexConstants = new RegexConstants(regexConstants);
    }

    /**
     * Reads data about record from console and creates a record
     * based on mentioned data
     *
     * @return record
     */
    Record inputRecord() {
        view.println(view.getTextConstants().INPUTTING_RECORD_INFO);
        String firstName = sc.getResponse(view.getTextConstants().INPUT_FIRST_NAME, regexConstants.FIRST_NAME_REGEX);
        String lastName = sc.getResponse(view.getTextConstants().INPUT_LAST_NAME, regexConstants.LAST_NAME_REGEX);
        String patronymic = sc.getResponse(view.getTextConstants().INPUT_PATRONYMIC, regexConstants.PATRONYMIC_REGEX);
        String nickname = sc.getResponse(view.getTextConstants().INPUT_NICKNAME, regexConstants.NICKNAME_REGEX);
        List<Group> groups = inputGroups();
        String mobilePhone = sc.getResponse(view.getTextConstants().INPUT_MOBILE_PHONE, regexConstants.MOBILE_PHONE_REGEX);
        String email = sc.getResponse(view.getTextConstants().INPUT_EMAIL, regexConstants.EMAIL_REGEX);
        Address address = inputAddress();
        // record creating and initialization
        Record record = new Record();
        record.setFirstName(firstName);
        record.setLastName(lastName);
        record.setPatronymic(patronymic);
        record.setNickname(nickname);
        record.setGroups(groups);
        record.setMobilePhone(mobilePhone);
        record.setEmail(email);
        record.setAddress(address);
        return record;
    }

    /**
     * Gets from user nickname that matches appropriate regex
     * and stores it DIRECTLY into basis data structure
     *
     * @param basis object to be stored nickname into
     * @return basis with new nickname
     */
    Record reinputNickname(Record basis) {
        String nickname = sc.getResponse(view.getTextConstants().INPUT_NICKNAME, regexConstants.NICKNAME_REGEX);
        basis.setNickname(nickname);
        return basis;
    }

    /**
     * Consistently reads data about address and then
     * creates instance of Address based on mentioned
     * data
     *
     * @return address
     */
    private Address inputAddress() {
        // TODO Should address be instanced after getting parameters?
        Address address = new Address();
        address.index = sc.getResponse(view.getTextConstants().INPUT_INDEX, regexConstants.INDEX_REGEX);
        address.city = sc.getResponse(view.getTextConstants().INPUT_CITY, regexConstants.CITY_REGEX);
        address.street = sc.getResponse(view.getTextConstants().INPUT_STREET, regexConstants.STREET_REGEX);
        address.houseNumber = sc.getResponse(view.getTextConstants().INPUT_HOUSE_NUMBER, regexConstants.HOUSE_NUMBER_REGEX);
        address.flatNumber = sc.getResponse(view.getTextConstants().INPUT_FLAT_NUMBER, regexConstants.FLAT_NUMBER_REGEX);
        return address;
    }

    /**
     * Reads group list and returns it
     *
     * @return list of groups
     */
    private List<Group> inputGroups() {
        String response = sc.getResponse(view.getTextConstants().INPUT_GROUPS, regexConstants.GROUPS_REGEX);
        String[] groups = response.split(" ");
        List<Group> res = new LinkedList<>();
        for (String group : groups) {
            // TODO fix problem with localization here
            res.add(Group.valueOf(group));
        }
        return res;
    }
}
