package org.example.model;

public enum EmployeeType {
    REGULAR_EMPLOYEE("Regular Employee"),
    CONTRACT_EMPLOYEE("Contract Employee");

    private String type;

    private EmployeeType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
