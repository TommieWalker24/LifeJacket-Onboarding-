package com.juniorAssociate.RSI.lifeJacket.Controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.juniorAssociate.RSI.lifeJacket.Entities.Steps;
import com.juniorAssociate.RSI.lifeJacket.Services.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
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

    @DeleteMapping ("/delete/{stepId}")
    public void delete(@PathVariable Long stepId){
        stepService.deleteStep(stepId);
    }

    @PostMapping("/addStep")
    public void createStep(@RequestBody Steps step){
        System.out.println("");
        stepService.newStep(step.getTitle(), step.getDescription(),step.getCategoryName());
    }
}
