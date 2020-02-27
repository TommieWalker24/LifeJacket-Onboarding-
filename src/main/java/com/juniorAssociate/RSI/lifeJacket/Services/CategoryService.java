package com.juniorAssociate.RSI.lifeJacket.Services;

import com.juniorAssociate.RSI.lifeJacket.Entities.Categories;
import com.juniorAssociate.RSI.lifeJacket.Repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoriesRepository categoryRepository;

    public List<Categories> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void saveAllCategories(){
        List<Categories> categories = categoryRepository.findAll();
        categoryRepository.saveAll(categories);
    }
    public List<Categories> findAllCategories(){
        return categoryRepository.findAll();
    }
    //public Optional<Role> findByID(){
    //   return roleRepository.findById();
    //  }
    public void deleteCategory(Categories category){
        categoryRepository.delete(category);
    }
    public void saveCategory(Categories category){
        categoryRepository.save(category);
    }
}
