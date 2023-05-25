package com.uni.baker.service;

import com.uni.baker.entity.Category;
import com.uni.baker.entity.Product;
import com.uni.baker.repository.ICategoryRepository;
import com.uni.baker.repository.IProductRepository;
import com.uni.baker.utils.SlugUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ICategoryRepository categoryRepository;
    LocalDateTime now = LocalDateTime.now();
    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }
    public Product getProductById(Long id)
    {
        return productRepository.findById(id).orElse(null);
    }
    public Product save(Product product)
    {
        return productRepository.save(product);
    }

    public void addProduct(Product product)
    {
        String slug = SlugUtils.createSlug(product.getName());
        product.setSlug(slug);
        product.setCreatedAt(now);
        product.setUpdatedAt(now);
        save(product);
    }
    public void deleteCProduct(Long id)
    {
        productRepository.deleteById(id);
    }
    public void updateProduct(Product product, Long categoryId)
    {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if(existingProduct != null)
        {
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setCategory(category);
            existingProduct.setUpdatedAt(now);
            save(existingProduct);

        }
    }

}
