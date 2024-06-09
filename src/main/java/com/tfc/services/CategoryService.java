package com.tfc.services;

import com.tfc.entities.Category;
import com.tfc.entities.Product;
import com.tfc.entities.SubCategory;
import com.tfc.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> getCategoryById(UUID catalogId) {
        return categoryRepository.findById(catalogId);
    }

    public List<Product> getCategorysProductsByCategoryId(UUID categoryId) {
        var category = getCategoryById(categoryId);
        if (category.isEmpty()) {
            return Collections.emptyList();
        }

        var products = new ArrayList<Product>();
        for (SubCategory subCategory : category.get().getSubCategories()) {

        }

        return null;
    }

    public List<Product> extractProductsFromCategory(Category category) {
        if (Objects.isNull(category)) {
            return new ArrayList<>();
        }
        return null;
    }
}
