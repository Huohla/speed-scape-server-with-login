package com.tfc.controllers;

import com.tfc.entities.Product;
import com.tfc.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/catalogs")
public class RestCategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{id}/products")
    public ResponseEntity<List<Product>> getCatalogsProduct(@PathVariable("id") UUID catalogId) {
        return ResponseEntity.ok(categoryService.getCategorysProductsByCategoryId(catalogId));
    }
}
