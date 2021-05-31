package br.com.zupedu.olucas.mlivre.product.request;

import br.com.zupedu.olucas.mlivre.product.model.Characteristic;
import br.com.zupedu.olucas.mlivre.product.model.Product;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class CharacteristicRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    public CharacteristicRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacteristicRequest that = (CharacteristicRequest) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Characteristic convertRequestToEntity(Product product) {
        return new Characteristic(this.name, this.description, product);
    }
}
