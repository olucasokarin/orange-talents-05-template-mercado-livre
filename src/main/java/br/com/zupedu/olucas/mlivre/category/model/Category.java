package br.com.zupedu.olucas.mlivre.category.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String name;
    @ManyToOne
    private Category categoryMother;

    @Deprecated
    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public void setCategoryMother(Category categoryMother) {
        this.categoryMother = categoryMother;
    }
}
