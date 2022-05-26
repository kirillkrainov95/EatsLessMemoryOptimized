package com.company;

public class User implements Comparable {
    long phoneNumber;
    String name;

    public User(long phoneNumber, String name) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        return (int) (phoneNumber - ((User)o).phoneNumber);
    }

    public String toString() {
        return phoneNumber + "; " + name;
    }
}