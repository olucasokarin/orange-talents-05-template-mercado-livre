package br.com.zupedu.olucas.mlivre.product.response;

import br.com.zupedu.olucas.mlivre.category.model.Category;

import javax.validation.constraints.NotNull;

public class CategoryResponse {
    private Long id;
    @NotNull
    private String name;
    private CategoryResponse categoryMother;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        if(category.getCategoryMother() != null)
            this.categoryMother = new CategoryResponse(category.getCategoryMother());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CategoryResponse getCategoryMother() {
        return categoryMother;
    }
}
