package com.juniorAssociate.RSI.lifeJacket.Services;

import com.juniorAssociate.RSI.lifeJacket.Entities.Categories;
import com.juniorAssociate.RSI.lifeJacket.Entities.Steps;
import com.juniorAssociate.RSI.lifeJacket.Entities.UserCategories;
import com.juniorAssociate.RSI.lifeJacket.Entities.UserSteps;
import com.juniorAssociate.RSI.lifeJacket.Repositories.CategoriesRepository;
import com.juniorAssociate.RSI.lifeJacket.Repositories.UserCategoriesRepository;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserCategoriesService {
    @Autowired
    private UserCategoriesRepository userCategoriesRepository;
    @Autowired
    private CategoriesRepository categoriesRepository;

    public List<UserCategories> findAllCategories() {
        return userCategoriesRepository.findAll();
    }

    public Pair<Long, String> findFirstPendingCategory(String email){
        List<UserCategories> pendingCategories =  userCategoriesRepository.findPendingCategories(email);
        Collections.sort(pendingCategories, UserCategories.sortBySequenceNumber);
        Pair<Long,String>  pendingDisplay = Pair.with(pendingCategories.get(0).getUserCategoriesId(), pendingCategories.get(0).getCategories().getCategory());
        return pendingDisplay;
    }

    public void saveAllCategories(){
        List<UserCategories> categories = userCategoriesRepository.findAll();
        userCategoriesRepository.saveAll(categories);
    }

    public UserCategories findByID(Long id){
        return userCategoriesRepository.findByUserCategoriesId(id);
    }
    public void deleteCategory(Long id){
        userCategoriesRepository.deleteById(id);
    }
    public void saveCategory(Long id){
        UserCategories category = userCategoriesRepository.findByUserCategoriesId(id);
        userCategoriesRepository.save(category);
    }

    public UserCategories getUserCategory(long oCategoryId, String email) {
        return userCategoriesRepository.findUserCategory(email, oCategoryId);
    }

    public void completeCategory(long categoryId) {
        UserCategories category = userCategoriesRepository.findByUserCategoriesId(categoryId);
        boolean complete = true;
        try{
            for (UserSteps step : category.getUserSteps()){
                if(step.getComplete() != true){
                    complete = false;
                }
            }
            if(complete == true) {
                category.setComplete(true);
                category.setPending(false);
                userCategoriesRepository.save(category);
            }
            //todo: create custom exception here
        } catch (Exception e){
            System.out.println(e);
        }


    }
}
