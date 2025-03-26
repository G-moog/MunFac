package com.kingmonkey.munfac.munfac.repository;

import com.kingmonkey.munfac.munfac.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Override
    Optional<Category> findById(Integer cateNo);
}
