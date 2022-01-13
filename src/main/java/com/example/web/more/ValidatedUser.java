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
    private String username;

    @NotNull(message =  "password is required")
    @Size(min = 1,message = "is required")
    private String password;

    @NotNull(message =  "password is required")
    @Size(min = 1,message = "is required")
    private String password_confirm;

    public ValidatedUser(){
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
