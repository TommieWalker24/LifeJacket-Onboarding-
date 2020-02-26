package com.juniorAssociate.RSI.lifeJacket.Services;

import com.juniorAssociate.RSI.lifeJacket.Entities.Role;
import com.juniorAssociate.RSI.lifeJacket.Repositories.RoleRepository;
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

    public void saveAllRoles(){
        List<Role> steps = roleRepository.findAll();
        roleRepository.saveAll(steps);
    }
    public List<Role> findAllRole(){
        return roleRepository.findAll();
    }
    public Optional<Role> findByID(){
        return roleRepository.findById();
    }
    public void deleteRole(Role role){
        roleRepository.delete(role);
    }
    public void saveRole(Role role){
        roleRepository.save(role);
    }
}
