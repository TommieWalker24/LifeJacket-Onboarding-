package com.juniorAssociate.RSI.lifeJacket.Controllers;

import com.juniorAssociate.RSI.lifeJacket.Entities.DevCenter;
import com.juniorAssociate.RSI.lifeJacket.Services.DevCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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
}
