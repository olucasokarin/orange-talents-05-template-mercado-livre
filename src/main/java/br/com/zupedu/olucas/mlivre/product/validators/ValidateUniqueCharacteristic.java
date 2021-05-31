package br.com.zupedu.olucas.mlivre.product.validators;

import br.com.zupedu.olucas.mlivre.product.request.ProductRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Configuration
public class ValidateUniqueCharacteristic implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ProductRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors())
            return;

        ProductRequest request = (ProductRequest) o;
        if(request.hasEqualsName())
            errors.rejectValue("characteristics", null, "Don't use same name in characteristic");
    }
}
