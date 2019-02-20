/*
 * Copyright
 * Author: Andrii Semchenko
 * Project: #3_phonebook
 * License: MIT
 */

package site.asem.model.entities;

import site.asem.model.entities.Address;
import site.asem.model.entities.Group;

import java.util.Date;
import java.util.List;

public class Record {
    public Record() {
        creationDate = new Date();
        lastModificationDate = new Date();
    }

    private String firstName;
    private String lastName;
    private String patronymic;
    private String nickname;

    private List<Group> groups;
    private String mobilePhone;
    private String email;
    private Address address;

    private Date creationDate;
    private Date lastModificationDate;

    private void updateLastModificationDate() {
        lastModificationDate = new Date();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        updateLastModificationDate();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        updateLastModificationDate();
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        updateLastModificationDate();
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
        updateLastModificationDate();
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        updateLastModificationDate();
    }

    public void setEmail(String email) {
        this.email = email;
        updateLastModificationDate();
    }

    public void setAddress(Address address) {
        this.address = address;
        updateLastModificationDate();
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
        updateLastModificationDate();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Group[] getGroups() {
        return (Group[]) groups.toArray();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Date getCreationDate() {
        return new Date(creationDate.getTime());
    }

    public Date getLastModificationDate() {
        return new Date(lastModificationDate.getTime());
    }

    public String getNickname() {
        return nickname;
    }
}
