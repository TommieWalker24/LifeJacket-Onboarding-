package com.juniorAssociate.RSI.lifeJacket.Controllers;
import com.juniorAssociate.RSI.lifeJacket.Entities.UserCategories;
import com.juniorAssociate.RSI.lifeJacket.Services.UserCategoriesService;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/userCategories")
public class UserCategoriesController {
    @Autowired
    private UserCategoriesService userCategoriesService;

    @PatchMapping(value = "/saveAll")
    public void saveAllCategories() {
        userCategoriesService.saveAllCategories();
    }

    @RequestMapping(value = "/findAll")
    public List<UserCategories> findAllCategories(){
        return userCategoriesService.findAllCategories();
    }

    @RequestMapping(value= "/firstPending/{email}")
    public Pair<Long, String> findFirstPendingCategories(@PathVariable String email){
        //returns in the order of  size of tuple, value0: UserCategories ID,  value1: Category name
        return userCategoriesService.findFirstPendingCategory(email);
    }
    @RequestMapping(value = "/getUserCategory/{email}/{oCategoryId}")
    public UserCategories getUserCategory(@PathVariable long oCategoryId, @PathVariable String email){
    return userCategoriesService.getUserCategory(oCategoryId, email);
    }

    @PatchMapping(value = "/completeCategory/{categoryId}")
    public ResponseEntity responseEntity(@PathVariable long categoryId){
        userCategoriesService.completeCategory(categoryId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping("/findByID/{id}")
    public UserCategories findById(@PathVariable long id){
        return  userCategoriesService.findByID(id);
    }


    @PatchMapping("/save")
    public void saveUserStep(@RequestBody Long categoryId){
        userCategoriesService.saveCategory(categoryId);
    }
}
