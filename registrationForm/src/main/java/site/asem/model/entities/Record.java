/*
 * Copyright
 * Author: Andrii Semchenko
 * Project: #3_phonebook
 * License: MIT
 */

package site.asem.model.entities;

import java.util.Date;
import java.util.List;

public class Record {
    private long id;
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
    public Record() {
        creationDate = new Date();
        lastModificationDate = new Date();
    }

    private void updateLastModificationDate() {
        lastModificationDate = new Date();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        updateLastModificationDate();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        updateLastModificationDate();
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        updateLastModificationDate();
    }

    public Group[] getGroups() {
        return (Group[]) groups.toArray();
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
        updateLastModificationDate();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        updateLastModificationDate();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        updateLastModificationDate();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        updateLastModificationDate();
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

    public void setNickname(String nickname) {
        this.nickname = nickname;
        updateLastModificationDate();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Record{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", nickname='" + nickname + '\'' +
                ", groups=" + groups +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
