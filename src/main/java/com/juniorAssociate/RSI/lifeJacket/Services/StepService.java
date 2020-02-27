package com.juniorAssociate.RSI.lifeJacket.Services;

import com.juniorAssociate.RSI.lifeJacket.Entities.Step;
import com.juniorAssociate.RSI.lifeJacket.Repositories.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StepService {
    @Autowired
    private StepRepository stepRepository;

    public List<Step> getAllSteps() {
        return stepRepository.findAll();
    }

    public void saveAllSteps(){
        List<Step> steps = stepRepository.findAll();
        stepRepository.saveAll(steps);
    }
    public List<Step> findAllSteps(){
        List<Step> allSteps = stepRepository.findAll();
        return allSteps;
    }
//    public Optional<Step> findByID(){
//        return stepRepository.findById();
//    }
    public void deleteStep(Step step){
        stepRepository.delete(step);
    }
    public void saveStep(Step step){
        stepRepository.save(step);
    }


}
