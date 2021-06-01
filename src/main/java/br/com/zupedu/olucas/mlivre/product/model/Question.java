package br.com.zupedu.olucas.mlivre.product.model;

import br.com.zupedu.olucas.mlivre.user.model.User;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String title;
    @NotNull
    @ManyToOne
    private Product product;
    @ManyToOne
    private User user;
    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();

    @Deprecated
    public Question() {
    }

    public Question(String title, Product product, User user) {
        this.title = title;
        this.product = product;
        this.user = user;
    }

    public String getUsernameFromQuestion() {
        return this.user.getEmail();
    }

    public String getUsernameFromProduct() {
        return this.product.getUsernameFromProduct();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
