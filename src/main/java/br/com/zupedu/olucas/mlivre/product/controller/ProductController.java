package br.com.zupedu.olucas.mlivre.product.controller;

import br.com.zupedu.olucas.mlivre.category.model.Category;
import br.com.zupedu.olucas.mlivre.category.repository.CategoryRepository;
import br.com.zupedu.olucas.mlivre.product.model.Opinion;
import br.com.zupedu.olucas.mlivre.product.model.Product;
import br.com.zupedu.olucas.mlivre.product.repository.ProductRepository;
import br.com.zupedu.olucas.mlivre.product.request.OpinionRequest;
import br.com.zupedu.olucas.mlivre.product.request.ProductImageRequest;
import br.com.zupedu.olucas.mlivre.product.request.ProductRequest;
import br.com.zupedu.olucas.mlivre.product.utils.UploaderFake;
import br.com.zupedu.olucas.mlivre.product.validators.ValidateUniqueCharacteristic;
import br.com.zupedu.olucas.mlivre.user.model.User;
import br.com.zupedu.olucas.mlivre.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UploaderFake uploaderFake;

    @PostMapping
    public ResponseEntity createProduct(@RequestBody @Valid ProductRequest productRequest,
                                        Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        Category category = categoryRepository.findById(productRequest.getCategoryId()).get();
        Product product = productRequest.convertRequestToEntity(user, category);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/images")
    public ResponseEntity updateImageProduct(@PathVariable("id") Long id,
                                             @Valid ProductImageRequest imageRequest,
                                             Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        Product product = productRepository.findById(id).get();

        if(!product.belongToTheOwner(user))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        Set<String> links = uploaderFake.send(imageRequest.getImages());
        product.associateLinks(links);
        productRepository.save(product);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/opinions")
    public ResponseEntity<?> sendOpinion(@PathVariable("id") Long id,
                                         @RequestBody @Valid OpinionRequest opinionRequest,
                                         Principal principal) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");

        Product product = optionalProduct.get();
        User user = userRepository.findByEmail(principal.getName());

        Opinion opinion = opinionRequest.convertRequestToEntity(user, product);
        product.associateOpinion(opinion);
        productRepository.save(product);

        return ResponseEntity.ok().build();
    }

    @InitBinder(value = "ProductRequest")
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new ValidateUniqueCharacteristic());
    }

}
