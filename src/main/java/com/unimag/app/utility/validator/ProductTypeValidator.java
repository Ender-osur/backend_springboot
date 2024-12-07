package com.unimag.app.utility.validator;

import com.unimag.app.entity.ProductType;

import com.unimag.app.utility.exception.ExceptionGeneralService;

public class ProductTypeValidator {

    public static void check(ProductType myObject) {
        if (myObject.getProductTypeName() == null
                || myObject.getProductTypeName().trim().isEmpty()) {
            throw new ExceptionGeneralService("El tipo de producto es obligatorio");
        }

        if (myObject.getProductTypeName().length() > 150) {
            throw new ExceptionGeneralService("No más de cien caracteres");
        }
    }
}
