package com.juniorAssociate.RSI.lifeJacket.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
This class directly generates and describes an sql table "steps"
Table ID:
    o	pictureId
Non-Null fields include
    o	pictureId


Non-Null fields in database include
    o	picture_id

Relations:
    o	Many-To-One: Steps  - allows many pictures to be associated to a particular step.


@author: Tommie Walker
@version: 1.0.0
 */
@Entity
@Table(name="picture")
public class Picture {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "picture_id", insertable = false)
    long pictureId;

    @Column
    byte[] image;

    @ManyToOne
    Steps step;


    public long getPictureId() {
        return pictureId;
    }

    public void setPictureId(long pictureId) {
        this.pictureId = pictureId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
