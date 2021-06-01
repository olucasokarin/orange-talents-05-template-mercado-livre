package br.com.zupedu.olucas.mlivre.product.response;

import br.com.zupedu.olucas.mlivre.product.model.ImageProduct;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

public class ImageProductResponse {
    private Long id;
    @NotBlank
    @URL
    private String url;

    public ImageProductResponse(ImageProduct imageProduct) {
        this.id = imageProduct.getId();
        this.url = imageProduct.getUrl();
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
