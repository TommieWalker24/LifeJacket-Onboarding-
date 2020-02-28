package com.juniorAssociate.RSI.lifeJacket.Controllers;

import com.juniorAssociate.RSI.lifeJacket.Entities.Categories;
import com.juniorAssociate.RSI.lifeJacket.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String Helloworld (){
        return "Tommie is amazing in his category!!!";
    }

    @RequestMapping(value = "/findAll")
    public List<Categories> getAllCategories() {
        return categoryService.findAllCategories();
    }

    @PatchMapping(value = "/saveAll")
    public void saveAllCategories() {
        categoryService.saveAllCategories();
    }

    @RequestMapping("/findByID")
    public Categories categoryFindById(Long id){
        return categoryService.findByID(id);
    }
    //todo figure out what info i will have
    @DeleteMapping(value = "/delete")
    public void delete(Long id){
        categoryService.deleteCategory(id);
    }
    //todo figure out what info i will have
    @PatchMapping("/save")
    public void saveCategory(Long id){
        categoryService.saveCategory(id);
    }

}
