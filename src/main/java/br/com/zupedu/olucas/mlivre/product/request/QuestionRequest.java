package br.com.zupedu.olucas.mlivre.product.request;

import br.com.zupedu.olucas.mlivre.product.model.Product;
import br.com.zupedu.olucas.mlivre.product.model.Question;
import br.com.zupedu.olucas.mlivre.user.model.User;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class QuestionRequest {
    @NotBlank
    private String title;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public QuestionRequest(String title) {
        this.title = title;
    }

    public Question convertRequestToEntity(Product product, User user) {
        return new Question(this.title, product, user);
    }
}
