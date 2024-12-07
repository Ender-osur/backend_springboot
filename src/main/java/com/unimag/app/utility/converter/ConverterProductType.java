package com.unimag.app.utility.converter;

import com.unimag.app.dto.DTOProductType;
import com.unimag.app.entity.ProductType;

public class ConverterProductType extends AbstractConverter<ProductType, DTOProductType> {

    @Override
    public DTOProductType fromEntity(ProductType entity) {
        return DTOProductType
                .builder()
                .productTypeCode(entity.getProductTypeCode())
                .productTypeName(entity.getProductTypeName())
                .build();
    }

    @Override
    public ProductType fromDTO(DTOProductType DTO) {
        return ProductType
                .builder()
                .productTypeCode(DTO.getProductTypeCode())
                .productTypeName(DTO.getProductTypeName())
                .build();
    }

}
