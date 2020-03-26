//package com.juniorAssociate.RSI.lifeJacket.Controllers;
//
//
//import com.juniorAssociate.RSI.lifeJacket.Services.PictureService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.awt.*;
//import java.io.IOException;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/picture")
//public class PictureController {
//    @Autowired
//    private PictureService pictureService;
//@PutMapping("/insert")
//    public void insertPicture(@RequestBody String path) throws IOException {
//    pictureService.insertPicture(path);
//}
//@PutMapping("/insertUrl")
//    public void insertPictureFromUrl(@RequestBody String url)throws IOException{
//    pictureService.insertPictureFromUrl(url);
//}
//
//@RequestMapping("/getImage/{id}")
//    public Image getImage(@PathVariable Long id){
//    return pictureService.getPictureImage(id);
//}
//}
