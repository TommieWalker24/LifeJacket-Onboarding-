package com.juniorAssociate.RSI.lifeJacket.Controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.juniorAssociate.RSI.lifeJacket.Entities.Categories;
import com.juniorAssociate.RSI.lifeJacket.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired

    private CategoryService categoryService;

    @JsonFormat
    @RequestMapping(value = "/findAll")
    public List<Categories> findAllCategories() {
        return categoryService.findAllCategories();
    }

    @PatchMapping(value = "/saveAll")
    public void saveAllCategories() {
        categoryService.saveAllCategories();
    }

    @RequestMapping("/findByID/{id}")
    public Categories categoryFindById(@PathVariable Long id){
        return categoryService.findByID(id);
    }

    @PatchMapping("/save/{id}")
    public void saveCategory(@PathVariable Long id){
        categoryService.saveCategory(id);
    }

    @Transactional
    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

    @PostMapping(value = "/addCategory/{name}")
    public ResponseEntity newCategory(@PathVariable String name){
        categoryService.createNew(name);
        return new ResponseEntity(HttpStatus.OK);
    }
}
