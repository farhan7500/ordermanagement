package com.nomani.ordermanagement.enums;

public enum UserRole {
    USER("USER"),
    ADMIN("ADMIN");


    private final String value;

    UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
