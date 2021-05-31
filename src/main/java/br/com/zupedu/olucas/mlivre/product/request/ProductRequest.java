package br.com.zupedu.olucas.mlivre.product.request;

import br.com.zupedu.olucas.mlivre.category.model.Category;
import br.com.zupedu.olucas.mlivre.product.model.Product;
import br.com.zupedu.olucas.mlivre.user.model.User;
import br.com.zupedu.olucas.mlivre.validators.Exists;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.*;

public class ProductRequest {
    @NotBlank
    private String name;
    @NotNull
    @Positive
    private BigDecimal amount;
    @NotNull
    @PositiveOrZero
    private Integer quantity;
    @NotNull
    @Exists(entity = Category.class)
    private Long categoryId;
    @NotNull
    @Size(min = 3)
    private List<CharacteristicRequest> characteristics;
    @NotNull
    @Size(max = 1_000)
    private String description;

    public ProductRequest(String name, BigDecimal amount, Integer quantity, Long categoryId,
                          List<CharacteristicRequest> characteristics, String description) {
        this.name = name;
        this.amount = amount;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.characteristics = characteristics;
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public List<CharacteristicRequest> getCharacteristics() {
        return characteristics;
    }

    public Product convertRequestToEntity(User user, Category category) {
        return new Product(name, amount, quantity,
                characteristics, description, category, user);
    }

    public boolean hasEqualsName() {
        HashSet<String> nameEquals = new HashSet<>();
        for (CharacteristicRequest characteristic : characteristics)
            if(!nameEquals.add(characteristic.getName()))
                return true;

        return false;
    }
}
