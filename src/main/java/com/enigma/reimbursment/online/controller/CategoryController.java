package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Category;
import com.enigma.reimbursment.online.exceptions.EntityNotFoundException;
import com.enigma.reimbursment.online.models.request.category.CategoryRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.category.CategoryResponse;
import com.enigma.reimbursment.online.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RequestMapping("/categories")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;


    @PutMapping("/{id}")
    public ResponseMessage<CategoryResponse> edit(@PathVariable String id, @RequestBody CategoryRequest model) {
        Category entity = categoryService.findById(id);
        if(entity == null) {
            throw new EntityNotFoundException();
        }
        modelMapper.map(model,entity);
        entity = categoryService.save(entity);

        CategoryResponse data = modelMapper.map(entity,CategoryResponse.class);
        return ResponseMessage.success(data);
    }


    @GetMapping("/{id}")
    public ResponseMessage<CategoryResponse> findById(@PathVariable String id) {
        Category entity = categoryService.findById(id);
        if(entity == null) {
            throw new EntityNotFoundException();
        }
        CategoryResponse data = modelMapper.map(entity,CategoryResponse.class);
        return ResponseMessage.success(data);
    }


    @GetMapping
    public ResponseMessage<List<CategoryResponse>> findAll() {
        List<Category> entity = categoryService.findAll();
        List<CategoryResponse> data = entity.stream().map(e -> modelMapper.map(e,CategoryResponse.class))
                .collect(Collectors.toList());
        return ResponseMessage.success(data);
    }

}
