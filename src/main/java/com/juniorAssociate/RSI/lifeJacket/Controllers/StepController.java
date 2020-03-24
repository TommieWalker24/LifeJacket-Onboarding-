package com.juniorAssociate.RSI.lifeJacket.Controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.juniorAssociate.RSI.lifeJacket.Entities.Steps;
import com.juniorAssociate.RSI.lifeJacket.Services.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/step")
public class StepController {
    @Autowired
    private StepService stepService;

    @PatchMapping(value = "/saveAll")
    public void saveAllSteps() {
        stepService.saveAllSteps();
    }

    @RequestMapping(value = "/findAll")
    public List<Steps> findAllSteps(){
           return stepService.findAllSteps();
        }

    @RequestMapping("/findByID/{id}")
    public Steps findById(@PathVariable Long id){
        return  stepService.findByID(id);
    }


    @PatchMapping("/save/{stepId}")
    public void saveStep(@PathVariable Long stepId){
          stepService.saveStep(stepId);
    }

}
