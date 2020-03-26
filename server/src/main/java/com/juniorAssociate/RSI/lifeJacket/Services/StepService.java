package com.juniorAssociate.RSI.lifeJacket.Services;

import com.juniorAssociate.RSI.lifeJacket.Entities.Categories;
import com.juniorAssociate.RSI.lifeJacket.Entities.Steps;
import com.juniorAssociate.RSI.lifeJacket.Repositories.CategoriesRepository;
import com.juniorAssociate.RSI.lifeJacket.Repositories.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepService {
    @Autowired
    private StepRepository stepRepository;
    private CategoriesRepository categoriesRepository;

    public void saveAllSteps(){
        List<Steps> steps = stepRepository.findAll();
        stepRepository.saveAll(steps);
    }
    public List<Steps> findAllSteps(){
        return stepRepository.findAll();
    }
    public Steps findByID(Long stepId){
        return stepRepository.findByStepId(stepId);
    }
    public void deleteStep(Long stepId){
        stepRepository.deleteByStepId(stepId);
    }
    public void saveStep(Long stepId){
        Steps step = stepRepository.findByStepId(stepId);
        stepRepository.save(step);
    }


    public void newStep(String title, String description, String category) {
        Steps newStep = new Steps();
        long categoryId = categoriesRepository.findByCategory(category).getCategoryId();
        newStep.setDescription(description);
        newStep.setTitle(title);
        newStep.setCategoriesId(categoriesRepository.findByCategoryId(categoryId));
        stepRepository.save(newStep);
    }
}
