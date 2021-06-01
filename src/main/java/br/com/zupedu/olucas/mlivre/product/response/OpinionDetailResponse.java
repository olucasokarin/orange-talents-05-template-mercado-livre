package br.com.zupedu.olucas.mlivre.product.response;

import br.com.zupedu.olucas.mlivre.product.model.Opinion;

import javax.validation.constraints.*;

public class OpinionDetailResponse {
    private Long id;
    @Min(1)
    @Max(5)
    private Integer grade;
    @NotBlank
    private String title;
    @NotBlank
    @Size(max = 500)
    private String description;
    @NotNull
    private String user;


    public OpinionDetailResponse(Opinion opinion) {
        this.id = opinion.getId();
        this.grade = opinion.getGrade();
        this.title = opinion.getTitle();
        this.description = opinion.getDescription();
        this.user = opinion.getUsernameFromUser();
    }

    public Long getId() {
        return id;
    }

    public Integer getGrade() {
        return grade;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUser() {
        return user;
    }
}
