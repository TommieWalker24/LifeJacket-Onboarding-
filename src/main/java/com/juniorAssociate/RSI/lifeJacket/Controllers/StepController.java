package com.juniorAssociate.RSI.lifeJacket.Controllers;

import com.juniorAssociate.RSI.lifeJacket.Entities.Step;
import com.juniorAssociate.RSI.lifeJacket.Services.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//todo: Look up update endpoints

@RestController
@RequestMapping("/step")
public class StepController {
    @Autowired
    private StepService stepService;

    @RequestMapping("/")
    public String Helloworld (){
        return "Tommie is amazing in his steps!!!";
    }

    @PatchMapping(value = "/saveAll")
    public void saveAllSteps() {
        stepService.saveAllSteps();
    }

    @RequestMapping(value = "/findAll")
    public List<Step> findAllSteps(){
           return stepService.findAllSteps();
        }

    @RequestMapping("/findByID")
    public Step findById(Long id){
        return  stepService.findByID(id);
    }
    //todo figure out what info i will have
    @DeleteMapping ("/delete")
    public void delete(Long stepId){
          stepService.deleteStep(stepId);
    }
    //todo figure out what info i will have
    @PatchMapping("/save")
    public void saveStep(Long stepId){
          stepService.saveStep(stepId);
    }


    //todo:this endpoint after basic endpoints
    @PatchMapping(value = "/admin/change/{title}")
    public void changeStep(@PathVariable String title){
        //check step repo so we can find by the step name
    }

    //todo:this endpoint after basic endpoints
    @PutMapping(value = "/admin/insert/{title}")
    public void insertStep(@PathVariable String title){

    }
}
