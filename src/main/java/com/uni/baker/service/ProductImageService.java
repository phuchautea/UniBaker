package com.uni.baker.service;

import com.uni.baker.entity.ProductImage;
import com.uni.baker.repository.IProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImageService {
    @Autowired
    IProductImageRepository productImageRepository;
    public List<ProductImage> getAll() {
        return productImageRepository.findAll();
    }

    public ProductImage getById(Long id) {
        Optional<ProductImage> optional = productImageRepository.findById(id);
        return optional.orElse(null);
    }

    public void add(ProductImage productImage) {
        productImageRepository.save(productImage);
    }

    public void update(ProductImage productImage) {
        productImageRepository.save(productImage);
    }

    public void delete(Long id) {
        productImageRepository.deleteById(id);
    }
}
