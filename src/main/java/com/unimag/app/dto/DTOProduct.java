package com.unimag.app.dto;

import com.unimag.app.entity.ProductType;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTOProduct {

    private ProductType productTypeCode;
    private String productName;
    private Long productCode;
    private BigDecimal productPrice;

}
