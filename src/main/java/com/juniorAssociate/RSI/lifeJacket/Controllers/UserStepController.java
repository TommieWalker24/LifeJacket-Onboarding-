package com.juniorAssociate.RSI.lifeJacket.Controllers;

import com.juniorAssociate.RSI.lifeJacket.Entities.Step;
import com.juniorAssociate.RSI.lifeJacket.Entities.UserStep;
import com.juniorAssociate.RSI.lifeJacket.Services.UserStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
        return "user step user step  user step";
    }

    @RequestMapping(value = "/getAll")
    public List<UserStep> getAllSteps() {
        return userStepService.getAllSteps();
    }

    @PatchMapping(value = "/saveAll")
    public void saveAllUserSteps() {
        userStepService.saveAllSteps();
    }

    @RequestMapping(value = "/findAll")
    public void findAllSteps(){
        userStepService.findAllSteps();
    }

    //todo figure out what info i will have
    @DeleteMapping("/delete")
    public void delete(UserStep userStep){
          userStepService.deleteUserStep(userStep);
    }
    //todo figure out what info i will have
    @PatchMapping("/save")
    public void saveStep(UserStep userStep){
          userStepService.saveUserStep(userStep);
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
