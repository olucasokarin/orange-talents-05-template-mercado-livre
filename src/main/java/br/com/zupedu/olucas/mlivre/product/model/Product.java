package br.com.zupedu.olucas.mlivre.product.model;

import br.com.zupedu.olucas.mlivre.category.model.Category;
import br.com.zupedu.olucas.mlivre.product.request.CharacteristicRequest;
import br.com.zupedu.olucas.mlivre.user.model.User;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Positive
    private BigDecimal amount;
    @NotNull
    @PositiveOrZero
    private Integer quantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Characteristic> characteristics = new HashSet<>();
    @NotNull
    @Column(length = 1_000)
    private String description;
    @NotNull
    @ManyToOne
    private Category category;
    @NotNull
    @ManyToOne
    private User user;
    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();

    @Deprecated
    public Product() {
    }


    public Product(String name, BigDecimal amount, Integer quantity,
                   List<CharacteristicRequest> characteristics, String description,
                   Category category, User user) {
        this.name = name;
        this.amount = amount;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
        this.user = user;

        Set<Characteristic> characteristicSet = characteristics.stream()
                .map(characteristic -> characteristic.convertRequestToEntity(this))
                .collect(Collectors.toSet());
        this.characteristics.addAll(characteristicSet);
    }
}