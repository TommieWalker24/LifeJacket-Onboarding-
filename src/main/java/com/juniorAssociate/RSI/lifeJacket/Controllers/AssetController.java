package com.juniorAssociate.RSI.lifeJacket.Controllers;

import com.juniorAssociate.RSI.lifeJacket.Entities.Asset;
import com.juniorAssociate.RSI.lifeJacket.Services.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PatchMapping(value = "/saveAll")
    public void saveAllAssets() {
        assetService.saveAllAssets();
    }

    @RequestMapping(value = "/findAll")
    public List<Asset> findAllAssets(){
        return assetService.findAllAssets();
    }
    //todo figure out what info i will have
    @RequestMapping("/findByID")
    public Asset findById(@RequestBody Long id){
        return assetService.findByID(id);
    }
    //todo figure out what info i will have
    @DeleteMapping(value = "/delete")
    public void delete(@RequestBody Long id){
        assetService.deleteAsset(id);
    }
    //todo figure out what info i will have
    @PatchMapping("/save")
    public void saveAsset(@RequestBody Long id){
        assetService.saveAsset(id);
    }

}
