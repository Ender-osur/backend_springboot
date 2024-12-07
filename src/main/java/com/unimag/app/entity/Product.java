package com.unimag.app.entity;

import lombok.Setter;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_code", nullable = false)
    private Long productCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_type_code", nullable = false, updatable = true, referencedColumnName = "product_type_code")
    private ProductType productTypeCode;

    @Column(name = "product_name", length = 150, nullable = false)
    private String productName;

    @Column(name = "product_price", nullable = false)
    @DecimalMin(value = "0.1", inclusive = false)
    @Digits(integer = 10, fraction = 2)
    private BigDecimal productPrice;
}
