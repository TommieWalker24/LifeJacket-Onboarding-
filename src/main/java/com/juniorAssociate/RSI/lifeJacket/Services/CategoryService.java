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

    public List<Categories> findAllCategories() {
        return categoryRepository.findAll();
    }

    public void saveAllCategories(){
        List<Categories> categories = categoryRepository.findAll();
        categoryRepository.saveAll(categories);
    }

    public Categories findByID(Long id){
       return categoryRepository.getOne(id);
      }
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
    public void saveCategory(Long id){
        Categories category = categoryRepository.getOne(id);
        categoryRepository.save(category);
    }
}
