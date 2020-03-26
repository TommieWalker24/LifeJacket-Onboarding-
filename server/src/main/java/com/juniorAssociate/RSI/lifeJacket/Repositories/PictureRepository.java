//package com.juniorAssociate.RSI.lifeJacket.Repositories;
//
//import com.juniorAssociate.RSI.lifeJacket.Entities.Picture;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//@Repository
//public abstract class PictureRepository implements PictureRepo {
//    public abstract Picture findByPictureId(Long id);
//
//    @PersistenceContext
//   private EntityManager entityManager;
//
//
//    @Transactional
//    public void insertPicture(Picture picture) {
//        entityManager.createNativeQuery("INSERT INTO picture (picture_id, image) VALUES (?,?)")
//                .setParameter(1, picture.getPictureId())
//                .setParameter(2, picture.getImage())
//                .executeUpdate();
//    }
//}
