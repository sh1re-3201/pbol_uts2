package com.sh1re.goldenbay.model;

public enum Role {
    ADMIN,
    USER;

    public String toUpperCase() {
        return this.name();
    }
}
