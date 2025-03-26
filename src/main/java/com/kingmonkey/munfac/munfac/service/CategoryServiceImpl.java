package com.kingmonkey.munfac.munfac.service;

import com.kingmonkey.munfac.munfac.Entity.Category;
import com.kingmonkey.munfac.munfac.dto.CategoryDTO;
import com.kingmonkey.munfac.munfac.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper){
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CategoryDTO findCategoryById(int cateNo) {
        Optional<Category> category = categoryRepository.findById(cateNo);
        log.info("[CategoryServiceImpl] category : " + category.toString());

        return modelMapper.map(category, CategoryDTO.class);
    }
}
