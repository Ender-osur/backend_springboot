package com.unimag.app.service;

import com.unimag.app.entity.ProductType;
import com.unimag.app.repository.RepositoryProductType;
import com.unimag.app.utility.exception.ExceptionGeneralService;
import com.unimag.app.utility.validator.ProductTypeValidator;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ServiceProductType {

    @Autowired
    private RepositoryProductType productTypeRepository;

    public List<ProductType> getAllPT() {
        try {
            List<ProductType> arrayPT;
            arrayPT = productTypeRepository
                    .findAll(Sort.by(Sort.Direction.ASC, "productTypeCode"));
            return arrayPT;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ExceptionGeneralService(e.getMessage(), e);
        }
    }

    public ProductType getOnePT(Long productId) {
        try {
            ProductType myObject;
            myObject = productTypeRepository
                    .findById(productId)
                    .orElseThrow(
                            () -> new ExceptionGeneralService("Código no existe")
                    );
            return myObject;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ExceptionGeneralService(e.getMessage(), e);
        }
    }
    
    @Transactional
    public ProductType create(ProductType myObject) {
        try {
            ProductTypeValidator.check(myObject);
            Long amount = productTypeRepository
                    .findByName(myObject.getProductTypeName());
            if (amount == 0) {
                return productTypeRepository
                        .save(myObject);
            } else {
                throw new ExceptionGeneralService("Ya existe ese nombre de producto");
            }
        } catch (ExceptionGeneralService e) {
            log.error(e.getMessage(), e);
            throw new ExceptionGeneralService(e.getMessage(), e);
        }
    }
    
    @Transactional
    public ProductType update(ProductType myObject) {
        try {
            ProductTypeValidator.check(myObject);
            ProductType updateObject = productTypeRepository
                    .findById(myObject.getProductTypeCode())
                    .orElseThrow(() -> new ExceptionGeneralService("Código inválido"));
            updateObject.setProductTypeName(myObject.getProductTypeName());
            productTypeRepository.save(updateObject);
            return updateObject;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ExceptionGeneralService(e.getMessage(), e);
        }
    }
    
    @Transactional
    public void delete(Long productId) {
        try {
            ProductType deleteObject = productTypeRepository
                    .findById(productId)
                    .orElseThrow(() -> new ExceptionGeneralService("Tipo no encontrado"));
            productTypeRepository.delete(deleteObject);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ExceptionGeneralService(e.getMessage(), e);
        }
    }
}
