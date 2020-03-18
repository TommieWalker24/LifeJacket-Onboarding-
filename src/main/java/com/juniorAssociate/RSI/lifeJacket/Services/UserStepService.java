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
        public UserStep findByID(long id){
        return userStepRepository.findByUserStepId(id);
    }
    public void deleteUserStep(Long id){
        userStepRepository.deleteById(id);
    }
    public void saveUserStep(Long id){
        UserStep userstep = userStepRepository.findByUserStepId(id);
        userStepRepository.save(userstep);
    }

    public void completeUserStep(long userStepId) {
        UserStep userstep = userStepRepository.findByUserStepId(userStepId);
        userstep.setComplete(true);
        userstep.setPending(false);
        userStepRepository.save(userstep);
    }
}
