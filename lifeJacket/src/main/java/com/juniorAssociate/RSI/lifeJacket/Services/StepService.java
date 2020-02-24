package com.juniorAssociate.RSI.lifeJacket.Services;

import com.juniorAssociate.RSI.lifeJacket.Entities.Step;
import com.juniorAssociate.RSI.lifeJacket.Repositories.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StepService {
    @Autowired
    private StepRepository stepRepository;

    public List<Step> getAllSteps() {
        return stepRepository.findAll();
    }

//    public void deleteStep(String stepTitle){
//        var step = stepRepository.findByTitle(stepTitle);
//        stepRepository.delete((Step) step);
//    }
    public void saveAllSteps(){
        List<Step> steps = stepRepository.findAll();
        stepRepository.saveAll(steps);
    }
//    public void saveStep(String stepTitle){
//        var step = stepRepository.findByTitle(stepTitle);
//        stepRepository.save(step);
//    }

}
