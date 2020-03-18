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

    public void saveAllSteps(){
        List<Step> steps = stepRepository.findAll();
        stepRepository.saveAll(steps);
    }
    public List<Step> findAllSteps(){
        return stepRepository.findAll();
    }
    public Step findByID(Long stepId){
        return stepRepository.findByStepId(stepId);
    }
    public void deleteStep(Long stepId){
        stepRepository.deleteById(stepId);
    }
    public void saveStep(Long stepId){
        Step step = stepRepository.findByStepId(stepId);
        stepRepository.save(step);
    }


}
