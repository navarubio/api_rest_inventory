package com.sismacontab.inventory.models.dto;

import java.util.List;

public class ProductImagesBulkUpdateDTO {
    private List<ProductImageUpdateDTO> images;

    public ProductImagesBulkUpdateDTO() {}

    public ProductImagesBulkUpdateDTO(List<ProductImageUpdateDTO> images) {
        this.images = images;
    }

    public List<ProductImageUpdateDTO> getImages() {
        return images;
    }

    public void setImages(List<ProductImageUpdateDTO> images) {
        this.images = images;
    }
}
