package com.uni.baker.repository;

import com.uni.baker.entity.Category;
import com.uni.baker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
