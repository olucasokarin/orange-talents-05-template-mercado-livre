package br.com.zupedu.olucas.mlivre.product.response;

import br.com.zupedu.olucas.mlivre.product.model.Question;

import javax.validation.constraints.NotNull;

public class QuestionResponse {
    private Long id;
    @NotNull
    private String title;
    private String user;

    public QuestionResponse(Question question) {
        this.id = question.getId();
        this.title = question.getTitle();
        this.user = question.getUsernameFromQuestion();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUser() {
        return user;
    }
}
