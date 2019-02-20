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

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// loading string constants
import static site.asem.controller.RegexContainer.*;
import static site.asem.view.TextConstants.*;

/**
 * An inputter which can create Record instance
 *
 * @see Record
 */
class RecordInputter {
    private ConsoleView view;
    private RegexScanner sc;
    RecordInputter(ConsoleView view, Scanner scanner) {
        this.view = view;
        this.sc = new RegexScanner(view, scanner);
    }

    /**
     * Reads data about record from console and creates a record
     * based on mentioned data
     *
     * @return record
     */
    Record inputRecord() {
        view.println(INPUTING_RECORD_INFO);
        String firstName = sc.getResponse(INPUT_FIRST_NAME, FIRST_NAME_REGEX);
        String lastName = sc.getResponse(INPUT_LAST_NAME, LAST_NAME_REGEX);
        String patronymic = sc.getResponse(INPUT_PATRONYMIC, PATRONYMIC_REGEX);
        String nickname = sc.getResponse(INPUT_NICKNAME, NICKNAME_REGEX);
        List<Group> groups = inputGroups();
        String mobilePhone = sc.getResponse(INPUT_MOBILE_PHONE,
                MOBILE_PHONE_REGEX);
        String email = sc.getResponse(INPUT_EMAIL, EMAIL_REGEX);
        Address address = inputAddress();
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
     * @param basis object to be stored nickname into
     * @return basis with new nickname
     */
    Record reinputNickname(Record basis) {
        String nickname = sc.getResponse(INPUT_NICKNAME, NICKNAME_REGEX);
        basis.setNickname(nickname);
        return basis;
    }

    /**
     * Consistently reads data about address and then
     * creates instance of Address based on mentioned
     * data
     * @return address
     */
    private Address inputAddress() {
        // TODO Should address be instanced after getting parameters?
        Address address = new Address();
        address.index = sc.getResponse(INPUT_INDEX, INDEX_REGEX);
        address.city = sc.getResponse(INPUT_CITY, CITY_REGEX);
        address.street = sc.getResponse(INPUT_STREET, STREET_REGEX);
        address.houseNumber = sc.getResponse(INPUT_HOUSE_NUMBER, HOUSE_NUMBER_REGEX);
        address.flatNumber = sc.getResponse(INPUT_FLAT_NUMBER, FLAT_NUMBER_REGEX);
        return address;
    }

    /**
     * Reads group list and returns it
     * @return list of groups
     */
    private List<Group> inputGroups() {
        String response = sc.getResponse(INPUT_GROUPS, GROUPS_REGEX);
        String[] groups = response.split(" ");
        List<Group> res = new LinkedList<>();
        for (String group : groups) {
            // TODO fix problem with localization here
            res.add(Group.valueOf(group));
        }
        return res;
    }
}
