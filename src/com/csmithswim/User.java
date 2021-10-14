package com.csmithswim;

class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName  = "";
    }

    public void setFirstName(String firstName) {
        // write your code here
        if (!firstName.equals(null) || firstName.equals("")) {
            System.out.println(firstName);
        }
    }

    public void setLastName(String lastName) {
        // write your code here
        if (!firstName.equals(null) || !firstName.equals("")) {
            System.out.println(lastName);
        }
    }

    public String getFullName() {
        if (!firstName.equals(null) && !firstName.equals("") && lastName.equals(null) || lastName.equals("")) {
            return firstName;
        }
        if (!lastName.equals(null) && !lastName.equals("") && firstName.equals(null) || firstName.equals("")) {
            return lastName;
        } else {
            return firstName + " " + lastName;
        }
    }
}