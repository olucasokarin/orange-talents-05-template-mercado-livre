package br.com.zupedu.olucas.mlivre.category.request;

import br.com.zupedu.olucas.mlivre.category.model.Category;
import br.com.zupedu.olucas.mlivre.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Optional;

public class CategoryRequest {
    @NotBlank
    @UniqueValue(entity = Category.class, attribute = "name")
    private String name;

    @Positive
    private Long categoryMotherId;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CategoryRequest(String name) {
        this.name = name;
    }

    public Long getCategoryMotherId() {
        return categoryMotherId;
    }

    public Category convertRequestToEntity(Optional<Category> categoryOptional) {
        Category category = new Category(this.name);
        if (categoryOptional.isPresent()) {
            Category categoryMother = categoryOptional.get();
            category.setCategoryMother(categoryMother);
        }
        return category;
    }
}
