package com.juniorAssociate.RSI.lifeJacket.Controllers;

import com.juniorAssociate.RSI.lifeJacket.Entities.Role;
import com.juniorAssociate.RSI.lifeJacket.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/")
    public String Helloworld (){
        return "Roll roll, keep on rolling then roll some more";
    }

    @RequestMapping(value = "/getAll")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PatchMapping(value = "/saveAll")
    public void saveAllRoles() {
        roleService.saveAllRoles();
    }

    @RequestMapping(value = "/findAll")
    public void findAllRoles(){
        roleService.findAllRole();
    }
    //todo figure out what info i will have
    @RequestMapping("/findByID")
    public Role findById(String id){
      return roleService.findByID(id);
    }

    @DeleteMapping(value = "/delete")
    public void delete(String id){
         roleService.deleteRole(id);
    }

    @PatchMapping("/save")
    public void saveStep(String id){
          roleService.saveRole(id);
    }

}
