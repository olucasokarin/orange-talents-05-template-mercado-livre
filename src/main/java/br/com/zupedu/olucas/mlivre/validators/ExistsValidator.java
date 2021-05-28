package br.com.zupedu.olucas.mlivre.validators;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsValidator implements ConstraintValidator<Exists, Object> {

    @PersistenceContext
    private EntityManager manager;

    private Class<?> entity;
    private String attribute;

    @Override
    public void initialize(Exists annotation) {
        this.entity = annotation.entity();
        this.attribute = annotation.attribute();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value == null)
            return true;

        Query query = manager.createQuery("select 1 from " + entity.getName()
                                            + " where " + attribute + " = :comparator");
        query.setParameter("comparator", value);

        List<?> result = query.getResultList();
        return !result.isEmpty();
    }
}
