package br.com.zupedu.olucas.mlivre.product.request;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class ProductImageRequest {

    @Size(min = 1)
    @NotNull
    List<MultipartFile> images;

    public ProductImageRequest(List<MultipartFile> images) {
        this.images = images;
    }

    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }
}
