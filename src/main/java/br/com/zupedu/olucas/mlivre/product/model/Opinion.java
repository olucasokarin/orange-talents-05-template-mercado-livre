package br.com.zupedu.olucas.mlivre.product.model;

import br.com.zupedu.olucas.mlivre.user.model.User;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Opinion {
    @Id
    @GeneratedValue
    private Long id;
    @Min(1)
    @Max(5)
    private Integer grade;
    @NotNull
    @NotEmpty
    private String title;
    @NotNull
    @Column(length = 500)
    private String description;
    @NotNull
    @ManyToOne
    private User user;
    @NotNull
    @ManyToOne
    private Product product;

    @Deprecated
    public Opinion() {
    }

    public Opinion(Integer grade, String title, String description,
                   User user, Product product) {
        this.grade = grade;
        this.title = title;
        this.description = description;
        this.user = user;
        this.product = product;
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

    public String getUsernameFromUser(){
        return user.getEmail();
    }

}
