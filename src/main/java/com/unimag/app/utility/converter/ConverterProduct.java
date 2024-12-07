package com.unimag.app.utility.converter;

import com.unimag.app.dto.DTOProduct;
import com.unimag.app.entity.Product;

public class ConverterProduct extends AbstractConverter<Product, DTOProduct> {

    @Override
    public DTOProduct fromEntity(Product entity) {
        return DTOProduct
                .builder()
                .productTypeCode(entity.getProductTypeCode())
                .productName(entity.getProductName())
                .productCode(entity.getProductCode())
                .productPrice(entity.getProductPrice())
                .build();
    }

    @Override
    public Product fromDTO(DTOProduct DTO) {
        return Product
                .builder()
                .productTypeCode(DTO.getProductTypeCode())
                .productName(DTO.getProductName())
                .productCode(DTO.getProductCode())
                .productPrice(DTO.getProductPrice())
                .build();
    }

}
