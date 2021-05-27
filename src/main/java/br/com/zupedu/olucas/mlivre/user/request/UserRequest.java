package br.com.zupedu.olucas.mlivre.user.request;

import br.com.zupedu.olucas.mlivre.user.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class UserRequest {
    @Email
    @NotBlank
    private String email;
    @Size(min = 6)
    private String password;
    @Size(min = 6)
    private String confirmPassword;

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRequest(String email, String password, String confirmPassword) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public User convertRequestToEntity() {
        return new User(this.email, this.password);
    }

}
