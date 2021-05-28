package br.com.zupedu.olucas.mlivre.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ExistsValidator.class })
public @interface Exists {

    String message() default "Data not exists";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default  { };

    Class<?> entity(); // the entity to be searched in the database
    String attribute() default "id"; // comparison parameter
}
