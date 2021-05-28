package br.com.zupedu.olucas.mlivre.category.validators;

import br.com.zupedu.olucas.mlivre.category.model.Category;
import br.com.zupedu.olucas.mlivre.category.request.CategoryRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Configuration
public class ValidateCategoryMother implements Validator {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public boolean supports(Class<?> aClass) {
        return CategoryRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors())
            return;

        CategoryRequest categoryRequest = (CategoryRequest) o;

        if(categoryRequest.getCategoryMotherId() != null) {
            Query query = manager.createQuery("select 1 from Category where id = :id");
            query.setParameter("id", categoryRequest.getCategoryMotherId());

            List<Category> categories = query.getResultList();
            if(categories.isEmpty())
                errors.rejectValue("categoryMotherId", null, "Category Mother not found");

        }
    }
}
