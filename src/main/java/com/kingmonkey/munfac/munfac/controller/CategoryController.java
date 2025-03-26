package com.kingmonkey.munfac.munfac.controller;

import com.kingmonkey.munfac.munfac.dto.CategoryDTO;
import com.kingmonkey.munfac.munfac.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryController(CategoryService categoryService, ModelMapper modelMapper){
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @ResponseBody
    @PostMapping("/getCategory")
    public CategoryDTO getCategory(@RequestParam int cateNo){
        CategoryDTO categoryDTO = categoryService.findCategoryById(cateNo);


        return categoryDTO;
    }
}
