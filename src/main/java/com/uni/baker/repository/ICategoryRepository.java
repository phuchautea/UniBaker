package com.uni.baker.repository;

import com.uni.baker.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    boolean existsBySlug(String slug);
}
