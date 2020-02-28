package com.juniorAssociate.RSI.lifeJacket.Services;


import com.juniorAssociate.RSI.lifeJacket.Entities.UserStep;
import com.juniorAssociate.RSI.lifeJacket.Repositories.UserStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStepService {
    @Autowired
    private UserStepRepository userStepRepository;

    public List<UserStep> getAllSteps() {
        return userStepRepository.findAll();
    }

    public void saveAllSteps(){
        List<UserStep> usersteps = userStepRepository.findAll();
        userStepRepository.saveAll(usersteps);
    }
    public List<UserStep> findAllSteps(){
        List<UserStep> allUserSteps = userStepRepository.findAll();
        return allUserSteps;
    }
    //    public Optional<Step> findByID(){
//        return stepRepository.findById();
//    }
    public void deleteUserStep(UserStep userstep){
        userStepRepository.delete(userstep);
    }
    public void saveUserStep(UserStep userstep){
        userStepRepository.save(userstep);
    }


}
