package com.juniorAssociate.RSI.lifeJacket.Controllers;

import com.juniorAssociate.RSI.lifeJacket.Entities.Role;
import com.juniorAssociate.RSI.lifeJacket.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PatchMapping(value = "/saveAll")
    public void saveAllRoles() {
        roleService.saveAllRoles();
    }

    @RequestMapping(value = "/findAll")
    public List<Role> findAllRoles(){
        return roleService.findAllRole();
    }

    @RequestMapping("/findByID/{id}")
    public Role findById(@PathVariable String id){
      return roleService.findByID(id);
    }

    @PatchMapping("/save/{id}")
    public void saveStep(@PathVariable String id){
          roleService.saveRole(id);
    }
}
