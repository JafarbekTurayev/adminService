package com.example.adminservice.controller;

import com.example.adminservice.dto.CategoryDto;
import com.example.adminservice.entity.Category;
import com.example.adminservice.mapper.CategoryMapper;
import com.example.adminservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryMapper categoryMapper;

    private final CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CategoryDto categoryDto) {
        Category save = categoryRepository.save(categoryMapper.toEntity(categoryDto));
        return ResponseEntity.status(Objects.isNull(save.getId()) ? 409 : 200).body(save);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
     return ResponseEntity.ok(categoryMapper.toDtoList(categoryRepository.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return ResponseEntity.ok(categoryRepository.findById(id).orElse(null));
    }


}
