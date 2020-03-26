package com.juniorAssociate.RSI.lifeJacket.Services;


import com.juniorAssociate.RSI.lifeJacket.Entities.UserSteps;
import com.juniorAssociate.RSI.lifeJacket.Repositories.UserStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStepService {
    @Autowired
    private UserStepRepository userStepRepository;

    public List<UserSteps> getAllSteps() {
        return userStepRepository.findAll();
    }

    public void saveAllSteps(){
        List<UserSteps> usersteps = userStepRepository.findAll();
        userStepRepository.saveAll(usersteps);
    }
    public List<UserSteps> findAllSteps(){
        List<UserSteps> allUserSteps = userStepRepository.findAll();
        return allUserSteps;
    }
        public UserSteps findByID(long id){
        return userStepRepository.findByUserStepId(id);
    }
    public void deleteUserStep(Long id){
        userStepRepository.deleteById(id);
    }
    public void saveUserStep(Long id){
        UserSteps userStep = userStepRepository.findByUserStepId(id);
        userStepRepository.save(userStep);
    }

    public void completeUserStep(long id){
        UserSteps userStep = userStepRepository.findByUserStepId(id);
        userStep.setComplete(true);
        userStep.setPending(false);
        userStepRepository.save(userStep);
    }
}
