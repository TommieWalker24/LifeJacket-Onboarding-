package com.juniorAssociate.RSI.lifeJacket.Services;

import com.juniorAssociate.RSI.lifeJacket.Entities.Role;
import com.juniorAssociate.RSI.lifeJacket.Entities.Step;
import com.juniorAssociate.RSI.lifeJacket.Repositories.RoleRepository;
import com.juniorAssociate.RSI.lifeJacket.Repositories.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public void saveAllSteps(){
        List<Role> steps = roleRepository.findAll();
        roleRepository.saveAll(steps);
    }
    public List<Role> findAllSteps(){
        return roleRepository.findAll();
    }
    public Optional<Step> findByID(){
        return roleRepository.findById();
    }
    public void deleteStep(Step step){
        stepRepository.delete(step);
    }
    public void saveStep(Step step){
        stepRepository.save(step);
    }
}
