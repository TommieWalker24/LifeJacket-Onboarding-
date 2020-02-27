package com.juniorAssociate.RSI.lifeJacket.Controllers;

import com.juniorAssociate.RSI.lifeJacket.Entities.Categories;
import com.juniorAssociate.RSI.lifeJacket.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/getAll")
    public List<Categories> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PatchMapping(value = "/saveAll")
    public void saveAllCategories() {
        categoryService.saveAllCategories();
    }

    @RequestMapping(value = "/findAll")
    public void findAllCategories(){
        categoryService.findAllCategories();
    }
    //todo figure out what info i will have
//    @RequestMapping("/findByID")
//    public Optional<Role> findById(Long id){
//        Optional<Role> foundRole = roleService.findByID();
//        return foundRole;
//    }
    //todo figure out what info i will have
    @DeleteMapping(value = "/delete")
    public void delete(Categories category){
        categoryService.deleteCategory(category);
    }
    //todo figure out what info i will have
    @PatchMapping("/save")
    public void saveCategory(Categories category){
        categoryService.saveCategory(category);
    }

    //todo:this endpoint after basic endpoints
    @PatchMapping(value = "/admin/change/{title}")
    public void changeCategory(@PathVariable String title){
        //check step repo so we can find by the step name
    }

    //todo:this endpoint after basic endpoints
    //  @PutMapping(value = "/admin/insert/{title}")
    // public void insertRole(Role role){

    // }
}
