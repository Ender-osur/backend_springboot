package com.unimag.app.controller;

import com.unimag.app.dto.DTOProductType;
import com.unimag.app.entity.ProductType;
import com.unimag.app.service.ServiceProductType;

import java.util.List;

import com.unimag.app.utility.wrapper.WrapperResponse;
import com.unimag.app.utility.converter.ConverterProductType;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProductType {

    @Autowired
    private ServiceProductType productTypeService;
    private final ConverterProductType converter = new ConverterProductType();

    @GetMapping(value = "/getAllProductType")
    public ResponseEntity<WrapperResponse<List<DTOProductType>>> getAllPT() {
        List<ProductType> arrayPT = productTypeService.getAllPT();
        List<DTOProductType> arrayPTDTO = converter.fromEntity(arrayPT);
        return new WrapperResponse<>(true, "success", arrayPTDTO)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping(value = "/getpt/{productId}")
    public ResponseEntity<WrapperResponse<DTOProductType>> getOnePT(@PathVariable("productId") Long pId) {
        ProductType myObject = productTypeService.getOnePT(pId);
        DTOProductType myObjectDTO = converter.fromEntity(myObject);
        return new WrapperResponse<>(true, "success", myObjectDTO)
                .createResponse(HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<WrapperResponse<DTOProductType>> createPT(@RequestBody DTOProductType myObject) {
        ProductType newObject = productTypeService.create(converter.fromDTO(myObject));
        DTOProductType myObjectDTO = converter.fromEntity(newObject);
        return new WrapperResponse<>(true, "success", myObjectDTO)
                .createResponse(HttpStatus.CREATED);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<WrapperResponse<DTOProductType>> updatePT(@RequestBody DTOProductType myObject) {
        ProductType updateObject = productTypeService.update(converter.fromDTO(myObject));
        DTOProductType myObjectDTO = converter.fromEntity(updateObject);
        return new WrapperResponse<>(true, "success", myObjectDTO)
                .createResponse(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deletePT(@PathVariable("id") Long PTId) {
        productTypeService.delete(PTId);
        return new WrapperResponse<>(true, "success", null)
                .createResponse(HttpStatus.OK);
    }
}
