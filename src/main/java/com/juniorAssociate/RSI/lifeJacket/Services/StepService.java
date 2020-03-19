package com.juniorAssociate.RSI.lifeJacket.Services;

import com.juniorAssociate.RSI.lifeJacket.Entities.Steps;
import com.juniorAssociate.RSI.lifeJacket.Repositories.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepService {
    @Autowired
    private StepRepository stepRepository;

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
        stepRepository.deleteById(stepId);
    }
    public void saveStep(Long stepId){
        Steps step = stepRepository.findByStepId(stepId);
        stepRepository.save(step);
    }


}
