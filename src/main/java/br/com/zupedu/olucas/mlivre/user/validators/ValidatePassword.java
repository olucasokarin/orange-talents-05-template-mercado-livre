package br.com.zupedu.olucas.mlivre.user.validators;

import br.com.zupedu.olucas.mlivre.user.request.UserRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Configuration
public class ValidatePassword implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors())
            return;

        UserRequest userRequest = (UserRequest) o;

        if(!userRequest.getPassword().equals(userRequest.getConfirmPassword()))
            errors.rejectValue("password", null, "Password mismatch");

    }
}
