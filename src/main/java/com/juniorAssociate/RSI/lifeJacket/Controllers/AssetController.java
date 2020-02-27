package com.juniorAssociate.RSI.lifeJacket.Controllers;

import com.juniorAssociate.RSI.lifeJacket.Entities.Asset;
import com.juniorAssociate.RSI.lifeJacket.Services.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asset")
public class AssetController {
    @Autowired
    private AssetService assetService;

    @RequestMapping("/")
    public String Helloworld (){
        return "Assets are cool.java!!!";
    }

    @RequestMapping(value = "/getAll")
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }

    @PatchMapping(value = "/saveAll")
    public void saveAllAssets() {
        assetService.saveAllAssets();
    }

    @RequestMapping(value = "/findAll")
    public void findAllAssets(){
        assetService.findAllAssets();
    }
    //todo figure out what info i will have
//    @RequestMapping("/findByID")
//    public Optional<Role> findById(Long id){
//        Optional<Role> foundRole = roleService.findByID();
//        return foundRole;
//    }
    //todo figure out what info i will have
    @DeleteMapping(value = "/delete")
    public void delete(Asset asset){
        assetService.deleteAsset(asset);
    }
    //todo figure out what info i will have
    @PatchMapping("/save")
    public void saveAsset(Asset asset){
        assetService.saveAsset(asset);
    }



    //todo:this endpoint after basic endpoints
    //  @PutMapping(value = "/admin/insert/{title}")
    // public void insertRole(Role role){

    // }
}
