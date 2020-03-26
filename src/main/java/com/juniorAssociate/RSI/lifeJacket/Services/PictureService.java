//package com.juniorAssociate.RSI.lifeJacket.Services;
//
//import com.juniorAssociate.RSI.lifeJacket.Entities.Picture;
//import com.juniorAssociate.RSI.lifeJacket.Repositories.PictureRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.stereotype.Service;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.net.URL;
//
//@Service
//public class PictureService {
//    @Autowired
//    private PictureRepository pictureRepository;
//
//    public void insertPicture(String picturePath) throws IOException {
//        Picture picture = new Picture();
//        try{
//            File pictureFile = new File(picturePath);
//            FileInputStream fileInputStream = new FileInputStream(pictureFile);
//            picture.setImage(fileInputStream.readAllBytes());
//            pictureRepository.insertPicture(picture);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void insertPictureFromUrl(String webLocation) throws IOException {
//        BufferedImage image = null;
//        Picture picture = new Picture();
//        try {
//            URL url = new URL(webLocation);
//            image = ImageIO.read(url);
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//        if(image != null){
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ImageIO.write(image, "png",baos);
//            baos.flush();
//            byte[] imageInBytes = baos.toByteArray();
//            picture.setImage(imageInBytes);
//            baos.close();
//            pictureRepository.insertPicture(picture);
//        }
//    }
//
//    public Image getPictureImage(Long id) {
//        Picture picture = pictureRepository.findByPictureId(id);
//        byte[] image = picture.getImage();
//        ByteArrayInputStream bais = new ByteArrayInputStream(image);
//        try {
//            return ImageIO.read(bais);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
