package br.com.zupedu.olucas.mlivre.product.response;

import br.com.zupedu.olucas.mlivre.product.model.Characteristic;

import javax.validation.constraints.NotBlank;

public class CharacteristicResponse {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    public CharacteristicResponse(Characteristic characteristic) {
        this.id = characteristic.getId();
        this.name = characteristic.getName();
        this.description = characteristic.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
