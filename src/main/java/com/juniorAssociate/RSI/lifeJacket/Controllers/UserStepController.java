package com.juniorAssociate.RSI.lifeJacket.Controllers;

import com.juniorAssociate.RSI.lifeJacket.Entities.UserStep;
import com.juniorAssociate.RSI.lifeJacket.Services.UserStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userstep")
public class UserStepController {
    @Autowired
    private UserStepService userStepService;

    @RequestMapping("/")
    public String Helloworld (){
        return "User step user step user step";
    }

    @PatchMapping(value = "/saveAll")
    public void saveAllSteps() {
        userStepService.saveAllSteps();
    }

    @RequestMapping(value = "/findAll")
    public List<UserStep> findAllSteps(){
        return userStepService.findAllSteps();
    }

    @RequestMapping("/findByID")
    public UserStep findById(Long id){
        return  userStepService.findByID(id);
    }
    //todo figure out what info i will have
    @DeleteMapping ("/delete")
    public void delete(Long stepId){
        userStepService.deleteUserStep(stepId);
    }
    //todo figure out what info i will have
    @PatchMapping("/save")
    public void saveUserStep(Long stepId){
        userStepService.saveUserStep(stepId);
    }
}
