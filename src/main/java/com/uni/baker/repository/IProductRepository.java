package com.uni.baker.repository;

import com.uni.baker.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
//        boolean existsBySlug(String slug);
}
