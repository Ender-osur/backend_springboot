package com.unimag.app.utility.validator;

import com.unimag.app.entity.Product;

import com.unimag.app.utility.exception.ExceptionGeneralService;
import java.math.BigDecimal;

public class ProductValidator {

    public static void check(Product myObject) {
        if (myObject.getProductTypeCode() == null) {
            throw new ExceptionGeneralService("El objeto tipo no puede ser nulo");
        }

        if (myObject.getProductName().length() > 150) {
            throw new ExceptionGeneralService("Menos 150 caracteres para el nombre");
        }

        if (myObject.getProductName() == null
                || myObject.getProductName().trim().isEmpty()) {
            throw new ExceptionGeneralService("El nombre es obligatorio");
        }

        BigDecimal value = new BigDecimal(0);
        if (myObject.getProductPrice().compareTo(value) != 1) {
            throw new ExceptionGeneralService("El precio debe ser mayor a cero");
        }
    }
}
