package br.com.zupedu.olucas.mlivre.category.controller;

import br.com.zupedu.olucas.mlivre.category.model.Category;
import br.com.zupedu.olucas.mlivre.category.repository.CategoryRepository;
import br.com.zupedu.olucas.mlivre.category.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        Optional<Category> categoryOptional = Optional.empty();
        if(categoryRequest.getCategoryMotherId() != null)
            categoryOptional = categoryRepository.findById(categoryRequest.getCategoryMotherId());

        Category category = categoryRequest.convertRequestToEntity(categoryOptional);
        categoryRepository.save(category);
        return ResponseEntity.ok().build();
    }
}
