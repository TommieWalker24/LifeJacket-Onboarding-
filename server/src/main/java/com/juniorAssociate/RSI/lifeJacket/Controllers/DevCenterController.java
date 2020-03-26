package com.juniorAssociate.RSI.lifeJacket.Controllers;

import com.juniorAssociate.RSI.lifeJacket.Entities.DevCenter;
import com.juniorAssociate.RSI.lifeJacket.Services.DevCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/DevCenter")
public class DevCenterController {
    @Autowired
    private DevCenterService devCenterService;

    @PatchMapping(value = "/saveAll")
    public void saveAllDevCenters() {
        devCenterService.saveAllDevCenters();
    }

    @RequestMapping(value = "/findAll")
    public List<DevCenter>findAllDevCenters(){
        return devCenterService.findAllDevCenters();
    }

    @RequestMapping("/findByLocation/{location}")
    public DevCenter findByLocation(@PathVariable String location){
        DevCenter devCenter = devCenterService.findByLocation(location);
        return devCenter;
    }
    @PatchMapping("/save/{id}")
    public void saveDevCenter(@PathVariable String id){
        devCenterService.saveDevCenter(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable String id){
        devCenterService.deleteDevCenter(id);
    }
}
