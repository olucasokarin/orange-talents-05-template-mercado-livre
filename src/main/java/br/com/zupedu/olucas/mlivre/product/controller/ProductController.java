package br.com.zupedu.olucas.mlivre.product.controller;

import br.com.zupedu.olucas.mlivre.category.model.Category;
import br.com.zupedu.olucas.mlivre.category.repository.CategoryRepository;
import br.com.zupedu.olucas.mlivre.product.model.Product;
import br.com.zupedu.olucas.mlivre.product.repository.ProductRepository;
import br.com.zupedu.olucas.mlivre.product.request.ProductRequest;
import br.com.zupedu.olucas.mlivre.product.validators.ValidateUniqueCharacteristic;
import br.com.zupedu.olucas.mlivre.user.model.User;
import br.com.zupedu.olucas.mlivre.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity createProduct(@RequestBody @Valid ProductRequest productRequest,
                                        Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        Category category = categoryRepository.findById(productRequest.getCategoryId()).get();
        Product product = productRequest.convertRequestToEntity(user, category);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new ValidateUniqueCharacteristic());
    }

}
