package br.com.zupedu.olucas.mlivre.product.response;

import br.com.zupedu.olucas.mlivre.product.model.*;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProductResponse {
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    @Positive
    private BigDecimal amount;
    @NotNull
    @PositiveOrZero
    private Integer quantity;
    @NotNull
    @Size(max = 500)
    private String description;
    private String user;
    @NotNull
    private List<CharacteristicResponse> characteristics; //response

    @NotNull
    private CategoryResponse category; //response
    private List<ImageProductResponse> images; //response
    private OpinionResponse opinions; //response
    private List<QuestionResponse> questions; //response


    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.amount = product.getAmount();
        this.quantity = product.getQuantity();
        this.description = product.getDescription();
        this.user = product.getUsernameFromProduct();
        this.category = new CategoryResponse(product.getCategory());
        this.opinions = new OpinionResponse(product.getOpinions());

        this.characteristics = product.getCharacteristics().stream()
                .map(characteristic -> new CharacteristicResponse(characteristic))
                .collect(Collectors.toList());

        this.images = product.getImages().stream()
                .map(image -> new ImageProductResponse(image))
                .collect(Collectors.toList());

        this.questions = product.getQuestions().stream()
                .map(question -> new QuestionResponse(question))
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getUser() {
        return user;
    }

    public List<CharacteristicResponse> getCharacteristics() {
        return characteristics;
    }

    public CategoryResponse getCategory() {
        return category;
    }

    public List<ImageProductResponse> getImages() {
        return images;
    }

    public OpinionResponse getOpinions() {
        return opinions;
    }

    public List<QuestionResponse> getQuestions() {
        return questions;
    }
}
