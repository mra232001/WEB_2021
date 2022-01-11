package com.example.web.more;

import com.example.web.validation.FieldMatch;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "password_confirm", message = "The password fields must match")
})
public class ValidatedUser {

    @NotNull(message =  "is required")
    @Size(min = 1,message = "is required")
    private String Username;

    @NotNull(message =  "is required")
    @Size(min = 1,message = "is required")
    private String password;

    @NotNull(message =  "is required")
    @Size(min = 1,message = "is required")
    private String password_confirm;

    @NotNull(message =  "is required")
    @Size(min = 1,message = "is required")
    private String firstName;

    @NotNull(message =  "is required")
    @Size(min = 1,message = "is required")
    private String secondName;

    public ValidatedUser(){

    }


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirm() {
        return password_confirm;
    }

    public void setPassword_confirm(String password_confirm) {
        this.password_confirm = password_confirm;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
