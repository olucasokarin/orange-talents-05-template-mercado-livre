package br.com.zupedu.olucas.mlivre.category.controller;

import br.com.zupedu.olucas.mlivre.category.model.Category;
import br.com.zupedu.olucas.mlivre.category.repository.CategoryRepository;
import br.com.zupedu.olucas.mlivre.category.request.CategoryRequest;
import br.com.zupedu.olucas.mlivre.category.validators.ValidateCategoryMother;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ValidateCategoryMother validateCategoryMother;

    @PostMapping
    public ResponseEntity createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        Optional<Category> categoryOptional = Optional.empty();
        if(categoryRequest.getCategoryMotherId() != null)
            categoryOptional = categoryRepository.findById(categoryRequest.getCategoryMotherId());

        Category category = categoryRequest.convertRequestToEntity(categoryOptional);
        categoryRepository.save(category);
        return ResponseEntity.ok().build();
    }

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(validateCategoryMother);
    }
}
