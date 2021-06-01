package br.com.zupedu.olucas.mlivre.product.request;

import br.com.zupedu.olucas.mlivre.product.model.Opinion;
import br.com.zupedu.olucas.mlivre.product.model.Product;
import br.com.zupedu.olucas.mlivre.user.model.User;

import javax.validation.constraints.*;

public class OpinionRequest {
    @Min(1)
    @Max(5)
    private Integer grade;
    @NotBlank
    private String title;
    @NotBlank
    @Size(max = 500)
    private String description;

    public OpinionRequest(Integer grade, String title, String description) {
        this.grade = grade;
        this.title = title;
        this.description = description;
    }

    public Opinion convertRequestToEntity(User user, Product product) {
        return new Opinion(this.grade, this.title, this.description, user, product);
    }
}
