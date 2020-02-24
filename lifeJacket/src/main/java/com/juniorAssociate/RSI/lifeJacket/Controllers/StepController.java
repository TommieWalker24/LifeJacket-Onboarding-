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
        return "Tommie is amazing!!!";
    }

    @RequestMapping(value = "/getAll")
    public List<Step> getAllSteps() {
        return stepService.getAllSteps();
    }

    @PatchMapping(value = "/saveAll")
    public void saveAllSteps() {
        stepService.saveAllSteps();
    }

//    @PatchMapping(value = "/save/{title}")
//    public void saveStep(@PathVariable String title){
//        stepService.saveStep(title);
//    }

//    @DeleteMapping(value = "delete/{title}")
//    public void deleteStep(@PathVariable String title){
//        stepService.deleteStep(title);
//    }

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
