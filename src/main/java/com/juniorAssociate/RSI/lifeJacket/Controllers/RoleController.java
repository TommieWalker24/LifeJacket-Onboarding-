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
        return "Tommie is amazing in his role!!!";
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
//    @RequestMapping("/findByID")
//    public Optional<Role> findById(Long id){
//        Optional<Role> foundRole = roleService.findByID();
//        return foundRole;
//    }
    //todo figure out what info i will have
    @DeleteMapping(value = "/delete")
    public void delete(Role role){
         roleService.deleteRole(role);
    }
    //todo figure out what info i will have
    @PatchMapping("/save")
    public void saveStep(Role role){
          roleService.saveRole(role);
    }


    //todo:this endpoint after basic endpoints
    @PatchMapping(value = "/admin/change/{title}")
    public void changeRole(@PathVariable String title){
        //check step repo so we can find by the step name
    }

    //todo:this endpoint after basic endpoints
  //  @PutMapping(value = "/admin/insert/{title}")
   // public void insertRole(Role role){

   // }
}
