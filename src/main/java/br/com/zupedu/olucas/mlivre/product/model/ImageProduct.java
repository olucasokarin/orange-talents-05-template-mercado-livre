package br.com.zupedu.olucas.mlivre.product.model;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class ImageProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne
    private Product product;
    @NotBlank
    @URL
    private String url;

    @Deprecated
    public ImageProduct() {
    }

    public ImageProduct(String url, Product product) {
        this.product = product;
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageProduct that = (ImageProduct) o;
        return Objects.equals(id, that.id) && Objects.equals(product, that.product) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, url);
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
