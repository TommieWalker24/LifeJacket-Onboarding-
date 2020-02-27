package com.juniorAssociate.RSI.lifeJacket.Controllers;

import com.juniorAssociate.RSI.lifeJacket.Entities.Categories;
import com.juniorAssociate.RSI.lifeJacket.Entities.DevCenter;
import com.juniorAssociate.RSI.lifeJacket.Services.CategoryService;
import com.juniorAssociate.RSI.lifeJacket.Services.DevCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/DevCenter")
public class DevCenterController {
    @Autowired
    private DevCenterService devCenterService;

    @RequestMapping("/")
    public String Helloworld (){
        return "Tommie is amazing in his DevCenter!!!";
    }

    @RequestMapping(value = "/getAll")
    public List<DevCenter> getAllDevCenters() {
        return devCenterService.getAllDevCenters();
    }

    @PatchMapping(value = "/saveAll")
    public void saveAllDevCenters() {
        devCenterService.saveAllDevCenters();
    }

    @RequestMapping(value = "/findAll")
    public void findAllDevCenters(){
        devCenterService.findAllDevCenters();
    }
    //todo figure out what info i will have
//    @RequestMapping("/findByID")
//    public Optional<Role> findById(Long id){
//        Optional<Role> foundRole = roleService.findByID();
//        return foundRole;
//    }
    //todo figure out what info i will have
    @DeleteMapping(value = "/delete")
    public void delete(DevCenter devCenter){
        devCenterService.deleteDevCenter(devCenter);
    }
    //todo figure out what info i will have
    @PatchMapping("/save")
    public void saveDevCenter(DevCenter devCenter){
        devCenterService.saveDevCenter(devCenter);
    }

    //todo:this endpoint after basic endpoints
    @PatchMapping(value = "/admin/change/{title}")
    public void changeDevCenter(@PathVariable String title){
        //check step repo so we can find by the step name
    }

    //todo:this endpoint after basic endpoints
    //  @PutMapping(value = "/admin/insert/{title}")
    // public void insertRole(Role role){

    // }
}
