package com.juniorAssociate.RSI.lifeJacket.Controllers;

import com.juniorAssociate.RSI.lifeJacket.Entities.UserSteps;
import com.juniorAssociate.RSI.lifeJacket.Services.UserStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/userstep")
public class UserStepController {
    @Autowired
    private UserStepService userStepService;

    @PatchMapping(value = "/saveAll")
    public void saveAllSteps() {
        userStepService.saveAllSteps();
    }

    @RequestMapping(value = "/findAll")
    public List<UserSteps> findAllSteps(){
        return userStepService.findAllSteps();
    }

    @RequestMapping("/findByID/{id}")
    public UserSteps findById(@PathVariable Long id){
        return  userStepService.findByID(id);
    }

    @PatchMapping("/save")
    public void saveUserStep(@RequestBody Long stepId){
        userStepService.saveUserStep(stepId);
    }

    @PatchMapping("/completeStep/{id}")
    public void completeUserStep(@PathVariable long id){
        userStepService.completeUserStep(id);
    }
}
