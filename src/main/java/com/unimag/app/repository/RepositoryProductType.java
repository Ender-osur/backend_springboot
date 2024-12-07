package com.unimag.app.repository;

import com.unimag.app.entity.ProductType;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RepositoryProductType extends JpaRepository<ProductType, Long> {

    @Query("SELECT COUNT(pt) FROM ProductType pt WHERE pt.productTypeName = :name")
    Long findByName(@Param("name") String name);
}
